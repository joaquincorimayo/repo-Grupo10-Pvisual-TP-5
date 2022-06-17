package ar.edu.unju.fi.tp5.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un objeto de tipo alumno
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
@Table(name = "ALUMNO")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALU_ID")
	private Long id;

	@Max(value = 99999999, message = "DNI debe ser menor que 99999999")
	@Min(value = 1000000, message = "DNI debe ser mayor que 1000000")
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

	@Column(name = "ALU_ESTADO")
	private boolean estado;

	public Alumno() {

	}

	public Alumno(Long id,
			@Max(value = 99999999, message = "DNI debe ser menor que 99999999") @Min(value = 1000000, message = "DNI debe ser mayor que 1000000") String dni,
			@NotEmpty(message = "El nombre del alumno no puede ser vacío") @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres") String nombre,
			@NotEmpty(message = "El apellido del alumno no puede ser vacío") String apellido,
			@NotEmpty(message = "El email del alumno no puede ser vacío") @Email String email,
			@NotEmpty(message = "El teléfono del alumno no puede ser vacío.") String telefono, boolean estado) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
				+ email + ", telefono=" + telefono + ", estado=" + estado + "]";
	}
}
