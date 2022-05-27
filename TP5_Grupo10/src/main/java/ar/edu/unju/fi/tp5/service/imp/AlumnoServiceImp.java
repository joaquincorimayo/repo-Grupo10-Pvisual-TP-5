package ar.edu.unju.fi.tp5.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {

	@Autowired
	private ListaAlumnos listaAlumnos;
	
	@Override
	public Alumno getAlumno() {
		// retorna un objeto de la clase Alumno	
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		// guarda un objeto alumno en la lista de alumno
		return listaAlumnos.getAlumnos().add(alumno);
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
		// retorna el objeto que accede a  la lista de alumno
		return listaAlumnos;
	}

	@Override
	public Alumno buscarAlumno(String dni) {
		// busca al alumno por dni y devuelve el objeto asociado al dni
		Optional<Alumno> alumno = listaAlumnos.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		return alumno.get();
	}
}
