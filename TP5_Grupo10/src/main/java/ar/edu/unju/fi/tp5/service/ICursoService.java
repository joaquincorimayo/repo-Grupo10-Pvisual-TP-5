package ar.edu.unju.fi.tp5.service;

import java.util.List;

import ar.edu.unju.fi.tp5.entity.Curso;

public interface ICursoService {
	
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public void eliminarCurso(int codigo);
	public List<Curso> getListaCursos();
	public Curso buscarCurso(int codigo);

}
