package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Animal;

public class AnimalDao  extends ObjetoDao implements InterfazDao<Animal>{
	
	private static Connection connection;
	
	public AnimalDao() {

	}

	@Override
	public void insertar(Animal animal) {
		connection = openConnection();

		String query = "insert into animales(nombreComun, nombreCientifico, tipoAnimal, esDomestico, enPeligroDeExtincion) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, animal.getNombreComun());
			ps.setString(2, animal.getNombreCientifico());
			ps.setString(3, animal.getTipoAnimal());
			ps.setBoolean(4, animal.isEsDomestico());
			ps.setBoolean(5, animal.isEnPeligroDeExtincion());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		
	}

	@Override
	public void modificar(Animal t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Animal t) {
		// TODO Auto-generated method stub
		
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
