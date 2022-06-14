package ar.edu.unju.fi.tp5.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "DOCENTE")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID")
	private Long id;

	@Min(value = 1000, message = "El legajo del docente debe ser mayor o igual a 1.000")
	@Column(name = "DOC_LEGAJO")
	private int legajo;

	@NotEmpty(message = "El nombre del docente no puede ser vacío")
	@Size(min = 3, max = 100, message = "El nombre del docente debe tener entre 3 a 100 caracteres")
	@Column(name = "DOC_NOMBRE")
	private String nombre;

	@NotEmpty(message = "El apellido del docente no puede ser vacío")
	@Column(name = "DOC_APELLIDO")
	private String apellido;

	@NotEmpty(message = "El email del docente no puede ser vacío")
	@Email
	@Column(name = "DOC_EMAIL")
	private String email;

	@NotEmpty(message = "El teléfono del docente no puede ser vacío.")
	@Column(name = "DOC_TELEFONO")
	private String telefono;
	
	@Column (name="DOC_ESTADO")
	private boolean estado;
	
	public Docente() {
	
	}
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Docente [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}
