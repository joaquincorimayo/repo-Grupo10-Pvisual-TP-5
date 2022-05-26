package ar.edu.unju.fi.tp5.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

@Service
public class AlumnoServiceImp implements IAlumnoService {

	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaAlumnos getListaAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno buscarAlumno(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
