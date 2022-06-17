package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.entity.Curso;

/**
 * 
 * @author JoaquinCorimayo
 *
 */


@Component
public class ListaCursos {
	/*
	 * Clase que gestiona la lista de Cursos.
	 * */
	
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public ListaCursos() {
		
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
}
