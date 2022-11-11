package main;

import dao.AnimalDao;
import pojo.Animal;

public class Main {
	public static void main(String[] args) {
		
		Animal a = new Animal("Perro", "Canis", "Mamifero", false, false);
		/*AnimalDao ad = new AnimalDao();
		ad.insertar(a);*/
		System.out.println(a);
	}

}
