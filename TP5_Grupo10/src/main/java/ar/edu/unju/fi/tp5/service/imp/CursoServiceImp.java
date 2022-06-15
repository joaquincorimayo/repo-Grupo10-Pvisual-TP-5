package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Curso;
import ar.edu.unju.fi.tp5.repository.ICursoRepository;
import ar.edu.unju.fi.tp5.service.ICursoService;

@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {

//	@Autowired
//	private ListaCursos listaCursos;
	@Autowired
	ICursoRepository cursoRepository;

	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		
		if(!existUser(curso.getCodigo())) {
			curso.setEstado(true);
			cursoRepository.save(curso);
			return true;
		}
		
		return false;
	}

	@Override
	public void modificarCurso(Curso curso) {
		cursoRepository.save(curso);
	}


	@Override
	public List<Curso> getListaCursos() {
		List<Curso> cursos = cursoRepository.findByEstado(true);
		return cursos;
	}



	@Override
	public boolean existUser(int codigo) {
		boolean band = false;
		for(Curso c : cursoRepository.findAll()) {
			if(c.getCodigo() == codigo) {
				if(c.isEstado() == true) {
					band=true;
				}else {
					band=false;
				}
			}
		}
		return band;
	}

	@Override
	public Optional<Curso> buscarCurso(Long id) {
		
		return cursoRepository.findById(id);
	}

	@Override
	public void eliminarCurso(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		curso.get().setEstado(false);
		cursoRepository.save(curso.get());
		
	}

}
