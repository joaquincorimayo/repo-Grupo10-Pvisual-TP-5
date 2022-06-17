package ar.edu.unju.fi.tp5.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tp5.entity.Alumno;
import ar.edu.unju.fi.tp5.repository.IAlumnoRepository;
import ar.edu.unju.fi.tp5.service.IAlumnoService;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

/**
 * 
 * @author JoaquinCorimayo
 *
 */


@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService {

	private static final Log logs = LogFactory.getLog(AlumnoServiceImp.class);

	@Autowired
	private ListaAlumnos lista;
	@Autowired
	private IAlumnoRepository alumnoRepository;

	@Override
	public Alumno getAlumno() {
		return new Alumno();
	}

	@Override
	public void guardarAlumno(Alumno alumno) {
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		logs.info("Se agrego al alumno");
		lista.getAlumnos().add(alumno);
	}

	@Override
	public void eliminarAlumno(Long id) {

		for (int i = 0; i < lista.getAlumnos().size(); i++) {
			if (lista.getAlumnos().get(i).getId() == id) {
				lista.getAlumnos().get(i).setEstado(false);
				alumnoRepository.save(lista.getAlumnos().get(i));
			}
		}
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		for (int i = 0; i < lista.getAlumnos().size(); i++) {
			if (lista.getAlumnos().get(i).getId() == alumno.getId()) {
				lista.getAlumnos().set(i, alumno);
				alumnoRepository.save(lista.getAlumnos().get(i));
			}
		}
	}

	@Override
	public List<Alumno> listarAlumnos() {
		List<Alumno> aux_alumnos = new ArrayList<>();
		for (int i = 0; i < alumnoRepository.findAll().size(); i++) {
			if (lista.getAlumnos().get(i).isEstado() == true) {
				aux_alumnos.add(lista.getAlumnos().get(i));
			}
		}
		return aux_alumnos;
	}

	@Override
	public Alumno buscarAlumno(Long id) {
		Alumno alumnoEncontrado = new Alumno();
		for (int i = 0; i < lista.getAlumnos().size(); i++) {
			if (lista.getAlumnos().get(i).getId() == id) {
				alumnoEncontrado = lista.getAlumnos().get(i);
			}
		}

		return alumnoEncontrado;
	}

}
