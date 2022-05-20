package ar.edu.unju.fi.tp5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger logger = LoggerFactory.getLogger(CursoController.class);
	private ListaCursos listaCurso = new ListaCursos();
	
	@GetMapping("/nuevo")
	public String getFormularioCursoNuevoPage(Model model) {
		model.addAttribute("curso", new Curso());
		logger.info(
				"Method: getFormularioCursoNuevoPage() - Information: Se envia un objeto Curso a la pagina nuevo_curso");
		return "nuevo_curso";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCursoPage(@ModelAttribute("curso") Curso curso) {
		ModelAndView mav = new ModelAndView("lista_cursos");
		
		if(listaCurso.getCursos().add(curso)) {
			logger.info("Method: getListaCursoPage() - Information: Se agregó un objeto al arrayList de curso");
		}
		
		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
	
	@GetMapping("/listaCursos")
	public ModelAndView getListaCursosPage() {
		logger.info("Method: getListadoCursoPage() - Information: Se visualiza los cursos registrados");
		ModelAndView mav = new ModelAndView("lista_cursos");
		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
	
	

}
