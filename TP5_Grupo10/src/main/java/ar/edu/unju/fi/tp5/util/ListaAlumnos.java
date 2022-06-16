package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.entity.Alumno;

@Component
public class ListaAlumnos {
	private ArrayList<Alumno> alumnos;

	/*
	 * Clase que gestiona la lista de Alumnos. Recurso:
	 * https://www.aleatorios.com/nombres
	 */

	public ListaAlumnos() {
//		alumnos = new ArrayList<Alumno>();
//		alumnos.add(new Alumno("40154242", "joaquin", "corimayo", "jasd@gmail.com", "388321231"));
//		alumnos.add(new Alumno("33112252", "Vlad", "Sharbat", "VladcSharbat@gmail.com", "38895911"));
//		alumnos.add(new Alumno("41523114", "Gian", "Taima", "Tawwima@gmail.com", "38893233"));
//		alumnos.add(new Alumno("95182012", "Miryam", "Nichole", "Miryamq14@gmail.com", "38899933"));
	}

	public ArrayList<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
