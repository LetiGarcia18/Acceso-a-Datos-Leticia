package prZoologicoDAO;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//Animal a = new Animal("Ardilla", "Bosque", 0.1);
		//AnimalDAO.insertAnimal(a); //Para insertar el animal en la bd
		//Animal b = new Animal("Kakapoo", "Bosque", 5);
		//AnimalDAO.insertAnimal(b);
		
		//AnimalDAO.deleteAllAnimales();
		
		//AnimalDAO.deleteAnimalByNombre("Ardilla");
		
		Animal c = AnimalDAO.selectAnimalById(5);
		System.out.println(c);
		
		ArrayList<Animal> animales = new ArrayList<Animal>();
				
		animales = AnimalDAO.findAllAnimales();
		
		String listadoAnimales = "";
		
		for(int i = 0; i < animales.size(); i++) {
			listadoAnimales += animales.get(i) + "\n";
		}
		
		System.out.println(listadoAnimales);
		
		Animal e = AnimalDAO.selectAnimalById(9);
		e.setNombre("Gumersinda");
		AnimalDAO.updateAnimal(e);
		

	}

}
