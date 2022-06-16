package ar.edu.unju.fi.tp5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp5.entity.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
	
	public Optional<Curso> findById(int codigo );
	public List<Curso> findByEstado(boolean estado);
	public Curso findByTitulo(String titulo);
}
