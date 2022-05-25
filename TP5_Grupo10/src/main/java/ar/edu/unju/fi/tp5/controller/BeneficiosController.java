package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.util.ListaAlumnos;
import ar.edu.unju.fi.tp5.util.ListaBecas;
import ar.edu.unju.fi.tp5.util.ListaCursos;
import ar.edu.unju.fi.tp5.util.ListaDocente;


@Controller
public class BeneficiosController {
	private ListaAlumnos alumnos = new ListaAlumnos();
	private ListaBecas becas = new ListaBecas();
	private ListaCursos cursos = new ListaCursos();
	private ListaDocente docentes = new ListaDocente();
	
	@GetMapping("/beneficios")
	public String getBeneficiosPage(Model model) {
		model.addAttribute("alumnos", this.alumnos.getAlumnos());
		model.addAttribute("becas", this.becas.getBecas());
		model.addAttribute("cursos", this.cursos.getCursos());
		model.addAttribute("docentes", this.docentes.getDocentes());
		return "beneficios";
	}
}
