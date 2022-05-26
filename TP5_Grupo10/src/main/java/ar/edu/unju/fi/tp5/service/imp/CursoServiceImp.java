package ar.edu.unju.fi.tp5.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.util.ListaCursos;

@Service
public class CursoServiceImp implements ICursoService {

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
