package ar.edu.unju.fi.tp5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp5.entity.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

	public Optional<Alumno> findById(Long dni);

	public List<Alumno> findByEstado(boolean estado);
}
