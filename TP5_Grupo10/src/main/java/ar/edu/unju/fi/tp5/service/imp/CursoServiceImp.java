package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Curso;
import ar.edu.unju.fi.tp5.repository.ICursoRepository;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.util.ListaCursos;

/**
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */


@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {

	private static final Log logs = LogFactory.getLog(CursoServiceImp.class);

	@Autowired
	ICursoRepository cursoRepository;
	@Autowired
	private ListaCursos lista;

	@Override
	public Curso nuevoCurso() {
		return new Curso();
	}

	@Override
	public void guardarCurso(Curso curso) {
		logs.info("Se agrego el curso");
		curso.setEstado(true);
		cursoRepository.save(curso);
		lista.getCursos().add(curso);
	}

	@Override
	public void eliminarCurso(Long id) {
		for (int i = 0; i < lista.getCursos().size(); i++) {			
			if (lista.getCursos().get(i).getId() == id) {				
				lista.getCursos().get(i).setEstado(false);		
			}            
        }
	}

	@Override
	public void modificarCurso(Curso curso) {
		for (int i = 0; i < lista.getCursos().size(); i++) {			
			if (lista.getCursos().get(i).getId() == curso.getId()) {
				lista.getCursos().set(i, curso);			
			}            
        }
	}

	@Override
	public List<Curso> listarCursos() {
		return cursoRepository.findByEstado(true);
	}

	@Override
	public Curso buscarCurso(Long id) {
		Curso cursoEncontrado = new Curso();
		for (int i = 0; i < lista.getCursos().size(); i++) {
			if (lista.getCursos().get(i).getId() == id) {
				cursoEncontrado = lista.getCursos().get(i);		
			}            
        }
		return cursoEncontrado;
	}
}
