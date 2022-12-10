package pojo;

import java.util.ArrayList;

public class Animal {
	
	private int id;
	private String nombreComun;
	private String nombreCientifico;
	private String tipoAnimal;
	private boolean esDomestico;
	private boolean enPeligroDeExtincion;
	private Raza raza;
	

	public Animal(String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion, Raza raza) {
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.tipoAnimal = tipoAnimal;
		this.esDomestico = esDomestico;
		this.enPeligroDeExtincion = enPeligroDeExtincion;
		this.raza = raza;
	}


	public Animal(int id, String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion, Raza raza) {
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.tipoAnimal = tipoAnimal;
		this.esDomestico = esDomestico;
		this.enPeligroDeExtincion = enPeligroDeExtincion;
		this.raza = raza;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombreComun() {
		return nombreComun;
	}


	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}


	public String getNombreCientifico() {
		return nombreCientifico;
	}


	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}


	public String getTipoAnimal() {
		return tipoAnimal;
	}


	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}


	public boolean isEsDomestico() {
		return esDomestico;
	}


	public void setEsDomestico(boolean esDomestico) {
		this.esDomestico = esDomestico;
	}


	public boolean isEnPeligroDeExtincion() {
		return enPeligroDeExtincion;
	}


	public void setEnPeligroDeExtincion(boolean enPeligroDeExtincion) {
		this.enPeligroDeExtincion = enPeligroDeExtincion;
	}


	public Raza getRaza() {
		return raza;
	}


	public void setRaza(Raza raza) {
		this.raza = raza;
	}


	@Override
	public String toString() {
		String domestico = "";
		
		if(esDomestico) {
			domestico = "Si";
		}else {
			domestico = "No";
		}
		
		return "Animal --> \nid: " + id + "\nNombre com�n: " + nombreComun + "\nNombre cient�fico: " + nombreCientifico
				+ "\nTipo animal: " + tipoAnimal + "\nEs dom�stico: " + domestico + "\nEn peligro de extincion: "
				+ enPeligroDeExtincion + "\nNombre raza: " + raza.getNombre();
	}

}
