package ar.edu.unju.fi.tp5.service;

import ar.edu.unju.fi.tp5.entity.Docente;
import ar.edu.unju.fi.tp5.util.ListaDocente;

public interface IDocenteService {

	public Docente getDocente();
	public boolean guardarDocente(Docente docente);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(int legajo);
	public ListaDocente getListaDocente();
	public Docente buscarDocente(int legajo);
	
}
