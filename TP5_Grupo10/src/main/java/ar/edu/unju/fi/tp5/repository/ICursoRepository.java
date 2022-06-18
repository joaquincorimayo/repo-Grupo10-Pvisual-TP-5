package ar.edu.unju.fi.tp5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tp5.entity.Curso;
/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */
@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {
	public List<Curso> findByEstado(boolean estadoCurso);
}
