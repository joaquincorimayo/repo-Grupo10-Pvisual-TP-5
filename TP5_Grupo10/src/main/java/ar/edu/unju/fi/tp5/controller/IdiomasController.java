package ar.edu.unju.fi.tp5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.service.ICursoService;

@Controller
public class IdiomasController {

//	ListaCursos cursosDisponibles = new ListaCursos();
	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	@GetMapping("/idiomas")
	public String getIdiomasPage(Model model) {
		model.addAttribute("cursos",cursoService.getListaCursos());
		return "idiomas";
	}
}
