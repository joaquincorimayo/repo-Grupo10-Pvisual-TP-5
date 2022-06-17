package ar.edu.unju.fi.tp5.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.entity.Alumno;
import ar.edu.unju.fi.tp5.entity.AlumnoCurso;
import ar.edu.unju.fi.tp5.service.IAlumnoCursoService;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.service.ICursoService;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
@RequestMapping("/inscripcion")
public class AlumnoCursoController {
	private static final Log logs = LogFactory.getLog(AlumnoCursoController.class);

	@Autowired
	IAlumnoCursoService alumnoCursoService;
	@Autowired
	IAlumnoService alumnoService;
	@Autowired
	ICursoService cursoService;

	@GetMapping("/nuevaInscripcion/{id}")
	public ModelAndView agregarInscripcion(@PathVariable(value = "id") Long id) {
		logs.info("Nueva incripcion");
		ModelAndView modelView = new ModelAndView("inscripcion");
		modelView.addObject("unaInscripcion", alumnoCursoService.nuevoAlumnoCurso());
		Alumno alumno = alumnoService.buscarAlumno(id);
		modelView.addObject("alumno", alumno);
		modelView.addObject("cursos", cursoService.listarCursos());
		return modelView;
	}

	@PostMapping("/guardarInscripcion")
	public ModelAndView guardarInscripcion(@Valid @ModelAttribute("unaInscripcion") AlumnoCurso alumnoCursoNuevo,
			BindingResult resultado) {
		ModelAndView modelView = new ModelAndView();

		if (resultado.hasErrors()) {
			modelView = new ModelAndView("inscripcion");
			modelView.addObject("unaInscripcion", alumnoCursoNuevo);
			return modelView;
		}
		alumnoCursoService.guardarAlumnoCurso(alumnoCursoNuevo);
		modelView = new ModelAndView("redirect:/alumno/listaAlumnos");
		return modelView;
	}

}
