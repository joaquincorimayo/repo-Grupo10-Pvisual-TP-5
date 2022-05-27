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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.service.IAlumnoService;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	@Qualifier("AlumnoServiceImpList")
	private IAlumnoService alumnoService;
	
	Logger logger = LoggerFactory.getLogger(AlumnoController.class);

	@GetMapping("/nuevo")
	public String getFormularioAlumnoNuevoPage(Model model) {
		model.addAttribute("alumno", alumnoService.getAlumno());
		logger.info(
				"Method: getFormularioAlumnoNuevoPage() - Information: Se envia un objeto Alumno a la pagina nuevo_alumno");
		return "nuevo_alumno";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaAlumnoPage(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_alumnos");

		if(alumnoService.guardarAlumno(alumno)) {
			logger.info("Method: getListaAlumnoPage() - Information: Se agregó un objeto al arrayList de alumno");
		}
		
		mav.addObject("alumnos", alumnoService.getListaAlumnos().getAlumnos());
		return mav;
	}

	@GetMapping("/listaAlumnos")
	public ModelAndView getListadoAlumnoPage() {
		logger.info("Method: getListadoAlumnoPage() - Information: Se visualiza los alumnos registrados");
		ModelAndView mav = new ModelAndView("lista_alumnos");
		mav.addObject("alumnos", alumnoService.getListaAlumnos().getAlumnos());
		return mav;
	}
	
	// Peticiones de editar y eliminar 
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable(value="dni") String dni) {
		logger.info("Method: getEditarAlumnoPage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Alumno alumno = alumnoService.buscarAlumno(dni);
		mav.addObject("alumno", alumno);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()){
			logger.info("Method: editarDatosAlumno() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		alumnoService.modificarAlumno(alumno);
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView eliminarDatosAlumno(@PathVariable(value="dni") String dni) {
		logger.info("Method: eliminarDatosAlumno() - Information: ");
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		alumnoService.eliminarAlumno(dni);
		return mav;
	}

}