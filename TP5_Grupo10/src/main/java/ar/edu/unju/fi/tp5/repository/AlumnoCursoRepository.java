package ar.edu.unju.fi.tp5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tp5.entity.AlumnoCurso;
/**
 * 
 * @author JoaquinCorimayo
 *
 */
@Repository
public interface AlumnoCursoRepository extends CrudRepository<AlumnoCurso, Long>{

}
