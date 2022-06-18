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

import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 *
 */

@Controller
@RequestMapping("/docente")
public class DocenteController {
	Logger logger = LoggerFactory.getLogger(DocenteController.class);

	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;

	@GetMapping("/nuevo")
	public String getFormularioDocenteNuevoPage(Model model) {
		model.addAttribute("docente", docenteService.getDocente());
		logger.info(
				"Method: getFormularioDocenteNuevoPage() - Information: Se envia un objeto Docente a la pagina nuevo_docente");
		return "nuevo_docente";
	}

	@PostMapping("/guardar")
	public String saveNewDocentePage(@Validated @ModelAttribute("docente") Docente docente, BindingResult br,
			Model model) {

		if (br.hasErrors()) {
			logger.info("Method: saveNewDocentePage() - Information: Error en ingreso de datos para Docente.");
			model.addAttribute("docente", docente);
			return "nuevo_docente";
		}

		try {
			docenteService.guardarDocente(docente);
		} catch (Exception e) {
			model.addAttribute("docente", docente);
		}
		model.addAttribute("docente", docente);
		return "redirect:/docente/listaDocentes";
	}

	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		logger.info("Method: getListadoDocentePage() - Information: Se recuperan los regitros de la BD para Docente");
		ModelAndView mav = new ModelAndView("lista_docentes");
		List<Docente> docentes = docenteService.listarDocentes();
		mav.addObject("docentes", docentes);
		return mav;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView getEditarDocentePage(@PathVariable(value = "id") Long id) {
		logger.info("Method: getEditarDocentePage() - Information: Se edita al Docente con id " + id);
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente docente = docenteService.buscarDocente(id);

		mav.addObject("docente", docente);
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
		logger.info("Method: eliminarDatosDocente() - Information: se elimina logicamente al Docente con id " + id);
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		docenteService.eliminarDocente(id);
		return mav;
	}
}
