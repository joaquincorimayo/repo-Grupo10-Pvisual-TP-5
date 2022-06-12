package ar.edu.unju.fi.tp5.controller;

import java.util.List;

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

import ar.edu.unju.fi.tp5.entity.Curso;
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
	public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso") Curso curso,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			return mav;
		}

		ModelAndView mav = new ModelAndView("lista_cursos");
		if (cursoService.guardarCurso(curso)) {
			logger.info("Method: getListaCursoPage() - Information: Se agregó un objeto al arrayList de curso");
		}
		List<Curso> cursos = cursoService.getListaCursos();
		mav.addObject("cursos", cursos);
		return mav;
	}

	@GetMapping("/listaCursos")
	public ModelAndView getListaCursosPage() {
		logger.info("Method: getListadoCursoPage() - Information: Se visualiza los cursos registrados");
		ModelAndView mav = new ModelAndView("lista_cursos");
		List<Curso> cursos = cursoService.getListaCursos();
		mav.addObject("cursos", cursos);
		return mav;
	}

	// Peticiones de editar y eliminar

	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCursoPage(@PathVariable(value = "codigo") int codigo) {
		logger.info("Method: getEditarCursoPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_curso");
		Curso curso = cursoService.buscarCurso(codigo);
		mav.addObject("curso", curso);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("Method: editarDatosCurso() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_curso");
			mav.addObject("curso", curso);
			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");
		cursoService.modificarCurso(curso);
		return mav;
	}

	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarDatosCurso(@PathVariable(value = "codigo") int codigo) {
		logger.info("Method: eliminarDatosCurso() - Information: ");
		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");
		cursoService.eliminarCurso(codigo);
		return mav;
	}

}