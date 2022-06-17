package ar.edu.unju.fi.tp5.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

/**
 * Clase que representa un objeto de tipo Curso
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
@Table(name = "CURSO")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUR_ID")
	private Long id;

	@Min(value = 1, message = "El valor mínimo permitido es 1000")
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

	@Column(name = "CUR_ESTADO")
	private boolean estado;

	// RELACIONes
	@NotNull(message = "Debe seleccionar un docente")
	@ManyToOne
	@JoinColumn(name = "DOC_ID")
	private Docente docente;

	@OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
	private Beca beca;
	// FIN RELACIONES

	public Curso() {

	}

	public Curso(Long id,
			@Min(value = 1, message = "El valor mínimo permitido es 1000") @Max(value = 9999, message = "El valor máximo permitido es 9999") int codigo,
			@NotEmpty(message = "El nombre del título no puede ser vacío") String titulo,
			@NotEmpty(message = "El nombre de la categoria no puede ser vacío") String categoria,
			@NotNull @FutureOrPresent(message = "La fecha debe ser hoy o posterior") LocalDate fechaInicio,
			@NotNull @Future(message = "La fecha debe ser posterior a la actual") LocalDate fechaFin,
			@Min(value = 1, message = "El valor mínimo es 1") @Max(value = 5, message = "El valor máximo permitido es 5") int cantidadHoras,
			@NotEmpty(message = "La modalidad no puede estar vacia") String modalidad, boolean estado, Docente docente,
			Beca beca) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.estado = estado;
		this.docente = docente;
		this.beca = beca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Beca getBeca() {
		return beca;
	}

	public void setBeca(Beca beca) {
		this.beca = beca;
	}

}
