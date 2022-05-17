package ar.edu.unju.fi.tp5.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.tp5.model.Beca;
import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.model.Docente;

public class ListaBecas {
	/*
	 * Clase que gestiona la lista de Becas.
	 * */
	private ArrayList<Beca> becas;
	
	public ListaBecas() {
		becas = new ArrayList<Beca>();
		LocalDate fechaInicio, fechaFin;
		Curso curso;
		Docente docente;			
		
		fechaInicio = LocalDate.of(2022, 2, 14);
		fechaFin = LocalDate.of(2022, 2, 21);
		docente = new Docente(1522156, "Len", "Severiano", "algun_correo@gmail.com", "1060444526");
		curso = new Curso(100, "Alemán", "Diploma Ciclo Básico", fechaFin, fechaInicio, 4, "Virtual", docente);
		becas.add(new Beca(1, curso, LocalDate.of(2022, 04, 15), LocalDate.of(2022, 07, 15), "Virtual"));

		fechaInicio = LocalDate.of(2022, 3, 5);
		fechaFin = LocalDate.of(2022, 3, 17);
		docente = new Docente(1522156, "Romilda", "Zosimo", "algun_correo@gmail.com", "451690179");
		curso = new Curso(101, "Árabe", "Diploma Ciclo de Perfeccionamiento", fechaFin, fechaInicio, 5, "Presencial", docente);
		becas.add(new Beca(2, curso, LocalDate.of(2022, 03, 15), LocalDate.of(2022, 06, 15), "Virtual"));
		
		fechaInicio = LocalDate.of(2022, 6, 14);
		fechaFin = LocalDate.of(2022, 6, 21);
		docente = new Docente(1522156, "Winema", "Whitney", "algun_correo@gmail.com", "667897057");
		curso = new Curso(102, "Chino", "Diploma Ciclo Superior", fechaFin, fechaInicio, 4, "Presencial", docente);
		becas.add(new Beca(3, curso, LocalDate.of(2022, 02, 15), LocalDate.of(2022, 05, 15), "Virtual"));
		
		fechaInicio = LocalDate.of(2022, 8, 5);
		fechaFin = LocalDate.of(2022, 8, 17);
		docente = new Docente(1522156, "Neil", "Lewa", "algun_correo@gmail.com", "561725305");
		curso = new Curso(1, "Coreano", "Diploma Ciclo Básico", fechaFin, fechaInicio, 2, "Presencial", docente);
		becas.add(new Beca(4, curso, LocalDate.of(2022, 01, 15), LocalDate.of(2022, 04, 15), "Virtual"));
		
		fechaInicio = LocalDate.of(2022, 11, 10);
		fechaFin = LocalDate.of(2022, 11, 24);
		docente = new Docente(1522156, "Wiñay", "Mangena", "algun_correo@gmail.com", "660527966");
		curso = new Curso(1, "Hindi", "Diploma Ciclo Superior", fechaFin, fechaInicio, 6, "Virtual", docente);
		becas.add(new Beca(5, curso, LocalDate.of(2022, 01, 15), LocalDate.of(2022, 03, 15), "Virtual"));
	}
	
	public ArrayList<Beca> getBecas() {
		return this.becas;
	}

	public void setAlumnos(ArrayList<Beca> becas) {
		this.becas = becas;
	}
}
