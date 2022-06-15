package ar.edu.unju.fi.tp5.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp5.entity.Curso;

public interface ICursoService {
	
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public boolean existUser(int codigo);
	public Optional<Curso> buscarCurso(Long id);
	public void eliminarCurso(Long id);
	public List<Curso> getListaCursos();

}
