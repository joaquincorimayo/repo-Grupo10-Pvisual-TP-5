package ar.edu.unju.fi.tp5.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp5.entity.Alumno;

public interface IAlumnoService {
	
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void modificarAlumno(Alumno alumno);
	public List<Alumno> getListaAlumnos();
	public Optional<Alumno> buscarAlumno(Long id);
	public void eliminarAlumno(Long id);
	public boolean existUser(String dni);
}