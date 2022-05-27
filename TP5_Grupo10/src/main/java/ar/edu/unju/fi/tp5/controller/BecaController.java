package ar.edu.unju.fi.tp5.controller;

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

import ar.edu.unju.fi.tp5.model.Beca;
import ar.edu.unju.fi.tp5.service.IBecaService;

@Controller
@RequestMapping("/beca")
public class BecaController {

	@Autowired
	@Qualifier("BecaServiceImpList")
	private IBecaService becaService;

	// private ListaBecas listabeca = new ListaBecas();
	Logger logger = LoggerFactory.getLogger(BecaController.class);

	@GetMapping("/nuevo")
	public String getFormularioBecaNuevoPage(Model model) {
		model.addAttribute("beca", becaService.getBeca());
		logger.info(
				"Method: getFormularioBecaNuevoPage() - Information: Se envia un objeto Beca a la pagina nuevo_beca");
		return "nuevo_beca";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaBecaPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca", beca);
			return mav;
		}

		ModelAndView mav = new ModelAndView("lista_becas");
		if (becaService.guardarBeca(beca)) {
			logger.info("Method: getListaBecaPage() - Information: Se agregó un objeto al arrayList de beca");
		}
		mav.addObject("becas", becaService.getListaBecas().getBecas());
		return mav;
	}

	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecaPage() {
		logger.info("Method: getListadoBecaPage() - Information: Se visualiza las becas registradas");
		ModelAndView mav = new ModelAndView("lista_becas");
		mav.addObject("becas", becaService.getListaBecas().getBecas());
		return mav;
	}
	
	// Peticiones de editar y eliminar

	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarBecaPage(@PathVariable(value = "codigo") int codigo) {
		logger.info("Method: getEditarBecaPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_beca");
		Beca beca = becaService.buscarBeca(codigo);
		mav.addObject("beca", beca);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosBeca(@Validated @ModelAttribute("beca") Beca beca,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("Method: editarDatosBeca() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
		becaService.modificarBeca(beca);
		return mav;
	}

	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarDatosBeca(@PathVariable(value = "codigo") int codigo) {
		logger.info("Method: eliminarDatosBeca() - Information: ");
		ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
		becaService.eliminarBeca(codigo);
		return mav;
	}

}