package ar.edu.unju.fi.tp5.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "CURSO")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUR_ID")
	private Long id;

	@Min(value = 1, message = "El valor mínimo es 1")
	@Max(value = 9999, message = "El valor máximo permitido es 9999")
	@Column(name = "CUR_CODIGO")
	private int codigo;

	@NotEmpty(message = "El nombre del título no puede ser vacío")
	@Column(name = "CUR_TITULO")
	private String titulo;

	@NotEmpty(message = "El nombre de la categoria no puede ser vacío")
	@Column(name = "CUR_CATEGORIA")
	private String categoria;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@FutureOrPresent(message = "La fecha debe ser hoy o posterior")
	@Column(name = "CUR_FECH_INICIO")
	private LocalDate fechaInicio;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Future(message = "La fecha debe ser posterior a la actual")
	@Column(name = "CUR_FECH_FIN")
	private LocalDate fechaFin;

	@Min(value = 1, message = "El valor mínimo es 1")
	@Max(value = 5, message = "El valor máximo permitido es 5")
	@Column(name = "CUR_CANT_HORAS")
	private int cantidadHoras;

	@NotEmpty(message = "La modalidad no puede estar vacia")
	@Column(name = "CUR_MODALIDAD")
	private String modalidad;

	@Column(name = "CUR_SEMANAS")
	private int dos;
	
	// RELACIONES 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUR_DOCENTE_ID")
	private Docente docente;
	
	//@OneToOne(mappedBy = "curso", fetch = FetchType.LAZY)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUR_BECA_ID")
	private Beca beca;
	
	@ManyToMany(mappedBy="cursos", fetch = FetchType.LAZY)
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	// FIN RELACIONES

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", fechaFin=" + fechaFin
				+ ", fechaInicio=" + fechaInicio + ", cantidadHoras=" + cantidadHoras + ", modalidad=" + modalidad
				+ ", docente=" + docente + "]";
	}
}
