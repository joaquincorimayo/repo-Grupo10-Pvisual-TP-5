package ar.edu.unju.fi.tp5.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.service.ICursoService;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
public class IdiomasController {
	private static final Log logs = LogFactory.getLog(IdiomasController.class);
	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	@GetMapping("/idiomas")
	public String getIdiomasPage(Model model) {
		model.addAttribute("cursos",cursoService.listarCursos());
		return "idiomas";
	}
}
