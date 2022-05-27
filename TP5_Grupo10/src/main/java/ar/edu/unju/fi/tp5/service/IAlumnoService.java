package ar.edu.unju.fi.tp5.service;

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

public interface IAlumnoService {
	public Alumno getAlumno();
	public boolean guardarAlumno(Alumno alumno);
	public void modificarAlumno(Alumno alumno);
	public void eliminarAlumno(String dni);
	public ListaAlumnos getListaAlumnos();
	public Alumno buscarAlumno(String dni);
}
