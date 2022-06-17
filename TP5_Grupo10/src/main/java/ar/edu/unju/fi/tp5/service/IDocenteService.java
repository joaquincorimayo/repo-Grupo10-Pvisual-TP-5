package ar.edu.unju.fi.tp5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Docente;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Service
public interface IDocenteService {
	public Docente getDocente();
	public void guardarDocente(Docente docente);
	public void eliminarDocente(Long id);
	public void modificarDocente(Docente docente);
	public List<Docente> listarDocentes(); 
	public Docente buscarDocente(Long id); 
}