package ar.edu.unju.fi.tp5.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Beca;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.util.ListaBecas;

@Service("BecaServiceImpList")
public class BecaServiceImp implements IBecaService {

	@Autowired
	private ListaBecas listaBecas;
	
	@Override
	public Beca getBeca() {
		// retorna un objeto de la clase Beca	
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		// guarda un objeto alumno en la lista de beca
		return listaBecas.getBecas().add(beca);
		
	}

	@Override
	public void modificarBeca(Beca beca) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarBeca(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaBecas getListaBecas() {
		// retorna el objeto que accede a la lista de becas
		return listaBecas;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		// busca la beca por codigo y devuelve el objeto asociado al codigo de beca
		Optional<Beca> beca = listaBecas.getBecas().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return beca.get();
	}

}
