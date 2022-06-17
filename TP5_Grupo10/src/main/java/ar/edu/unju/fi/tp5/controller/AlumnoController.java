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

import ar.edu.unju.fi.tp5.entity.Alumno;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.service.ICursoService;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

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
	public ModelAndView getFormANewPage(Model model) {
		ModelAndView mav = new ModelAndView("nuevo_alumno");
		mav.addObject("alumno", alumnoService.getAlumno());
		mav.addObject("cursos", cursoService.listarCursos());
		return mav;
	}

	@PostMapping("/guardar")
	public String saveNewAlumnoPage(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bR, Model model) {
		if (bR.hasErrors()) {
			logger.info("Method: saveNewAlumnoPage() - Information: Error en ingreso de datos para Alumno.");
			model.addAttribute("cursos", cursoService.listarCursos());
			model.addAttribute("alumno", alumno);
			return "nuevo_alumno";
		}

		try {
			alumnoService.guardarAlumno(alumno);
		} catch (Exception e) {
			model.addAttribute("alumno", alumno);
		}
		model.addAttribute("alumno", alumno);
		return "redirect:/alumno/listaAlumnos";
	}

	@GetMapping("/listaAlumnos")
	public ModelAndView getListAlumnoPage() {
		logger.info("Method: getListAlumnoPage() - Information: Se recuperan los regitros de la BD para Alumnos");
		ModelAndView mav = new ModelAndView("lista_alumnos");
		List<Alumno> alumnos = alumnoService.listarAlumnos();
		mav.addObject("alumnos", alumnos);
		return mav;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarAlumnoPage() - Information: Se edita al Alumno con id " + id);
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Alumno alumno = alumnoService.buscarAlumno(id);
		System.out.println("1 RECIBO ESTO: -> " + alumno.toString());
		mav.addObject("alumno", alumno);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult br) {
		// Validacion de datos
		if (br.hasErrors()) {
			logger.info("Method: editarDatosAlumno() - Information: Error en ingreso de datos");
			ModelAndView mav = new ModelAndView("edicion_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		System.out.println("2 RECIBO ESTO: -> " + alumno.toString());
		alumnoService.modificarAlumno(alumno);
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");

		return mav;
	}

	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarDatosAlumno(@PathVariable(value = "id") Long id) {
		logger.info("Method: eliminarDatosAlumno() - Information: se elimina logicamente al Alumno con id " + id);
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		alumnoService.eliminarAlumno(id);
		return mav;
	}

}
