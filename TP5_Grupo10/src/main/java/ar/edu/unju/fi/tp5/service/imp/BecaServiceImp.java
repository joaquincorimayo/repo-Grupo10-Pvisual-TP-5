package ar.edu.unju.fi.tp5.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.entity.Beca;
import ar.edu.unju.fi.tp5.repository.IBecaRepository;
import ar.edu.unju.fi.tp5.service.IBecaService;
import ar.edu.unju.fi.tp5.util.ListaBecas;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */


@Service("BecaServiceImpList")
public class BecaServiceImp implements IBecaService {
	
	private static final Log logs = LogFactory.getLog(BecaServiceImp.class);
	
	@Autowired
	private ListaBecas lista;
	
	@Autowired
	IBecaRepository becaRepository;

	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public void guardarBeca(Beca beca) {
		beca.setEstado(true);
		becaRepository.save(beca);
		lista.getBecas().add(beca);
	}

	@Override
	public void eliminarBeca(Long id) {
		for (int i = 0; i < lista.getBecas().size(); i++) {
			if (lista.getBecas().get(i).getId() == id) {
				lista.getBecas().get(i).setEstado(false);
				becaRepository.save(lista.getBecas().get(i));
			}
		}
	}

	@Override
	public void modificarBeca(Beca beca) {
		for (int i = 0; i < lista.getBecas().size(); i++) {
			if (lista.getBecas().get(i).getId() == beca.getId()) {
				lista.getBecas().set(i, beca);
				becaRepository.save(lista.getBecas().get(i));
			}
		}
	}

	@Override
	public List<Beca> listarBecas() {
		List<Beca> aux_becas = new ArrayList<>();
		for (int i = 0; i < becaRepository.findAll().size(); i++) {
			if (lista.getBecas().get(i).isEstado() == true) {
				aux_becas.add(lista.getBecas().get(i));
			}
		}
		
		return aux_becas;
	}

	@Override
	public Beca buscarBeca(Long id) {
		Beca becaEncontrada = new Beca();
		for (int i = 0; i < lista.getBecas().size(); i++) {
			if (lista.getBecas().get(i).getId() == id) {
				becaEncontrada = lista.getBecas().get(i);
			}
		}
		return becaEncontrada;
	}

}
