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

import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	Logger logger = LoggerFactory.getLogger(DocenteController.class);
	
	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;

	@GetMapping("/nuevo")
	public String getFormularioDocenteNuevoPage(Model model) {
		// Se envia un objeto de tipo Docente a la pagina nuevo_docente.html
		model.addAttribute("docente", docenteService.getDocente());
		logger.info("Method: getFormularioDocenteNuevoPage() - Information: Se envia un objeto Docente a la pagina nuevo_docente");
		return "nuevo_docente";
	}

	@PostMapping("/guardar")
	public ModelAndView saveNewDocentePage(@Validated @ModelAttribute("docente") Docente docente,
			BindingResult bindingResult) {
		// @Validate proviene de Spring Framework Validation
		// el objeto bindingResult contiene el resultado de la validacion,
		// (los errores que pueden haber ocurrido)
		// Control de validacion para el nuevo docente.
		ModelAndView mav;
		if (bindingResult.hasErrors()) {
			logger.info("Method: saveNewDocentePage() - Information: Error en ingreso de datos para Docente.");
			mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		
		boolean status = docenteService.guardarDocente(docente);

		if (status) {
			logger.info("Method: saveNewDocentePage() - Information: Se agrego al nuevo docente.");
			mav = new ModelAndView("redirect:/docente/listaDocentes");
		}
		else {
			logger.info("Method: saveNewDocentePage() - Information: No Se agrego al nuevo docente.");
			mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			mav.addObject("status", status);
		}
		return mav;
	}
	
	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		logger.info("Method: getListadoDocentePage() - Information: Se recuperan los regitros de la BD para Docente");
		// Permite visualizar docentes que contiene el arraylist
		ModelAndView mav = new ModelAndView("lista_docentes");
		List<Docente> docentes = docenteService.getListaDocente();
		mav.addObject("docentes", docentes);
		return mav;
	}

	// Peticiones de editar y eliminar

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarDocentePage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarDocentePage() - Information: Se edita al Docente con id "+id);
		ModelAndView mav = new ModelAndView("edicion_docente");
		Optional<Docente> docente = docenteService.buscarDocente(id);
		mav.addObject("docente", docente.get());
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docente,
			BindingResult bindingResult) {

		// Validacion de datos
		if (bindingResult.hasErrors()) {
			logger.info("Method: editarDatosDocente() - Information: Error en ingreso de datos");
			ModelAndView mav = new ModelAndView("edicion_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		docenteService.modificarDocente(docente);
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		return mav;
	}

	@GetMapping("/eliminar/{legajo}")
	public ModelAndView eliminarDatosDocente(@PathVariable(value = "legajo") Long id) {
		logger.info("Method: eliminarDatosDocente() - Information: se elimina logicamente al Docente con id "+id);
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		docenteService.eliminarDocente(id);
		return mav;
	}
}
