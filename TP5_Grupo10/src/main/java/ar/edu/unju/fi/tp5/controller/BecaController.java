package ar.edu.unju.fi.tp5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Beca;
import ar.edu.unju.fi.tp5.util.ListaBecas;


@Controller
@RequestMapping("/beca")
public class BecaController {
private ListaBecas listabeca = new ListaBecas();
	Logger logger = LoggerFactory.getLogger(BecaController.class);
	@GetMapping("/nuevo")
	public String getFormularioBecaNuevoPage(Model model) {
		model.addAttribute("beca", new Beca());
		logger.info(
				"Method: getFormularioBecaNuevoPage() - Information: Se envia un objeto Beca a la pagina nuevo_beca");
		return "nuevo_beca";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaBecaPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
		//@Validate proviene de Spring Framework Validation
		//el objeto bindingResult contiene el resultado de la validacion,
		//(los errores que pueden haber ocurrido)
		if (bindingResult.hasErrors()){
			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		 
		ModelAndView mav = new ModelAndView("lista_becas");
		// recupero el arrayList y agrego un objeto becas a lista
		if(listabeca.getBecas().add(beca)) {
			logger.info("Method: getListaBecaPage() - Information: Se agregó un objeto al arrayList de beca");
		}
			
		// enviar el arrayList de beca a la página lista_becas
		mav.addObject("becas", listabeca.getBecas());
		return mav;
	}
	
	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecaPage() {
		logger.info("Method: getListadoBecaPage() - Information: Se visualiza las becas registradas");
		ModelAndView mav = new ModelAndView("lista_becas");
		mav.addObject("becas", listabeca.getBecas());
		return mav;
	}

}