package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada> {

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
	public void borrar(Temporada temporada) {
		connection = openConnection();

		int id = temporada.getId();
		
		String query = "delete from temporadas where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	
	public void borrarPorSerie(int serie_id) {
		connection = openConnection();
		
		String query = "delete from temporadas where serie_id = ?"; //Con esta query se van a borrar todas las temporadas de la serie indicada
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		closeConnection();
		
		
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

}
