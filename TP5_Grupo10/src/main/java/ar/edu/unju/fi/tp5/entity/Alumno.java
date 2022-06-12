package ar.edu.unju.fi.tp5.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ALUMNO")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALU_ID")
	private Long id;

	@Min(value = 1000000, message = "El DNI del alumno debe ser mayor o igual a 1.000.000")
	@Column(name = "ALU_DNI")
	private String dni;

	@NotEmpty(message = "El nombre del alumno no puede ser vacío")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres")
	@Column(name = "ALU_NOMBRE")
	private String nombre;

	@NotEmpty(message = "El apellido del alumno no puede ser vacío")
	@Column(name = "ALU_APELLIDO")
	private String apellido;

	@NotEmpty(message = "El email del alumno no puede ser vacío")
	@Email
	@Column(name = "ALU_EMAIL")
	private String email;

	@NotEmpty(message = "El teléfono del alumno no puede ser vacío.")
	@Column(name = "ALU_TELEFONO")
	private String telefono;

	// RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALU_BECA_ID")
	private Beca beca;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "ALUMNOCURSO")
	private List<Curso> cursos = new ArrayList<Curso>();

	// FIN RELACIONES

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(String dni, String nombre, String apellido, String email, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}
