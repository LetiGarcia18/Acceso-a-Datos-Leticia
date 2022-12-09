package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class MainSerie {

	public static void main(String[] args) {
		
		
		//Serie serie = new Serie("Los Simpson", 7, "Disney Plus");
		//Serie serie2 = new Serie(2, "Shinchan", 7, "Neox", null);
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		//serieDao.insertar(serie2);
		//System.out.println(serieDao.buscarPorId(3));
		
		//Serie serie = serieDao.buscarPorId(3);
		
		/*Temporada temporada1 = new Temporada(1, "Temporada 1", serie);
		Temporada temporada2 = new Temporada(2, "Temporada 2", serie);
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.insertar(temporada1);*/
		
		//Serie s = new Serie("The Mandalorian", 12, "DisneyPlus");
		//serieDao.insertar(s);
		
		//MODIFICAMOS uNA SERIE:
		//Serie shinchan = serieDao.buscarPorId(3);
		//shinchan.setPlataforma("Netflix");
		//serieDao.modificar(shinchan);
		
		/*ArrayList<Temporada> temporadasShinchan = serieDao.obtenerTemporadas(shinchan);
		for(Temporada temporada : temporadasShinchan) {
			System.out.println(temporada + "\n-----------------------------------------------------------------------------------");
		}*/
		
		//BUSCAMOS TODAS LAS SERIES:
		ArrayList<Serie> series = serieDao.buscarTodos();
		/*String todasSeries = "";
		for(int i = 0; i < series.size(); i++) {
			todasSeries += series.get(i) + "\n";
		}
		System.out.println(todasSeries + "\n------------------------------------------------------------------------------------\n");*/
		
		//EL MISMO BUCLE PARA IMPRIMIR EL ARRAYLIST PERO HECHO CON foreach:
		for (Serie serie : series) {
			System.out.println("SERIE: " + serie.getTitulo());
			for (Temporada temporada : serie.getTemporadas()) {
				System.out.println("TEMPORADA: " + temporada.getTitulo());
			}
		}
		
		//SerieDao serieDao = new SerieDao();
		//TemporadaDao temporadaDao = new TemporadaDao();
		
		//Serie s = serieDao.buscarPorId(3);
		/*
		Temporada t1 = new Temporada(1, "The Mandalorian season 1", s);
		Temporada t2 = new Temporada(2, "The Mandalorian season 2", s);
		Temporada t3 = new Temporada(3, "The Mandalorian final season", s);
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		temporadaDao.insertar(t3);*/
		
		//temporadaDao.borrarPorSerie(9);
		
		//serieDao.borrar(s);
		
		


		
		
		
		

	}

}
