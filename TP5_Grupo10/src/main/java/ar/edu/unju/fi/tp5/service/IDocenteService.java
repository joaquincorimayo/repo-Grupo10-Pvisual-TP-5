package ar.edu.unju.fi.tp5.service;

import java.util.List;
import ar.edu.unju.fi.tp5.entity.Docente;

public interface IDocenteService {

	public Docente getDocente();
	public boolean guardarDocente(Docente docente);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(int legajo);
	public List<Docente> getListaDocente();
	public Docente buscarDocente(int legajo);
	
}
