package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendaController {
	@GetMapping("/agenda")
	public String getBeneficiosPage(Model model) {
		return "agenda";
	}
}
