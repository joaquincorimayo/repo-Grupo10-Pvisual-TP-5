package ar.edu.unju.fi.tp5.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.service.ICursoService;
import ar.edu.unju.fi.tp5.util.ListaCursos;

@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {

	@Autowired
	private ListaCursos listaCursos;

	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		return this.listaCursos.getCursos().add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		for (Curso cur : this.listaCursos.getCursos()) {
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
		for (int i = 0; i < this.listaCursos.getCursos().size(); i++) {
			if (this.listaCursos.getCursos().get(i).getCodigo() == codigo) {
				this.listaCursos.getCursos().remove(i);
			}
		}
	}

	@Override
	public ListaCursos getListaCursos() {
		return this.listaCursos;
	}

	@Override
	public Curso buscarCurso(int codigo) {
		Optional<Curso> curso = this.listaCursos.getCursos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return curso.get();
	}

}
