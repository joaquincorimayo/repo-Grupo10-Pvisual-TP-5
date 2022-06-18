package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.entity.Docente;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */


@Component
public class ListaDocente {
	/*
	 * Clase que gestiona la lista de docentes.
	 */
	private ArrayList<Docente> docentes = new ArrayList<Docente>();

	public ListaDocente() {
	}

	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
}
