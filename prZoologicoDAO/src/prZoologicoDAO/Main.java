package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		
		//Animal a = new Animal("Ardilla", "Bosque", 0.1);
		//AnimalDAO.insertAnimal(a); //Para insertar el animal en la bd
		//Animal b = new Animal("Kakapoo", "Bosque", 5);
		//AnimalDAO.insertAnimal(b);
		
		//AnimalDAO.deleteAllAnimales();
		
		//AnimalDAO.deleteAnimalByNombre("Ardilla");
		
		Animal a = AnimalDAO.selectAnimalById(5);
		System.out.println(a);

	}

}
