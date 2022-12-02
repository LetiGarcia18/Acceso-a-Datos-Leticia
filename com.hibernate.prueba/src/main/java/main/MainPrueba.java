package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import pojo.Animal;
import pojo.Zoologicos;
import util.HibernateUtil;

public class MainPrueba {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();  //La variable sesión lo que hace es iniciar la sesión.
		
		/*Animal a1 = new Animal("Yorshire", "Casa", new BigDecimal(1));
		
		//Para insertar se coge la sesion y le pasamos el objeto que hemos creado
		session.save(a1);*/


		/*int id = 10;
		Animal a = (Animal) session.get(Animal.class, id);
		System.out.println(a.getNombre());*/
		
		/*Animal a2 = new Animal("Kuokka", "Jungla", new BigDecimal(2));
		Animal a3 = new Animal("Conejo", "Campo", new BigDecimal(1.8));
		session.save(a2);
		session.save(a3);*/
		
		List animales = session.createQuery("FROM Animal").getResultList(); //En argumentos se pone el nombre del POJO, no de la tabla
		
		for(Iterator i = animales.iterator(); i.hasNext();) {
			Animal a = (Animal) i.next();
			System.out.println(a.getNombre());
		}
		
		Zoologicos z = new Zoologicos("Zoologico de Madrid", "Madrid", 1972);
		session.save(z);
		
		
		
		session.close(); //La variable sesión aquí lo que hace es cerrar sesión.

	}

}
