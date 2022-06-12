package ar.edu.unju.fi.tp5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp5.entity.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Long> {

	public List<Docente> findByEstado(boolean estado);
	
	public Docente findByLegajo(int legajo);
}
