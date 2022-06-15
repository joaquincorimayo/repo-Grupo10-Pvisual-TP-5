package ar.edu.unju.fi.tp5.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp5.entity.Docente;

public interface IDocenteService {

	public Docente getDocente();
	public boolean guardarDocente(Docente docente);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(Long id);
	public List<Docente> getListaDocente();
	public Optional<Docente> buscarDocente(Long id);
	public boolean existUser(int legajo);
	
}