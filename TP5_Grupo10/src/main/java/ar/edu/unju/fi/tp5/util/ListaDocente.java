package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.model.Docente;

@Component
public class ListaDocente {
	/*
	 * Clase que gestiona la lista de docentes.
	 */
	private ArrayList<Docente> docentes;

	public ListaDocente() {
		docentes = new ArrayList<Docente>();
		docentes.add(new Docente(1000, "Alejandro", "Sanchez", "asanchez@mail.com", "3884789562"));
		docentes.add(new Docente(1010, "María", "Lamas", "mlamas@mail.com", "3884895210"));
		docentes.add(new Docente(1002, "Martina Adriana", "Perez", "mperez@mail.com", "3884120130"));
		docentes.add(new Docente(1003, "Pedro Antonio", "Miranda", "pmiranda@mail.com", "3884111999"));
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
}
