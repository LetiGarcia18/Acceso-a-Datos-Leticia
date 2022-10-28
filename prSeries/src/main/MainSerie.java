package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class MainSerie {

	public static void main(String[] args) {
		
		
		//Serie serie = new Serie("Los Simpson", 7, "Disney Plus");
		//Serie serie1 = new Serie(2, "Shinchan", 7, "Neox", null);
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		//serieDao.insertar(serie1);
		//System.out.println(serieDao.buscarPorId(3));
		
		Serie serie = serieDao.buscarPorId(3);
		
		Temporada temporada1 = new Temporada(1, "Temporada 1", serie);
		Temporada temporada2 = new Temporada(2, "Temporada 2", serie);
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.insertar(temporada1);
		

	}

}
