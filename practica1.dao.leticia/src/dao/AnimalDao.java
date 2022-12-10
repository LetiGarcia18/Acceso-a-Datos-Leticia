package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Animal;
import pojo.Raza;

public class AnimalDao extends ObjetoDao implements InterfazDao<Animal> {

	private static Connection connection;

	public AnimalDao() {

	}

	@Override
	public void insertar(Animal animal) {
		connection = openConnection();

		String query = "insert into animales(nombreComun, nombreCientifico, tipoAnimal, esDomestico, enPeligroDeExtincion, raza_id) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, animal.getNombreComun());
			ps.setString(2, animal.getNombreCientifico());
			ps.setString(3, animal.getTipoAnimal());
			ps.setBoolean(4, animal.isEsDomestico());
			ps.setBoolean(5, animal.isEnPeligroDeExtincion());
			ps.setInt(6, animal.getRaza().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Animal animal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Animal animal) {
		connection = openConnection();

		int id = animal.getId();

		String query = "DELETE FROM animales WHERE id = ?";

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

	public void borrarPorRaza(int raza_id) {

		connection = openConnection();

		String query = "delete from animales where raza_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, raza_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public ArrayList<Animal> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animal buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}