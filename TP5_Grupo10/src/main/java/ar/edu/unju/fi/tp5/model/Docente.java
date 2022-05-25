package ar.edu.unju.fi.tp5.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
public class Docente {
	@Min(value=1000, message="El legajo del docente debe ser mayor o igual a 1.000")
	private int legajo;
	@NotEmpty(message="El nombre del docente no puede ser vacío")
	@Size(min=3, max=100, message="El nombre del docente debe tener entre 3 a 100 caracteres")
	private String nombre;
	@NotEmpty(message="El apellido del docente no puede ser vacío")
	private String apellido;
	@NotEmpty(message="El email del docente no puede ser vacío") 
	@Email
	private String email;
	@NotEmpty(message="El teléfono del docente no puede ser vacío.")
	private String telefono;
	

	public Docente() {
		// TODO Auto-generated constructor stub
	}
	
	public Docente(int legajo, String nombre, String apellido, String email, String telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
		return "Docente [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}
