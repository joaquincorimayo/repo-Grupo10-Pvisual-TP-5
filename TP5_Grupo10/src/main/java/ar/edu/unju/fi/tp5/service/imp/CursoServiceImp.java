package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Curso;
import ar.edu.unju.fi.tp5.repository.ICursoRepository;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.util.ListaCursos;

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
		curso.setEstado(true);
		if(cursoRepository.save(curso)!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public void modificarCurso(Curso curso) {
		for (Curso cur : cursoRepository.findAll()) {
			if (cur.getCodigo() == curso.getCodigo()) {
				cur.setCantidadHoras(curso.getCantidadHoras());
				cur.setCategoria(curso.getCategoria());
				cur.setCodigo(curso.getCodigo());
				cur.setDocente(curso.getDocente());
				cur.setDos(curso.getDos());
				cur.setFechaFin(curso.getFechaFin());
				cur.setFechaInicio(curso.getFechaInicio());
				cur.setModalidad(curso.getModalidad());
				cur.setTitulo(curso.getTitulo());
			}
		}
	}

	@Override
	public void eliminarCurso(int codigo) {
		Curso curso = buscarCurso(codigo);
		curso.setEstado(false);
		cursoRepository.save(curso);
	}

	@Override
	public List<Curso> getListaCursos() {
		List<Curso> cursos = cursoRepository.findByEstado(true);
		return cursos;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		return cursoRepository.findByCodigo(codigo);
	}

}
