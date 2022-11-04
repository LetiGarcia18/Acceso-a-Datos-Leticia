package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import util.DatabaseConnection;

public class SerieDao implements InterfazDao<Serie>{
	
	private static Connection connection;
	
	/**
	 * Se crea este constructor vacío que no hace nada para poder implementar una clase abstracta
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
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return serie;
	}
	
	//Lo primero se crea un método para abrir la bd y para cerrarla:
		private static Connection openConnection() {
			DatabaseConnection bdConnection = new DatabaseConnection();
			connection = bdConnection.getConnection();
			return connection;
		}
		
		//Se crea un método para cerrar la bd:
		private static void closeConnection() {
			try {
				connection.close();
				connection = null; //Ponemos que es igual a null para cerrarla por completo, si no lo hacemos seguiría existiendo.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	

}
