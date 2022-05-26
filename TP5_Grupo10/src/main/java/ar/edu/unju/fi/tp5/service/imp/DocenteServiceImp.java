package ar.edu.unju.fi.tp5.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;
import ar.edu.unju.fi.tp5.util.ListaDocente;

@Service
public class DocenteServiceImp implements IDocenteService {

	@Override
	public Docente getDocente() {
		// TODO Auto-generated method stub
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaDocente getListaDocente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// TODO Auto-generated method stub
		return null;
	}

}
