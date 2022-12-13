package pojo;

import java.util.ArrayList;

/**
 * Clase Animal que representa un animal.
 * @author Leticia
 *
 */
public class Animal {
	/**
	 * Variable tipo int que representa el id del animal
	 */
	private int id;
	/**
	 * Variable tipo String que representa el nombre común del animal
	 */
	private String nombreComun;
	/**
	 * Variable de tipo String que representa el nombre científico del animal.
	 */
	private String nombreCientifico;
	/**
	 * Variable de tipo String que representa el tipo de animal que es
	 */
	private String tipoAnimal;
	/**
	 * Variable de tipo booleana que representa si el animal es doméstico
	 */
	private boolean esDomestico;
	/**
	 * Variable de tipo booleana que representa si el animal está en peligro de extinción
	 */
	private boolean enPeligroDeExtincion;
	/**
	 * Variable de tipo Raza que representa la raza a la que pertenece el animal
	 */
	private Raza raza;
	

	/**
	 * Constructor de la clase Animal
	 * @param nombreComun Representa el nombre común del animal
	 * @param nombreCientifico Representa el nombre científico del animal.
	 * @param tipoAnimal Representa el tipo de animal que es
	 * @param esDomestico Representa si el animal es doméstico
	 * @param enPeligroDeExtincion Representa si el animal está en peligro de extinción
	 * @param raza Raza a la que pertenece el animal
	 */
	public Animal(String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion, Raza raza) {
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.tipoAnimal = tipoAnimal;
		this.esDomestico = esDomestico;
		this.enPeligroDeExtincion = enPeligroDeExtincion;
		this.raza = raza;
	}


	/**
	 * Constructor de la clase Animal
	 * @param id Representa el id del animal
	 * @param nombreComun Representa el nombre común del animal
	 * @param nombreCientifico Representa el nombre científico del animal.
	 * @param tipoAnimal Representa el tipo de animal que es
	 * @param esDomestico Representa si el animal es doméstico
	 * @param enPeligroDeExtincion Representa si el animal está en peligro de extinción
	 * @param raza Raza a la que pertenece el animal
	 */
	public Animal(int id, String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion, Raza raza) {
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.tipoAnimal = tipoAnimal;
		this.esDomestico = esDomestico;
		this.enPeligroDeExtincion = enPeligroDeExtincion;
		this.raza = raza;
	}


	/**
	 * Getter del id del animal
	 * @return Devuelve el id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Setter del id del animal. No devuelve nada.
	 * @param id El id del animal
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter del nombre común del animal. 
	 * @return Devuelve el nombre común
	 */
	public String getNombreComun() {
		return nombreComun;
	}

	/**
	 * Setter del nombre común del animal. No devuelve nada.
	 * @param nombreComun El nombre común del animal
	 */
	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	/**
	 * Getter del nombre científico del animal
	 * @return Devuelve el nombre científico
	 */
	public String getNombreCientifico() {
		return nombreCientifico;
	}

	/**
	 * Setter del nombre científico del animal. No devuelve nada.
	 * @param nombreCientifico El nombre científico del animal
	 */
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	/**
	 * Getter del tipo de animal. 
	 * @return Devuelve un tipo de animal
	 */
	public String getTipoAnimal() {
		return tipoAnimal;
	}

	/**
	 * Setter del tipo de animal. No devuelve nada
	 * @param tipoAnimal El tipo de animal
	 */
	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	/**
	 * Función que devuelve si es doméstico el animal
	 * @return devuelve true si es doméstico el animal o false si no lo es.
	 */
	public boolean isEsDomestico() {
		return esDomestico;
	}

	/**
	 * Setter de si es doméstico el animal. No devuelve nada
	 * @param esDomestico Se le pasa true si es doméstico, o false si no lo es
	 */
	public void setEsDomestico(boolean esDomestico) {
		this.esDomestico = esDomestico;
	}

	/**
	 * Función que nos dice si el animal está en peligro de extinción
	 * @return Devuelve true si está en peligro, y false si no lo está
	 */
	public boolean isEnPeligroDeExtincion() {
		return enPeligroDeExtincion;
	}

	/**
	 * Setter de si el animal está o no en peligro de extinción. No devuelve nada.
	 * @param enPeligroDeExtincion Se le pasa true si está en peligro, o false si no lo está
	 */
	public void setEnPeligroDeExtincion(boolean enPeligroDeExtincion) {
		this.enPeligroDeExtincion = enPeligroDeExtincion;
	}

	/**
	 * Getter de Raza. 
	 * @return Devuelve la raza a la que pertecene el animal
	 */
	public Raza getRaza() {
		return raza;
	}

	/**
	 * Setter de Raza. No devuelve nada
	 * @param raza La raza a la que pertenece el animal
	 */
	public void setRaza(Raza raza) {
		this.raza = raza;
	}


	/**
	 * Función que te devuelve un String con los datos del animal
	 */
	@Override
	public String toString() {
		String domestico = "";
		
		if(esDomestico) {
			domestico = "Si";
		}else {
			domestico = "No";
		}
		
		return "Animal --> id: " + id + " - Nombre común: " + nombreComun + " - Nombre científico: " + nombreCientifico
				+ " - Tipo animal: " + tipoAnimal + " - Es doméstico: " + domestico + " - En peligro de extincion: "
				+ enPeligroDeExtincion + " - Nombre raza: " + raza.getNombre();
	}

}
