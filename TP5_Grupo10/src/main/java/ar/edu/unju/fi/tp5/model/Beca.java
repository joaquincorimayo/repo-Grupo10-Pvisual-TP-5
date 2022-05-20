package ar.edu.unju.fi.tp5.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Beca {
	private int codigo;
	private Curso curso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
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
