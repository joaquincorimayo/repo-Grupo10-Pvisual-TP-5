package ar.edu.unju.fi.tp5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp5.entity.Beca;

public interface IBecaRepository extends JpaRepository<Beca, Long>{

	public List<Beca> findByEstado(boolean estado);
	public Beca findByCodigo(int codigo);
}
