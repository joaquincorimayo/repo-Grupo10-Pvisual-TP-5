package ar.edu.unju.fi.tp5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.entity.Alumno;
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
		boolean banderaAlumnos = false;
		List<Alumno> alumnos  = new ArrayList<>();
		alumnos = alumnoService.getListaAlumnos();
		if(alumnos.size()!=0) {
			banderaAlumnos=true;
		}
//		
//		if (alumnos.size()!=0 && this.becaService.getListaBecas().size()!= 0 && this.cursoService.getListaCursos().size() != 0 && this.docenteService.getListaDocente().size() !=0) {
//			
//			//model.addAttribute("becas", this.becaService.getListaBecas());
//			//model.addAttribute("cursos", this.cursoService.getListaCursos());
//			//model.addAttribute("docentes", this.docenteService.getListaDocente());
//			model.addAttribute("banderaAlumnos",true );
//		}else {
//			model.addAttribute("contenido", "n");
//		}
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("banderaA", banderaAlumnos);
		
		return "beneficios";
	}
}
