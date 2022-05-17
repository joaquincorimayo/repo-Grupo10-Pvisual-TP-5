package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.util.ListaCursos;

@Controller
public class IdiomasController {

	ListaCursos cursosDisponibles = new ListaCursos();

	@GetMapping("/idiomas")
	public String getIdiomasPage(Model model) {
		model.addAttribute("cursos", cursosDisponibles.getCursos());
		return "idiomas";
	}
}
