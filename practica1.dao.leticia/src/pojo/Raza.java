package pojo;

import java.util.ArrayList;

/**
 * Clase Raza que representa una raza
 * @author Leticia
 *
 */
public class Raza {
	/**
	 * Variable interna de tipo int que representa el id de la raza
	 */
	private int id;
	/**
	 * Variable interna de tipo String que representa el nombre de la raza
	 */
	private String nombre;
	/**
	 * Variable interna de tipo habitat que representa el habitat de la raza
	 */
	private String habitat;
	/**
	 * Variable interna de tipo booleana que representa si la raza es peligrosa
	 */
	private boolean esPeligrosa;
	/**
	 * Variable interna de tipo ArrayList de Animal que representa los animales que son de esa raza
	 */
	private ArrayList<Animal> animales;
	
	/**
	 * Constructor de Raza
	 * @param nombre Representa el nombre de la raza
	 * @param habitat Representa el habitat de la raza
	 * @param esPeligrosa Representa si es peligrosa
	 */
	public Raza(String nombre, String habitat, boolean esPeligrosa) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
	}

	/**
	 * Constructor de Raza
	 * @param id Representa el id de la raza
	 * @param nombre Representa el nombre de la raza
	 * @param habitat Representa el habitat de la raza
	 * @param esPeligrosa Representa si es peligrosa
	 * @param animales Representa a los animales que son de esa raza
	 */
	public Raza(int id, String nombre, String habitat, boolean esPeligrosa, ArrayList<Animal> animales) {
		this.id = id;
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
		this.animales = animales;
	}
	
	/**
	 * Constructor de Raza
	 * @param id Representa el id de la raza
	 * @param nombre Representa el nombre de la raza
	 * @param habitat Representa el habitat de la raza
	 * @param esPeligrosa Representa si es peligrosa
	 */
	public Raza(int id, String nombre, String habitat, boolean esPeligrosa) {
		this.id = id;
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
	}


	/**
	 * Getter del id de la raza
	 * @return Devuelve el id de la raza
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter del id de la raza. No devuelve nada.
	 * @param id El id de la raza
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter del nombre de la raza.
	 * @return Devuelve el nombre de la raza
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del nombre de la raza. No devuelve nada.
	 * @param nombre El nombre de la raza
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del habitat de la raza.
	 * @return Devuelve el habitat de la raza
	 */
	public String getHabitat() {
		return habitat;
	}

	/**
	 * Setter del habitat de la raza. No devuelve nada.
	 * @param habitat El habitat de la raza
	 */
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	/**
	 * Función que nos dice si la raza es peligrosa
	 * @return Devuelve true si es peligrosa o false si no lo es.
	 */
	public boolean isEsPeligrosa() {
		return esPeligrosa;
	}

	/**
	 * Setter de si la raza es peligrosa. No devuelve nada.
	 * @param esPeligrosa Se le pasa por parámetros true si es peligrosa, o false si no lo es.
	 */
	public void setEsPeligrosa(boolean esPeligrosa) {
		this.esPeligrosa = esPeligrosa;
	}

	/**
	 * Getter de animales.
	 * @return Devuelve todos lo animales que sean de esa raza
	 */
	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	/**
	 * Setter de animales. No devuelve nada.
	 * @param animales Una lista de los animales que pertenecen a esa raza.
	 */
	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}

	/**
	 * Función toString que devuelve una String con los datos de la raza.
	 */
	@Override
	public String toString() {
		String peligrosa = "";
		
		if(esPeligrosa) {
			peligrosa = "Si";
		}else {
			peligrosa = "No";
		}
		
		return "Raza --> id: " + id + " - Nombre: " + nombre + " - Habitat: " + habitat + " - Es peligrosa: " + peligrosa;
	}
	
	

}
