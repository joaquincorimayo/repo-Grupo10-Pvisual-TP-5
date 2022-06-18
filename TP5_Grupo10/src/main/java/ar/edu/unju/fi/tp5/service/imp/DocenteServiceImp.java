package ar.edu.unju.fi.tp5.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.repository.IDocenteRepository;
import ar.edu.unju.fi.tp5.service.IDocenteService;
import ar.edu.unju.fi.tp5.util.ListaDocente;


/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {

	private static final Log logs = LogFactory.getLog(DocenteServiceImp.class);

	@Autowired
	private ListaDocente lista;

	@Autowired
	private IDocenteRepository docenteRepository;

	@Override
	public Docente getDocente() {
		return new Docente();
	}

	@Override
	public void guardarDocente(Docente docente) {
		docente.setEstado(true);
		docenteRepository.save(docente);
		lista.getDocentes().add(docente);

	}

	@Override
	public void eliminarDocente(Long id) {
		for (int i = 0; i < lista.getDocentes().size(); i++) {
			if (lista.getDocentes().get(i).getId() == id) {
				lista.getDocentes().get(i).setEstado(false);
				docenteRepository.save(lista.getDocentes().get(i));
			}
		}
	}

	@Override
	public void modificarDocente(Docente docente) {
		for (int i = 0; i < lista.getDocentes().size(); i++) {
			if (lista.getDocentes().get(i).getId() == docente.getId()) {
				lista.getDocentes().set(i, docente);
				docenteRepository.save(lista.getDocentes().get(i));
			}
		}

	}

	@Override
	public List<Docente> listarDocentes() {
		List<Docente> aux_docentes = new ArrayList<>();
		for (int i = 0; i < lista.getDocentes().size(); i++) {
			if (lista.getDocentes().get(i).isEstado() == true) {
				aux_docentes.add(lista.getDocentes().get(i));
			}
		}

		return aux_docentes;
	}

	@Override
	public Docente buscarDocente(Long id) {
		Docente docenteEncontrado = new Docente();
		for (int i = 0; i < lista.getDocentes().size(); i++) {
			if (lista.getDocentes().get(i).getId() == id) {
				docenteEncontrado = lista.getDocentes().get(i);
			}
		}
		return docenteEncontrado;
	}

}
