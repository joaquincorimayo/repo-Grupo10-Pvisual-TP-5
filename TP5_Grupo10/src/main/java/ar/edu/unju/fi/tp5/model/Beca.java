package ar.edu.unju.fi.tp5.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Beca {
	@Min(value = 1, message = "El valor mínimo para el codigo es 1")
	@Max(value = 9999, message = "El valor máximo permitido para el codigo es 9999")
	private int codigo;
	private Curso curso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@FutureOrPresent(message = "La fecha debe ser hoy o posterior")
	private LocalDate fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Future(message = "La fecha debe ser posterior a la actual")
	private LocalDate fechaFin;
	@NotEmpty(message="El estado de la beca no puede ser vacío")
	private String estado;
	
	public Beca() {
		// TODO Auto-generated constructor stub
	}

	public Beca(int codigo, Curso curso, LocalDate fechaFin, LocalDate fechaInicio, String estado) {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Beca [codigo=" + codigo + ", curso=" + curso + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio
				+ ", estado=" + estado + "]";
	}
}
