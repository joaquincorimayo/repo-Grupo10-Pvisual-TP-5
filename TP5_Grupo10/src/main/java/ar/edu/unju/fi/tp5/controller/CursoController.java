package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.util.ListaCursos;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	private ListaCursos listaCurso = new ListaCursos();
	
	@GetMapping("/nuevo")
	public String getFormularioCursoNuevoPage(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo_curso";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCursoPage(@ModelAttribute("curso") Curso curso) {
		ModelAndView mav = new ModelAndView("lista_cursos");
		listaCurso.getCursos().add(curso);
		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
	
	@GetMapping("/listaCursos")
	public ModelAndView getListaCursosPage() {
		ModelAndView mav = new ModelAndView("lista_cursos");
		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
	
	

}
