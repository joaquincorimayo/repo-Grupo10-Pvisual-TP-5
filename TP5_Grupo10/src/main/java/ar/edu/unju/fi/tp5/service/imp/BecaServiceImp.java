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
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		return listaBecas.getBecas().add(beca);

	}

	@Override
	public void modificarBeca(Beca beca) {
		for (Beca bc : this.listaBecas.getBecas()) {
			if (bc.getCodigo() == beca.getCodigo()) {
				bc.setCodigo(beca.getCodigo());
				bc.setCurso(beca.getCurso());
				bc.setEstado(beca.getEstado());
				bc.setFechaFin(beca.getFechaFin());
				bc.setFechaInicio(beca.getFechaInicio());
			}
		}
	}

	@Override
	public void eliminarBeca(int codigo) {
		for (int i = 0; i < this.listaBecas.getBecas().size(); i++) {
			if (this.listaBecas.getBecas().get(i).getCodigo() == codigo) {
				this.listaBecas.getBecas().remove(i);
			}
		}
	}

	@Override
	public ListaBecas getListaBecas() {
		return listaBecas;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		Optional<Beca> beca = listaBecas.getBecas().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return beca.get();
	}

}
