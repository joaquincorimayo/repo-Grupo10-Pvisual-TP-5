package ar.edu.unju.fi.tp5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.entity.Beca;
import ar.edu.unju.fi.tp5.entity.Curso;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.service.ICursoService;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
@RequestMapping("/beca")
public class BecaController {

	@Autowired
	@Qualifier("BecaServiceImpList")
	private IBecaService becaService;

	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;

	Logger logger = LoggerFactory.getLogger(BecaController.class);

	@GetMapping("/nuevo")
	public String getNewBecaPage(Model model) {
		logger.info("Method: getNewBecaPage() - Information: Envia un objeto Beca");
		model.addAttribute("beca", becaService.getBeca());
		model.addAttribute("cursos", cursoService.listarCursos());
		return "nuevo_beca";
	}

	@PostMapping("/guardar")
	public String saveNewBecaPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Method: saveNewBecaPage() - Information: Error en ingreso de datos para beca.");
			model.addAttribute("cursos", cursoService.listarCursos());
			model.addAttribute("beca", beca);
			return "nuevo_beca";
		}
		
		try {
			Curso curso = cursoService.buscarCurso(beca.getCurso().getId());
			beca.setCurso(curso);
			becaService.guardarBeca(beca);
		} catch (Exception e) {
			model.addAttribute("beca", beca);
			model.addAttribute("cursos", cursoService.listarCursos());
			return "nuevo_beca";
		}
		return "redirect:/beca/listaBecas";
	}

	@GetMapping("/listaBecas")
	public ModelAndView getListBecaPage() {
		ModelAndView mav = new ModelAndView("lista_becas");
		List<Beca> becas = becaService.listarBecas();
		mav.addObject("becas", becas);
		return mav;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarBecaPage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarBecaPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_beca");
		Beca beca = becaService.buscarBeca(id);
		mav.addObject("beca", beca);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosBeca(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("Method: editarDatosBeca() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		becaService.modificarBeca(beca);
		ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
		return mav;
	}

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarDatosBeca(@PathVariable(value = "id") Long id) {
		logger.info("Method: eliminarDatosBeca() - Information: ");
		ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
		becaService.eliminarBeca(id);
		return mav;
	}

}