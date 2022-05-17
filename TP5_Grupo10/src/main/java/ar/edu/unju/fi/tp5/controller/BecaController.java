package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@GetMapping("/nuevo")
	public String getFormularioBecaNuevoPage(Model model) {
		model.addAttribute("beca", new Beca());
		return "nuevo_beca";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaBecaPage(@ModelAttribute("beca") Beca beca) {
		ModelAndView mav = new ModelAndView("lista_becas");
		// recupero el arrayList y agrego un objeto becas a lista
		listabeca.getBecas().add(beca);
			
		// enviar el arrayList de beca a la página lista_becas
		mav.addObject("becas", listabeca.getBecas());
		return mav;
	}
	
	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecaPage() {
		ModelAndView mav = new ModelAndView("lista_becas");
		mav.addObject("becas", listabeca.getBecas());
		return mav;
	}

}