package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.entity.Beca;

/**
 * 
 * @author JoaquinCorimayo
 *
 */


@Component
public class ListaBecas {

	private ArrayList<Beca> becas = new ArrayList<Beca>();
	
	public ListaBecas() {
		
	}
	
	public ArrayList<Beca> getBecas() {
		return this.becas;
	}

	public void setAlumnos(ArrayList<Beca> becas) {
		this.becas = becas;
	}
}
