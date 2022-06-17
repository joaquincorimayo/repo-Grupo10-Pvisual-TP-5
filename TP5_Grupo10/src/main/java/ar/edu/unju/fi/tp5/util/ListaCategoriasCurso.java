package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * 
 * @author JoaquinCorimayo
 *
 */


@Component
public class ListaCategoriasCurso {
	private ArrayList<String> categorias = new ArrayList<String>();
	
	public ListaCategoriasCurso() {
		categorias.add("Diploma Ciclo Básico");
		categorias.add("Diploma Ciclo de Perfeccionamiento");
		categorias.add("Diploma Ciclo Superior");
		categorias.add("Diploma Ciclo Superior II");
		categorias.add("Diploma Ciclo Master Profesional nivel goku super sayayin");
	}

	public ArrayList<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
	}

	
	
}
