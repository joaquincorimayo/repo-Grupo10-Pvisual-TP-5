package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	private ListaAlumnos listaAlumno = new ListaAlumnos();

	@GetMapping("/nuevo")
	public String getFormularioAlumnoNuevoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaAlumnoPage(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView mav = new ModelAndView("lista_alumnos");
		this.listaAlumno.getAlumnos().add(alumno);
		// enviar el arrayList de alumno a la página lista_alumnos
		mav.addObject("alumnos", this.listaAlumno.getAlumnos());
		return mav;
	}

	@GetMapping("/listaAlumnos")
	public ModelAndView getListadoAlumnoPage() {
		ModelAndView mav = new ModelAndView("lista_alumnos");
		mav.addObject("alumnos", this.listaAlumno.getAlumnos());
		return mav;
	}

}