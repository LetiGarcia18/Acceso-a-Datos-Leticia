package main;

import dao.SerieDao;
import pojo.Serie;

public class MainSerie {

	public static void main(String[] args) {
		
		Serie serie = new Serie("Los Simpson", 7, "Disney Plus");
		SerieDao serieDao = new SerieDao();
		serieDao.insertar(serie);

	}

}
