package ar.edu.unju.fi.tp5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp5.entity.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

}
