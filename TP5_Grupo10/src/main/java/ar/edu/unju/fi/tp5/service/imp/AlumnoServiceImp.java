package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;
import java.util.Optional;

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

	public boolean existUser(String dni) {
		boolean bandera = false;
		for (Alumno a : alumnoRepository.findAll()) {
			if (a.getDni().equals(dni)) {
				if (a.isEstado() == true) {
					bandera=true;
				} else {
					bandera=false;		
				}
			}
		}
		return bandera;
	}

	@Override
	public boolean guardarAlumno(Alumno alumno) {
		
		if(!existUser(alumno.getDni())) {
			alumno.setEstado(true);
			alumnoRepository.save(alumno);
			return true;
		}
		return false;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);		
	}

	@Override
	public void eliminarAlumno(Long id) {
		Optional<Alumno> alumno = alumnoRepository.findById(id);
		alumno.get().setEstado(false);
		alumnoRepository.save(alumno.get());
	}

	@Override
	public List<Alumno> getListaAlumnos() {
		List<Alumno> alumnos = alumnoRepository.findByEstado(true);
		return alumnos;
	}

	@Override
	public Optional<Alumno> buscarAlumno(Long id) {
		return alumnoRepository.findById(id);
	}
}
