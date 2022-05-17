package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.util.ListaDocente;

@Controller
public class DocenteController {
	private ListaDocente listaDocente = new ListaDocente();
	
	@GetMapping("/nuevo")
	public String getFormularioDocenteNuevoPage(Model model) {
		model.addAttribute("docente", new Docente());
		return "nuevo_docente";
	}
	
}
