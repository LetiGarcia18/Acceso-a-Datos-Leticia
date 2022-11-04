package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao implements InterfazDao<Temporada> {
	
	private static Connection connection;
	
	public TemporadaDao() {
		
	}

	@Override
	public void insertar(Temporada temporada) {
		connection = openConnection();

		String query = "insert into temporadas(num_temporada, titulo, serie_id) values (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, temporada.getNum_temporada());
			ps.setString(2, temporada.getTitulo());
			ps.setInt(3, temporada.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
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
