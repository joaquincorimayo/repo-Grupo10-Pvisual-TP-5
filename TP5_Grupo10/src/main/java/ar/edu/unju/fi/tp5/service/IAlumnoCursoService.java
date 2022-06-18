package ar.edu.unju.fi.tp5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.AlumnoCurso;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Service
public interface IAlumnoCursoService {
	public AlumnoCurso nuevoAlumnoCurso();
	public void guardarAlumnoCurso(AlumnoCurso alumnoCurso);
	public void eliminarAlumnoCurso(Long id);
	public void modificarAlumnoCurso(AlumnoCurso usuario);
	public List<AlumnoCurso> listarAlumnoCurso(); 
	public AlumnoCurso buscarAlumnoCurso(Long id);
}
