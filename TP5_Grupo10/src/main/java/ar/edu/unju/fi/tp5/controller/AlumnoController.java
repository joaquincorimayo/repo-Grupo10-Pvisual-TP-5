package ar.edu.unju.fi.tp5.controller;

import java.util.List;
import java.util.Optional;

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

import ar.edu.unju.fi.tp5.entity.Alumno;
import ar.edu.unju.fi.tp5.entity.Curso;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.service.ICursoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	@Qualifier("AlumnoServiceImpList")
	private IAlumnoService alumnoService;

	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	
	@GetMapping("/nuevo")
	public String getFormANewPage(Model model) {
		model.addAttribute("alumno", alumnoService.getAlumno());
		model.addAttribute("cursos", cursoService.getListaCursos());
		logger.info("Method: getFormANewPage() - Information: Se envia un objeto Alumno a la pagina nuevo_alumno");
		return "nuevo_alumno";
	}

	@PostMapping("/guardar")
	public ModelAndView saveNewAlumnoPage(@Validated @ModelAttribute("alumno") Alumno alumno,
			BindingResult bR) {
		ModelAndView mav;
		
		// Control de validacion para el nuevo alumno.
		if (bR.hasErrors()) {
			logger.info("Method: saveNewAlumnoPage() - Information: Error en ingreso de datos para Alumno.");
			mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		
		boolean status = alumnoService.guardarAlumno(alumno);
		
		if (status) {
			logger.info("Method: saveNewAlumnoPage() - Information: Se agrego al nuevo alumno.");
			mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		} else {
			logger.info("Method: saveNewAlumnoPage() - Information: No Se agrego al nuevo alumno.");
			mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			mav.addObject("status", status);
		}
		
		return mav;
	}

	@GetMapping("/listaAlumnos")
	public ModelAndView getListAlumnoPage() {
		logger.info("Method: getListAlumnoPage() - Information: Se recuperan los regitros de la BD para Alumnos");
		ModelAndView mav = new ModelAndView("lista_alumnos");
		List<Alumno> alumnos = alumnoService.getListaAlumnos();
		mav.addObject("alumnos", alumnos);
		return mav;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarAlumnoPage() - Information: Se edita al Alumno con id "+id);
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Optional<Alumno> alumno = alumnoService.buscarAlumno(id);
		mav.addObject("alumno", alumno.get());
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno,
			BindingResult br) {
		// Validacion de datos
		if (br.hasErrors()) {
			logger.info("Method: editarDatosAlumno() - Information: Error en ingreso de datos");
			ModelAndView mav = new ModelAndView("edicion_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		alumnoService.modificarAlumno(alumno);
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		return mav;
	}

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarDatosAlumno(@PathVariable(value = "id") Long id) {
		logger.info("Method: eliminarDatosAlumno() - Information: se elimina logicamente al Alumno con id "+id);
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		alumnoService.eliminarAlumno(id);
		return mav;
	}
}
