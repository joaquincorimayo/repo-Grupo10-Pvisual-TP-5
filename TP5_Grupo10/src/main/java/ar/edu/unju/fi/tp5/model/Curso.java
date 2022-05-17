package ar.edu.unju.fi.tp5.model;

import java.time.LocalDate;

public class Curso {
	private int codigo;
	private String titulo;
	private String categoria;
	private LocalDate fechaFin;
	private LocalDate fechaInicio;
	private int cantidadHoras;
	private String modalidad;
	private Docente docente;
	private int dos;
	public Curso() {

	}

	public Curso(int codigo, String titulo, String categoria, LocalDate fechaFin, LocalDate fechaInicio,
			int cantidadHoras, String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
//		Period period = Period.between(fechaInicio, fechaFin);
		this.dos = 2;
	}
	
	public int getDos() {
		return dos;
	}

	public void setDos(int dos) {
		this.dos = dos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", fechaFin=" + fechaFin
				+ ", fechaInicio=" + fechaInicio + ", cantidadHoras=" + cantidadHoras + ", modalidad=" + modalidad
				+ ", docente=" + docente + "]";
	}
}
