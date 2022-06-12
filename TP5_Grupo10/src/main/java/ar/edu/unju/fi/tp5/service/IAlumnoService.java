package ar.edu.unju.fi.tp5.service;

import java.util.List;
import ar.edu.unju.fi.tp5.entity.Alumno;

public interface IAlumnoService {
	
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void modificarAlumno(Alumno alumno);
	public void eliminarAlumno(String dni);
	public List<Alumno> getListaAlumnos();
	public Alumno buscarAlumno(String dni);
}