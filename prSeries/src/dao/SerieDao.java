package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {

	private static Connection connection;

	/**
	 * Se crea este constructor vacío que no hace nada para poder implementar una
	 * clase abstracta
	 */
	public SerieDao() {

	}

	@Override
	public void insertar(Serie serie) {
		connection = openConnection();

		String query = "insert into series(titulo, edad, plataforma) values (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Serie serie) {
		connection = openConnection();

		int id = serie.getId();
		String titulo = serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();

		String query = "update series set titulo = ?, edad = ?, plataforma = ? where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, titulo);
			preparedStatement.setInt(2, edad);
			preparedStatement.setString(3, plataforma);
			preparedStatement.setInt(4, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	public ArrayList<Temporada> obtenerTemporadas(Serie serie) {
		ArrayList<Temporada> temporadas = new ArrayList<>();

		connection = openConnection();

		String query = "select * from temporadas where serie_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Temporada temporada = new Temporada(rs.getInt("id"), rs.getInt("num_temporada"), rs.getString("titulo"), serie);
				temporadas.add(temporada);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//closeConnection();
		
		return temporadas;

	}
	

	@Override
	public void borrar(Serie serie) {
		int serie_id = serie.getId();
		
		SerieDao serieDao = new SerieDao();
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.borrarPorSerie(serie_id);
		
		connection = openConnection();
		
		String query = "delete from series where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();

			
	}

	@Override
	public ArrayList<Serie> buscarTodos() {

		connection = openConnection();

		ArrayList<Serie> series = new ArrayList<Serie>();
		String query = "select * from series";
		Serie serie = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("edad"),
						rs.getString("plataforma"), null);
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return series;
	}

	@Override
	public Serie buscarPorId(int id) {
		connection = openConnection();

		String query = "select * from series where id = ?";
		Serie serie = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				serie = new Serie(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getInt("edad"), resultSet.getString("plataforma"), null);
			}
			serie.setTemporadas(obtenerTemporadas(serie));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return serie;
	}

}
