package ar.edu.unju.fi.tp5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tp5.entity.Beca;
/**
 * 
 * @author JoaquinCorimayo
 *
 */
@Repository
public interface IBecaRepository extends JpaRepository<Beca, Long>{
}
