package ar.edu.unju.fi.tp5.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


/**
 * Clase que permite trabajar un alumnos y un curso
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
public class AlumnoCurso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALU_ID")
	private Alumno alumno;
	@NotNull(message = "Debe seleccionar un curso")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUR_ID")
	private Curso curso;

	public AlumnoCurso() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AlumnoCurso(Long id, Alumno alumno, Curso curso) {
		super();
		this.id = id;
		this.alumno = alumno;
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "AlumnoCurso [id=" + id + ", alumno=" + alumno + ", curso=" + curso + "]";
	}

}
