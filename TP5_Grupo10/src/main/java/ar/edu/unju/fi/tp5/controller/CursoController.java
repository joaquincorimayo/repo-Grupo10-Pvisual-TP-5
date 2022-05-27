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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.service.ICursoService;


@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	Logger logger = LoggerFactory.getLogger(CursoController.class);
	
	@GetMapping("/nuevo")
	public String getFormularioCursoNuevoPage(Model model) {
		model.addAttribute("curso", cursoService.getCurso());
		logger.info(
				"Method: getFormularioCursoNuevoPage() - Information: Se envia un objeto Curso a la pagina nuevo_curso");
		return "nuevo_curso";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {
		//@Validate proviene de Spring Framework Validation
		//el objeto bindingResult contiene el resultado de la validacion,
		//(los errores que pueden haber ocurrido)
		if (bindingResult.hasErrors()){
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_cursos");
		// recupero el arrayList y agrego un objeto curso a lista
		if(cursoService.guardarCurso(curso)) {
			logger.info("Method: getListaCursoPage() - Information: Se agregó un objeto al arrayList de curso");
		}
		// enviar el arrayList a curso a la página lista_cursos
		mav.addObject("cursos", cursoService.getListaCursos().getCursos());
		return mav;
	}
	
	@GetMapping("/listaCursos")
	public ModelAndView getListaCursosPage() {
		logger.info("Method: getListadoCursoPage() - Information: Se visualiza los cursos registrados");
		ModelAndView mav = new ModelAndView("lista_cursos");
		mav.addObject("cursos", cursoService.getListaCursos().getCursos());
		return mav;
	}
}