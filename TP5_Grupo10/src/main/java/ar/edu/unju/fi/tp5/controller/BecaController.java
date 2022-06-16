package ar.edu.unju.fi.tp5.controller;

import java.util.List;
import java.util.Optional;

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
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.service.ICursoService;

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
		model.addAttribute("cursos", cursoService.getListaCursos());
		return "nuevo_beca";

	}

	@PostMapping("/guardar")
	public ModelAndView saveNewBecaPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
		ModelAndView mav;
		if (bindingResult.hasErrors()) {
			logger.info("Method: saveNewBecaPage() - Information: Error en ingreso de datos para beca.");
			mav = new ModelAndView("nuevo_beca");
			mav.addObject("cursos", cursoService.getListaCursos());
			mav.addObject("beca", beca);
			return mav;
		}

		boolean status = becaService.guardarBeca(beca);

		if (status) {
			logger.info("Method: saveNewBecaPage() - Information: Se agrego la beca.");
			mav = new ModelAndView("redirect:/beca/listaBecas");
		} else {
			logger.info("Method: saveNewBecaPage() - Information: No se agrego la beca.");
			mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca", beca);
			mav.addObject("status", status);
		}

		return mav;
	}

	@GetMapping("/listaBecas")
	public ModelAndView getListBecaPage() {
		ModelAndView mav;
		if (becaService.getListaBecas().size() == 0) {
			mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca", becaService.getBeca());
			mav.addObject("cursos", cursoService.getListaCursos());

		} else {
			logger.info("Method: getListBecaPage() - Information: Se visualiza las becas registradas");
			mav = new ModelAndView("lista_becas");
			List<Beca> becas = becaService.getListaBecas();
			mav.addObject("becas", becas);
		}

		return mav;
	}

	// Peticiones de editar y eliminar

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarBecaPage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarBecaPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_beca");
		Optional<Beca> beca = becaService.buscarBeca(id);
		mav.addObject("beca", beca.get());
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