package ar.edu.unju.fi.tp5.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Beca;
import ar.edu.unju.fi.tp5.repository.IBecaRepository;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.service.ICursoService;

@Service("BecaServiceImpList")
public class BecaServiceImp implements IBecaService {

	@Autowired
	IBecaRepository becaRepository;

	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	@Override
	public Beca getBeca() {
		return new Beca();
	}
	
	@Override
	public boolean existBeca(int codigo) {
		boolean bandera = false;
		for (Beca a : becaRepository.findAll()) {
			if (a.getCodigo() == codigo) {
				if (a.isEstado() == true) {
					bandera = true;
				} else {
					bandera = false;
				}
			}
		}
		return bandera;
	}

	@Override
	public boolean guardarBeca(Beca beca) {
		if (!existBeca(beca.getCodigo())) {
			beca.setEstado(true);
			becaRepository.save(beca);
			System.out.println("GUARDO ESTO: "+ beca.toString());
			return true;
		}
		return false;
	}

	@Override
	public void modificarBeca(Beca beca) {
		System.out.println("MODIFICO ESTO: "+ beca.toString());
		becaRepository.save(beca);
		System.out.println("DESPUES DE MODIFICAR: "+ beca.toString());
	}

	@Override
	public void eliminarBeca(Long id) {
		Optional<Beca> beca = becaRepository.findById(id);
		beca.get().setEstado(false);
		becaRepository.save(beca.get());
	}

	@Override
	public List<Beca> getListaBecas() {
		List<Beca> becas = becaRepository.findByEstado(true);
		return becas;
	}

	@Override
	public Optional<Beca> buscarBeca(Long id) {
		return becaRepository.findById(id);
	}

}
