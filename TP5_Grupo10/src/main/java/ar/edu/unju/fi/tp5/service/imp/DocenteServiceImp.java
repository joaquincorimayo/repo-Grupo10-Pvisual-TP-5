package ar.edu.unju.fi.tp5.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;
import ar.edu.unju.fi.tp5.util.ListaDocente;

@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	private ListaDocente listaDocentes;
	
	@Override
	public Docente getDocente() {
		// retorna un objeto de la clase Docente
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		// guarda un objeto alumno en la lista de docente
		return this.listaDocentes.getDocentes().add(docente);
	}

	@Override
	public void modificarDocente(Docente docente) {
		for (Docente doc: this.listaDocentes.getDocentes()) {
			if (doc.getLegajo() == docente.getLegajo()) {
				doc.setLegajo(docente.getLegajo());
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
			}
		}

	}

	@Override
	public void eliminarDocente(int legajo) {
		for (int i = 0; i < this.listaDocentes.getDocentes().size(); i++) {
			if (this.listaDocentes.getDocentes().get(i).getLegajo() == legajo) {
				this.listaDocentes.getDocentes().remove(i);
			}
		}
	}

	@Override
	public ListaDocente getListaDocente() {
		// retorna el objeto que accede a la lista de docentes
		return this.listaDocentes;  
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// busca docente por legajo y devuelve el objeto asociado al legajo del docente
		Optional<Docente> docente = this.listaDocentes.getDocentes().stream().filter(a -> a.getLegajo() == legajo).findFirst();
		return docente.get();
	}

}
