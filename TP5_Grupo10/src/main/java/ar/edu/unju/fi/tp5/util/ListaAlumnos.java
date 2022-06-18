package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.entity.Alumno;


/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Component
public class ListaAlumnos {
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

	public ListaAlumnos() {
		
	}

	public ArrayList<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
