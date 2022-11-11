package pojo;

import java.util.ArrayList;

public class Animal {
	
	private int id;
	private String nombreComun;
	private String nombreCientifico;
	private String tipoAnimal;
	private boolean esDomestico;
	private boolean enPeligroDeExtincion;
	private ArrayList<Raza> razas;
	

	public Animal(String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion) {
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.tipoAnimal = tipoAnimal;
		this.esDomestico = esDomestico;
		this.enPeligroDeExtincion = enPeligroDeExtincion;
	}


	public Animal(int id, String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion, ArrayList<Raza> razas) {
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.tipoAnimal = tipoAnimal;
		this.esDomestico = esDomestico;
		this.enPeligroDeExtincion = enPeligroDeExtincion;
		this.razas = razas;
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


	public ArrayList<Raza> getRazas() {
		return razas;
	}


	public void setRazas(ArrayList<Raza> razas) {
		this.razas = razas;
	}


	@Override
	public String toString() {
		String domestico = "";
		
		if(esDomestico) {
			domestico = "Sí";
		}else {
			domestico = "No";
		}
		
		return "Animal --> \nid: " + id + "\nNombre común: " + nombreComun + "\nNombre científico: " + nombreCientifico
				+ "\nTipo animal: " + tipoAnimal + "\nEs doméstico: " + domestico + "\nEn peligro de extincion: "
				+ enPeligroDeExtincion;
	}
	
	

}
