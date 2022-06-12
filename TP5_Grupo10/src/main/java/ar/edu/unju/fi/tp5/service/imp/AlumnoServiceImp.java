package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tp5.entity.Alumno;
import ar.edu.unju.fi.tp5.repository.IAlumnoRepository;
import ar.edu.unju.fi.tp5.service.IAlumnoService;

@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {
	

	@Autowired
	private IAlumnoRepository alumnoRepository;
	
	@Override
	public Alumno getAlumno() {
		return new Alumno();
	}
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		alumno.setEstado(true);
		if(alumnoRepository.save(alumno) != null ) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		
		for (Alumno alm:alumnoRepository.findAll()) {
			if (alm.getDni().equals(alumno.getDni())) {
				alm.setApellido(alumno.getApellido());
				alm.setDni(alumno.getDni());
				alm.setEmail(alumno.getEmail());
				alm.setNombre(alumno.getNombre());
				alm.setTelefono(alumno.getTelefono());
				alumnoRepository.save(alm);
			}
		}
	}
	
	@Override
	public void eliminarAlumno(String dni) {
		Alumno alumno = buscarAlumno(dni);
		alumno.setEstado(false);
		alumnoRepository.save(alumno);
	}

	@Override
	public List<Alumno> getListaAlumnos() {
		List<Alumno> alumnos = alumnoRepository.findByEstado(true);
		return alumnos;
	}

	@Override
	public Alumno buscarAlumno(String dni) {
		return alumnoRepository.findByDni(dni);
	}
}
