package ar.edu.unju.fi.tp5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Curso;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */
@Service
public interface ICursoService {
	public Curso nuevoCurso();
	public void guardarCurso(Curso curso);
	public void eliminarCurso(Long id);
	public void modificarCurso(Curso curso);
	public List<Curso> listarCursos(); 
	public Curso buscarCurso(Long id);
}
