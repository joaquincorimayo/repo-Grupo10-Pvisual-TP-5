package ar.edu.unju.fi.tp5.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp5.entity.Beca;

public interface IBecaService {
	
	public Beca getBeca();
	public boolean guardarBeca(Beca beca);
	public boolean existBeca(int codigo);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(Long id);
	public List<Beca> getListaBecas();
	public Optional<Beca> buscarBeca(Long id);

}
