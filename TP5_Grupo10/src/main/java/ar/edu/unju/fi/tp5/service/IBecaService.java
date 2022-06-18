package ar.edu.unju.fi.tp5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Beca;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */
@Service
public interface IBecaService {
	public Beca getBeca();
	public void guardarBeca(Beca beca);
	public void eliminarBeca(Long id);
	public void modificarBeca(Beca beca);
	public List<Beca> listarBecas(); 
	public Beca buscarBeca(Long id); 
}
