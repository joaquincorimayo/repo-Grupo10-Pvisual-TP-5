package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.repository.IDocenteRepository;
import ar.edu.unju.fi.tp5.service.IDocenteService;


@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {

//	@Autowired
//	private ListaDocente listaDocentes;
	@Autowired
	IDocenteRepository docenteRepository;
	
	@Override
	public Docente getDocente() {
		// retorna un objeto de la clase Docente
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		docente.setEstado(true);
		if(docenteRepository.save(docente)!= null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarDocente(Docente docente) {
		for (Docente doc:docenteRepository.findAll()) {
			if (doc.getLegajo() == docente.getLegajo()) {
				doc.setLegajo(docente.getLegajo());
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
				docenteRepository.save(doc);
			}
		}

	}

	@Override
	public void eliminarDocente(int legajo) {
		Docente docente = buscarDocente(legajo);
		docente.setEstado(false);
		docenteRepository.save(docente);
	}

	@Override
	public List<Docente> getListaDocente() {
		// retorna el objeto que accede a la lista de docentes
		List<Docente> docentes = docenteRepository.findByEstado(true);
		return docentes;  
	}

	@Override
	public Docente buscarDocente(int legajo) {
		return docenteRepository.findByLegajo(legajo);
	}

}

