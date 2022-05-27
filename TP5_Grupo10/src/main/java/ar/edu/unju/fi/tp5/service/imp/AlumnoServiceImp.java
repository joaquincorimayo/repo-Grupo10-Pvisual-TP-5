package ar.edu.unju.fi.tp5.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {

	@Autowired
	private ListaAlumnos listaAlumnos; // ID

	@Override
	public Alumno getAlumno() {
		return new Alumno();
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		return this.listaAlumnos.getAlumnos().add(alumno);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		for (Alumno alm : this.listaAlumnos.getAlumnos()) {
			if (alm.getDni().equals(alumno.getDni())) {
				alm.setApellido(alumno.getApellido());
				alm.setDni(alumno.getDni());
				alm.setEmail(alumno.getEmail());
				alm.setNombre(alumno.getNombre());
				alm.setTelefono(alumno.getTelefono());
			}
		}
	}

	@Override
	public void eliminarAlumno(String dni) {
		for (int i = 0; i < this.listaAlumnos.getAlumnos().size(); i++) {
			if (this.listaAlumnos.getAlumnos().get(i).getDni().equals(dni)) {
				this.listaAlumnos.getAlumnos().remove(i);
				// i--;
			}
		}
	}

	@Override
	public ListaAlumnos getListaAlumnos() {
		return this.listaAlumnos;
	}

	@Override
	public Alumno buscarAlumno(String dni) {
		Alumno devolverAlumno = new Alumno();
		for (Alumno alm : this.listaAlumnos.getAlumnos()) {
			if (alm.getDni().equals(dni)) {
				devolverAlumno.setApellido(alm.getApellido());
				devolverAlumno.setDni(alm.getDni());
				devolverAlumno.setEmail(alm.getEmail());
				devolverAlumno.setNombre(alm.getNombre());
				devolverAlumno.setTelefono(alm.getTelefono());
			}
		}
		return devolverAlumno;
	}
}
