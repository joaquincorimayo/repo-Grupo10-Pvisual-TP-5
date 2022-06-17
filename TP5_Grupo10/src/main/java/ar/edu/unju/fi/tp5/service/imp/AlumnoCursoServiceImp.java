package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.AlumnoCurso;
import ar.edu.unju.fi.tp5.repository.AlumnoCursoRepository;
import ar.edu.unju.fi.tp5.service.IAlumnoCursoService;

/**
 * 
 * @author JoaquinCorimayo
 *
 */


@Service
public class AlumnoCursoServiceImp implements IAlumnoCursoService {

	private static final Log logs = LogFactory.getLog(AlumnoCursoServiceImp.class);
	
	@Autowired
	AlumnoCursoRepository usuarioCursoRepository;

	@Override
	public AlumnoCurso nuevoAlumnoCurso() {
		// TODO Auto-generated method stub
		return new AlumnoCurso();
	}

	@Override
	public void guardarAlumnoCurso(AlumnoCurso alumnoCurso) {
		usuarioCursoRepository.save(alumnoCurso);
	}

	@Override
	public void eliminarAlumnoCurso(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAlumnoCurso(AlumnoCurso usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<AlumnoCurso> listarAlumnoCurso() {
		// TODO Auto-generated method stub
		return (List<AlumnoCurso>) usuarioCursoRepository.findAll();
	}

	@Override
	public AlumnoCurso buscarAlumnoCurso(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
