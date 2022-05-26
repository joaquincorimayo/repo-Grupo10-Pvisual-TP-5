package ar.edu.unju.fi.tp5.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Beca;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.util.ListaBecas;

@Service
public class BecaServiceImp implements IBecaService {

	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
