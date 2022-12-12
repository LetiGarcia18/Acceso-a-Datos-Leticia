package main;

import java.util.ArrayList;
import java.util.Iterator;

import dao.AnimalDao;
import dao.RazaDao;
import pojo.Animal;
import pojo.Raza;

public class Main {
	
	private static RazaDao razaDao;
	private static AnimalDao animalDao;
	
	public static void main(String[] args) {
		
		razaDao = new RazaDao();
		animalDao = new AnimalDao();
		
		//INSERCCIÓN
		System.out.println("INSERCCIÓN DE DATOS:");
		Raza razaGato = insertarRaza("Gato esfinge", "Canada", false);
		Raza razaPerro1 = insertarRaza("Pastor Alemán", "Bosques", true);
		Raza razaPerro2 = insertarRaza("Caniche", "Casa", false);
		
		Animal gato1 = insertarAnimal("Pochoclo", "TODO", "Mamifero", true, false, razaGato);
		Animal gato2 = insertarAnimal("Lola", "TODO", "Mamifero", true, false, razaGato);
		Animal perro1 = insertarAnimal("Evaristo", "TODO", "Mamifero", true, false, razaPerro1);
		Animal perro2 = insertarAnimal("Lorenzo", "TODO", "Mamifero", true, false, razaPerro1);
		Animal perro3 = insertarAnimal("Peter", "TODO", "Mamifero", true, false, razaPerro2);
		
		
		//CONSULTA
		System.out.println("\n\nCONSULTA DE DATOS: ");
		System.out.println("Razas insertadas en base de datos con sus animales correspondientes: ");
		ArrayList<Raza> razas = razaDao.buscarTodos();
		for (Raza raza : razas) {
			System.out.println(raza);
			
			for (Animal animal : raza.getAnimales()) {
				System.out.println(animal);
			}
		}
		
		
		//MODIFICACIÓN
		System.out.println("\n\nMODIFICACIÓN DE DATOS:");
		razaGato.setNombre("Gato Azul ruso");
		razaDao.modificar(razaGato);
		Raza razaGatoModificada = razaDao.buscarPorId(razaGato.getId());
		System.out.println("Raza de gato modificada: " + razaGatoModificada);
		
		perro1.setRaza(razaPerro2);
		animalDao.modificar(perro1);
		Animal perroModificado = animalDao.buscarPorId(perro1.getId());
		System.out.println("Perro modificado: " + perroModificado);
		
		//ELIMINACIÓN
		System.out.println("\n\nELIMINACIÓN DE DATOS: ");
		int idAnimalParaBorrar = gato1.getId();
		animalDao.borrar(gato1);
		Animal animalBorrado = animalDao.buscarPorId(idAnimalParaBorrar);
		if (animalBorrado == null) {
			System.out.println("Animal con id " + idAnimalParaBorrar + " borrado con éxito.");
		} else {
			System.err.println("Animal con id " + idAnimalParaBorrar + " no borrado.");
		}
		
		int idRazaParaBorrar = razaPerro2.getId();
		Raza razaParaBorrar = razaDao.buscarPorId(idRazaParaBorrar);
		ArrayList<Animal> animalesParaBorrar = razaParaBorrar.getAnimales();
		razaDao.borrar(razaParaBorrar);
		Raza razaBorrada = razaDao.buscarPorId(idRazaParaBorrar);
		if (razaBorrada == null) {
			System.out.println("Raza con id " + idRazaParaBorrar + " borrada con éxito.");
		} else {
			System.err.println("Raza con id " + idRazaParaBorrar + " no borrada.");
		}
		for (Animal animalParaBorrar : animalesParaBorrar) {
			Animal animalDeRazaBorrado = animalDao.buscarPorId(animalParaBorrar.getId());
			if (animalDeRazaBorrado == null) {
				System.out.println("Animal con id " + animalParaBorrar.getId() + " de la raza con id " + idRazaParaBorrar + " borrado con éxito.");
			} else {
				System.err.println("Animal con id " + animalParaBorrar.getId() + " de la raza con id " + idRazaParaBorrar + " no borrado.");
			}
		}
	}
	
	private static Raza insertarRaza(String nombre, String habitat, boolean esPeligroso) {
		Raza raza = new Raza(nombre, habitat, esPeligroso);
		razaDao.insertar(raza);
		raza = razaDao.buscarPorNombre(nombre);
		System.out.println("Insertado: " + raza);
		return raza;
	}
	
	private static Animal insertarAnimal(String nombreComun, String nombreCientifico, String tipoAnimal, boolean esDomestico, boolean enPeligroDeExtincion, Raza raza) {
		Animal animal = new Animal(nombreComun, nombreCientifico, tipoAnimal, esDomestico, enPeligroDeExtincion, raza);
		animalDao.insertar(animal);
		animal = animalDao.buscarPorNombre(nombreComun);
		animal.setRaza(raza);
		System.out.println("Insertado: " + animal);
		return animal;
	}
}
