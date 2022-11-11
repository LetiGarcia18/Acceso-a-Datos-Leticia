package pojo;

public class Raza {
	
	private int id;
	private String nombre;
	private String habitat;
	private boolean esPeligrosa;
	private Animal animal;
	
	public Raza(String nombre, String habitat, boolean esPeligrosa, Animal animal) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
		this.animal = animal;
	}


	public Raza(int id, String nombre, String habitat, boolean esPeligrosa, Animal animal) {
		this.id = id;
		this.nombre = nombre;
		this.habitat = habitat;
		this.esPeligrosa = esPeligrosa;
		this.animal = animal;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getHabitat() {
		return habitat;
	}


	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}


	public boolean isEsPeligrosa() {
		return esPeligrosa;
	}


	public void setEsPeligrosa(boolean esPeligrosa) {
		this.esPeligrosa = esPeligrosa;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	@Override
	public String toString() {
		String peligrosa = "";
		
		if(esPeligrosa) {
			peligrosa = "Sí";
		}else {
			peligrosa = "No";
		}
		
		return "Raza --> \nid: " + id + "\nNombre: " + nombre + "\nHabitat: " + habitat + "\nEs peligrosa: " + peligrosa
				+ "\nAnimal: " + animal.getNombreComun();
	}
	
	

}
