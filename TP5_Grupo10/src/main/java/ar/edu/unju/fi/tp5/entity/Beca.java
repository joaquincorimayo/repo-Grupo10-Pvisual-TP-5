package ar.edu.unju.fi.tp5.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "BECA")
public class Beca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BEC_ID")
	private Long id;

	@Min(value = 1, message = "El valor mínimo para el codigo es 1")
	@Max(value = 9999, message = "El valor máximo permitido para el codigo es 9999")
	@Column(name = "BEC_CODIGO")
	private int codigo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@FutureOrPresent(message = "La fecha debe ser hoy o posterior")
	@Column(name = "BEC_FECH_INICIO")
	private LocalDate fechaInicio;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Future(message = "La fecha debe ser posterior a la actual")
	@Column(name = "BEC_FECH_FIN")
	private LocalDate fechaFin;

	@Column(name = "BEC_ESTADO")
	private boolean estado;

	// RELACION BECA-CURSO Uni-direccional
	@NotNull(message = "Debe tener asignado un curso")
	@OneToOne
    @JoinColumn(name = "CUR_ID")
	private Curso curso;
	// FIN RELACIONES

	public Beca() {
		
	}

	public Beca(int codigo, Curso curso, LocalDate fechaFin, LocalDate fechaInicio, boolean estado) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Beca [id=" + id + ", codigo=" + codigo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", estado=" + estado + ", curso=" + curso + "]";
	}

	
}
