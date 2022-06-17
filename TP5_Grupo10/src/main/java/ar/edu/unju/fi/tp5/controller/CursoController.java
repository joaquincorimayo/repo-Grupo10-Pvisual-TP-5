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
import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.service.IDocenteService;
import ar.edu.unju.fi.tp5.util.ListaCategoriasCurso;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	ListaCategoriasCurso categorias;
	
	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;

	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;

	Logger logger = LoggerFactory.getLogger(CursoController.class);

	@GetMapping("/nuevo")
	public String getFormNewCursoPage(Model model) {
		model.addAttribute("curso", cursoService.nuevoCurso());
		model.addAttribute("docentes", docenteService.listarDocentes());
		model.addAttribute("categorias", categorias.getCategorias());
		logger.info("Method: getFormNewCursoPage() - Information: Se envia un nuevo objeto Curso");
		return "nuevo_curso";
	}

	@PostMapping("/guardar")
	public ModelAndView saveNewCursoPage(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {
		ModelAndView mav;
		
		if (bindingResult.hasErrors()) {
			logger.info("Method: saveNewCursoPage() - Information: Error en ingreso de datos para Curso.");
			mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			mav.addObject("docentes", docenteService.listarDocentes());
			mav.addObject("categorias", categorias.getCategorias());
			return mav;
		}

		try {
			logger.info("Method: saveNewCursoPage() - Information: Se agregó el curso");
			Docente docente = docenteService.buscarDocente(curso.getDocente().getId());
			curso.setDocente(docente);
			curso.setCategoria(curso.getCategoria());
			cursoService.guardarCurso(curso);
			System.out.println(curso.toString());
			mav = new ModelAndView("redirect:/curso/listaCursos");
		} catch (Exception e) {
			System.out.println("error -> " +e.getMessage());
			logger.info("Method: saveNewCursoPage() - Information: ERROR al agregar el curso");
			mav = new ModelAndView("nuevo_curso");
			mav.addObject("docentes", docenteService.listarDocentes());
			mav.addObject("categorias", categorias.getCategorias());
			mav.addObject("curso", curso);
		}

		return mav;
	}

	@GetMapping("/listaCursos")
	public ModelAndView getListaCursosPage() {
		logger.info("Method: getListadoCursoPage() - Information: Se recuperan los regitros de la BD para Cursos");
		ModelAndView mav = new ModelAndView("lista_cursos");
		List<Curso> cursos = cursoService.listarCursos();
		mav.addObject("cursos", cursos);
		return mav;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarCursoPage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarCursoPage() - Information: Se edita al Alumno con id " + id);
		ModelAndView mav = new ModelAndView("edicion_curso");
		Curso curso =cursoService.buscarCurso(id);
		mav.addObject("docentes", docenteService.listarDocentes());
		mav.addObject("curso", curso);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("Method: editarDatosCurso() - Information: Error en ingreso de datos");
			System.out.println("ERROR EN DATOOO: " + curso.toString());
			ModelAndView mav = new ModelAndView("edicion_curso");
			mav.addObject("curso", curso);
			return mav;
		}

		cursoService.modificarCurso(curso);
		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");

		return mav;
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarDatosCurso(@PathVariable(value = "id") Long id) {
		logger.info("Method: eliminarDatosCurso() - Information: se elimina logicamente al Curso con id " + id);
		cursoService.eliminarCurso(id);
		return "redirect:/curso/listaCursos";
	}
}