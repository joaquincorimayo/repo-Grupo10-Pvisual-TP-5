package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	// Permite mantener consistencia.
	private ListaDocente listaDocente = new ListaDocente();

	@GetMapping("/nuevo")
	public String getFormularioDocenteNuevoPage(Model model) {
		// Se envia un objeto de tipo Docente a la pagina nuevo_docente.html
		model.addAttribute("docente", new Docente());
		return "nuevo_docente";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaDocentePage(@ModelAttribute("docente") Docente docente) {
		// Pagina que voy a devolver
		ModelAndView mav = new ModelAndView("lista_docentes");
		// Realiza la carga de un nuevo objeto (docente 'cargado')
		listaDocente.getDocentes().add(docente);
		// Envia el ArrayList de docentes a la pagina lista_docentes
		mav.addObject("docentes", listaDocente.getDocentes());
		return mav;
	}

	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		// Permite visualizar docentes que contiene el arraylist
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("docentes", listaDocente.getDocentes());
		return mav;
	}

}
