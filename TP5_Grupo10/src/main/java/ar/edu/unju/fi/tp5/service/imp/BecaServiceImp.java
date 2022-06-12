package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Beca;
import ar.edu.unju.fi.tp5.repository.IBecaRepository;
import ar.edu.unju.fi.tp5.repository.ICursoRepository;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.util.ListaBecas;

@Service("BecaServiceImpList")
public class BecaServiceImp implements IBecaService {

//	@Autowired
//	private ListaBecas listaBecas;
	@Autowired
	IBecaRepository becaRepository;

	@Override
	public Beca getBeca() {
		return new Beca();
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		beca.setEstado(true);
		if(becaRepository.save(beca)!=null) {
			return true;
		}
		return false;

	}

	@Override
	public void modificarBeca(Beca beca) {
		for (Beca bc : becaRepository.findAll()) {
			if (bc.getCodigo() == beca.getCodigo()) {
				bc.setCodigo(beca.getCodigo());
				bc.setCurso(beca.getCurso());
				bc.setFechaFin(beca.getFechaFin());
				bc.setFechaInicio(beca.getFechaInicio());
			}
		}
	}

	@Override
	public void eliminarBeca(int codigo) {
		Beca beca = buscarBeca(codigo);
		beca.setEstado(false);
		becaRepository.save(beca);
	}

	@Override
	public List<Beca> getListaBecas() {
		List<Beca> becas = becaRepository.findByEstado(true);
		return becas;
	}

	@Override
	public Beca buscarBeca(int codigo) {
		return becaRepository.findByCodigo(codigo);
	}

}
