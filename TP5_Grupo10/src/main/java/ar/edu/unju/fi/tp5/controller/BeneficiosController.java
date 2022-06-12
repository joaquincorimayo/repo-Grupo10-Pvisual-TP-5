package ar.edu.unju.fi.tp5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.service.IDocenteService;

@Controller
public class BeneficiosController {

	@Autowired
	@Qualifier("AlumnoServiceImpList")
	private IAlumnoService alumnoService;

	@Autowired
	@Qualifier("BecaServiceImpList")
	private IBecaService becaService;

	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;

	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;

	@GetMapping("/beneficios")
	public String getBeneficiosPage(Model model) {
		model.addAttribute("alumnos", this.alumnoService.getListaAlumnos());
		model.addAttribute("becas", this.becaService.getListaBecas().getBecas());
		model.addAttribute("cursos", this.cursoService.getListaCursos().getCursos());
		model.addAttribute("docentes", this.docenteService.getListaDocente());
		return "beneficios";
	}
}
