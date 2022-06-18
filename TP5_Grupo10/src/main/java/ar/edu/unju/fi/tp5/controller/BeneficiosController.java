package ar.edu.unju.fi.tp5.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.entity.Alumno;
import ar.edu.unju.fi.tp5.entity.Beca;
import ar.edu.unju.fi.tp5.entity.Curso;
import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.service.IDocenteService;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe 
 */

@Controller
public class BeneficiosController {
	private static final Log logs = LogFactory.getLog(BeneficiosController.class);
// FALTA TERMINAR
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
	public String getListBeneficios(Model model) {
		List<Alumno> alumnos  = new ArrayList<>();
		List<Docente> docentes  = new ArrayList<>();
		List<Curso> cursos  = new ArrayList<>();
		List<Beca> becas  = new ArrayList<>();
		
		boolean bAlumnos=false, bDocentes=false, bCursos=false, bBecas=false;
		alumnos=alumnoService.listarAlumnos();
		docentes=docenteService.listarDocentes();
		cursos=cursoService.listarCursos();
		becas=becaService.listarBecas();
		if(alumnos.size()!=0) {
			bAlumnos=true;
		}
		if(docentes.size()!=0) {
			bDocentes=true;
		}
		if(cursos.size()!=0) {
			bCursos=true;
		}
		if(becas.size()!=0) {
			bBecas=true;
		}
		model.addAttribute("alumnos",alumnos);
		model.addAttribute("banderaA", bAlumnos);
		model.addAttribute("docentes",docentes);
		model.addAttribute("banderaD", bDocentes);
		model.addAttribute("cursos", cursos);
		model.addAttribute("banderaC", bCursos);
		model.addAttribute("becas", becas);
		model.addAttribute("banderaB", bBecas);
		return "beneficios";
	}
}
