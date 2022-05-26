package ar.edu.unju.fi.tp5.service;

import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.util.ListaCursos;

public interface ICursoService {
	
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public void eliminarCurso(int codigo);
	public ListaCursos getListaCursos();
	public Curso buscarCurso(int codigo);

}
