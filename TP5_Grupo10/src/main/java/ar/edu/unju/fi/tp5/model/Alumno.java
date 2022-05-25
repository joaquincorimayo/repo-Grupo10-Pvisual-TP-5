package ar.edu.unju.fi.tp5.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	@Min(value=1000000, message="El DNI del alumno debe ser mayor o igual a 1.000.000")
	private String dni;
	@NotEmpty(message="El nombre del alumno no puede ser vacío")
	@Size(min=3, max=100, message="El nombre debe tener entre 3 a 100 caracteres")
	private String nombre;
	@NotEmpty(message="El apellido del alumno no puede ser vacío")
	private String apellido;
	@NotEmpty(message="El email del alumno no puede ser vacío") 
	@Email
	private String email;
	@NotEmpty(message="El teléfono del alumno no puede ser vacío.")
	private String telefono;

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

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}
