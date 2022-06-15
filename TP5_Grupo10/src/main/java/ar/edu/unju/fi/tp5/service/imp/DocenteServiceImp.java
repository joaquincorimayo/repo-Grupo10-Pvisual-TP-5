package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.repository.IDocenteRepository;
import ar.edu.unju.fi.tp5.service.IDocenteService;

@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	private IDocenteRepository docenteRepository;
	
	@Override
	public Docente getDocente() {
		return new Docente();
	}
	
	public boolean existUser(int legajo) {
		boolean bandera = false;
		for (Docente d : docenteRepository.findAll()) {
			if(d.getLegajo() == legajo) {
				if (d.isEstado() == true) {
					bandera=true;				
				}
				else {
					bandera=false;
				}
			}
		}
		return bandera;
	}
	
	@Override
	public boolean guardarDocente(Docente docente) {
		docente.setEstado(true);
		if(!existUser(docente.getLegajo())) {
			docenteRepository.save(docente);
			return true;
		}
		return false;
	}

	@Override
	public void modificarDocente(Docente docente) {
		docenteRepository.save(docente);
	}

	@Override
	public void eliminarDocente(Long id) {
		Optional<Docente> docente = buscarDocente(id);
		docente.get().setEstado(false);
		docenteRepository.save(docente.get());
	}

	@Override
	public List<Docente> getListaDocente() {
		// retorna el objeto que accede a la lista de docentes
		List<Docente> docentes = docenteRepository.findByEstado(true);
		return docentes;  
	}

	@Override
	public Optional<Docente> buscarDocente(Long id) {
		return docenteRepository.findById(id);
	}
}

