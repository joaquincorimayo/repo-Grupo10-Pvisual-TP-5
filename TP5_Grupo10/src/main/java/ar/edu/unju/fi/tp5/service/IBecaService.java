package ar.edu.unju.fi.tp5.service;

import java.util.List;

import ar.edu.unju.fi.tp5.entity.Beca;
import ar.edu.unju.fi.tp5.util.ListaBecas;

public interface IBecaService {
	
	public Beca getBeca();
	public boolean guardarBeca(Beca beca);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(int codigo);
	public List<Beca> getListaBecas();
	public Beca buscarBeca(int codigo);

}
