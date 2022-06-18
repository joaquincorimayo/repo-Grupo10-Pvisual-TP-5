package ar.edu.unju.fi.tp5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Alumno;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */
@Service
public interface IAlumnoService {
	public Alumno getAlumno();
	public void guardarAlumno(Alumno alumno);
	public void eliminarAlumno(Long id);
	public void modificarAlumno(Alumno alumno);
	public List<Alumno> listarAlumnos(); 
	public Alumno buscarAlumno(Long id);
}