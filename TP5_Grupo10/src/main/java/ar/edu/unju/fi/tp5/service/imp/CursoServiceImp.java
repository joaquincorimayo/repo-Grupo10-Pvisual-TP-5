package ar.edu.unju.fi.tp5.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.util.ListaCursos;

@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {

	@Autowired
	private ListaCursos listaCursos;
	
	@Override
	public Curso getCurso() {
		// retorna un objeto de la clase Curso
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// guarda un objeto alumno en la lista de curso
		return listaCursos.getCursos().add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCurso(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaCursos getListaCursos() {
		// retorna el objeto que accede a la lista de cursos
		return listaCursos;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		// busca la beca por codigo y devuelve el objeto asociado al codigo de beca
		Optional<Curso> curso = listaCursos.getCursos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return curso.get();
	}

}
