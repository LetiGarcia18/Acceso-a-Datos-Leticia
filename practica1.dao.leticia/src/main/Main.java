package main;

import dao.AnimalDao;
import dao.RazaDao;
import pojo.Animal;
import pojo.Raza;

public class Main {
	public static void main(String[] args) {
		
		Raza r = new Raza("Gato esfinge", "Canada", false);

		Animal a = new Animal("Perro", "Canis", "Mamifero", false, false, r);
		AnimalDao animalDao = new AnimalDao();
		animalDao.insertar(a);
		System.out.println(a);
		
		// MODIFICAMOS UN ANIMAL:
		Animal a1 = animalDao.buscarPorId(1);
		a1.setNombreComun("Cacatua");
		animalDao.modificar(a1);
		System.out.println(a1);
		
		/*animalDao.borrar(a1);
		
		Raza r = new Raza("Dalmata", "Casas", false, a1);
		RazaDao razaDao = new RazaDao();
		razaDao.insertar(r);*/
	}

}
