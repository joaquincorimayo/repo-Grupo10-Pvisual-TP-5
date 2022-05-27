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

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;

	Logger logger = LoggerFactory.getLogger(DocenteController.class);

	@GetMapping("/nuevo")
	public String getFormularioDocenteNuevoPage(Model model) {
		// Se envia un objeto de tipo Docente a la pagina nuevo_docente.html
		model.addAttribute("docente", docenteService.getDocente());
		logger.info(
				"Method: getFormularioDocenteNuevoPage() - Information: Se envia un objeto Docente a la pagina nuevo_docente");
		return "nuevo_docente";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaDocentePage(@Validated @ModelAttribute("docente") Docente docente,
			BindingResult bindingResult) {
		// @Validate proviene de Spring Framework Validation
		// el objeto bindingResult contiene el resultado de la validacion,
		// (los errores que pueden haber ocurrido)
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}

		// Pagina que voy a devolver
		ModelAndView mav = new ModelAndView("lista_docentes");
		// Realiza la carga de un nuevo objeto (docente 'cargado')
		if (docenteService.guardarDocente(docente)) {
			logger.info("Method: getListaDocentePage() - Information: Se agregó un objeto al arrayList de docente");
		}

		// Envia el ArrayList de docentes a la pagina lista_docentes
		mav.addObject("docentes", docenteService.getListaDocente().getDocentes());
		return mav;
	}

	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		logger.info("Method: getListadoDocentePage() - Information: Se visualiza los docentes registrados");
		// Permite visualizar docentes que contiene el arraylist
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("docentes", docenteService.getListaDocente().getDocentes());
		return mav;
	}

	// Peticiones de editar y eliminar

	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value = "legajo") int legajo) {
		logger.info("Method: getEditarDocentePage() - Information: ");
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente docente = docenteService.buscarDocente(legajo);
		mav.addObject("docente", docente);
		return mav;
	}

	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docente,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("Method: editarDatosDocente() - Information: Error");
			ModelAndView mav = new ModelAndView("edicion_docente");
			mav.addObject("docente", docente);
			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		docenteService.modificarDocente(docente);
		return mav;
	}

	@GetMapping("/eliminar/{legajo}")
	public ModelAndView eliminarDatosDocente(@PathVariable(value = "legajo") int legajo) {
		logger.info("Method: eliminarDatosDocente() - Information: ");
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		docenteService.eliminarDocente(legajo);
		return mav;
	}

}
