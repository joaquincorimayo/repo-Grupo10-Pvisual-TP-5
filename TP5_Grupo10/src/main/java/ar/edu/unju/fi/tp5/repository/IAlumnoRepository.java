package ar.edu.unju.fi.tp5.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tp5.entity.Alumno;
/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */
@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
