package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Animal;
import pojo.Raza;

public class RazaDao extends ObjetoDao implements InterfazDao<Raza> {

	private static Connection connection;

	public RazaDao() {

	}

	@Override
	public void insertar(Raza raza) {
		connection = openConnection();

		String query = "insert into razas(nombre, habitat, esPeligrosa) values (?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, raza.getNombre());
			ps.setString(2, raza.getHabitat());
			ps.setBoolean(3, raza.isEsPeligrosa());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Raza raza) {
		connection = openConnection();

		int id = raza.getId();
		String nuevoNombre = raza.getNombre();
		String nuevoHabitat = raza.getHabitat();
		boolean nuevoEsPeligrosa = raza.isEsPeligrosa();

		String query = "update razas set nombre = ?, habitat = ?, esPeligrosa = ? where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nuevoNombre);
			ps.setString(2, nuevoHabitat);
			ps.setBoolean(3, nuevoEsPeligrosa);
			ps.setInt(4, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void borrar(Raza raza) {
		int raza_id = raza.getId();

		RazaDao razaDao = new RazaDao();
		AnimalDao animalDao = new AnimalDao();
		
		animalDao.borrarPorRaza(raza_id);

		connection = openConnection();

		String query = "delete from razas where id = ?";
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
	public ArrayList<Raza> buscarTodos() {
		connection = openConnection();

		ArrayList<Raza> razas = new ArrayList<Raza>();
		String query = "select * from razas";
		Raza raza = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				//Hacemos consulta para coger todos los animales de la raza que creamos después:
				ArrayList<Animal> animales = new ArrayList<Animal>();
				
				raza = new Raza(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"), rs.getBoolean("esPeligrosa"), animales); 
				
				
				
				String query_animales = "select * from animales where raza_id = ?";
				PreparedStatement ps_animales = connection.prepareStatement(query_animales);
				ps_animales.setInt(1, rs.getInt("id")); 
				ResultSet rs_animales = ps_animales.executeQuery();
				
				while(rs_animales.next()) {
					Animal animal = new Animal(rs_animales.getInt("id"), rs_animales.getString("nombreComun"), rs_animales.getString("nombreCientifico"), rs_animales.getString("tipoAnimal"), rs_animales.getBoolean("esDomestico"), rs_animales.getBoolean("enPeligroDeExtincion"), raza);
					animales.add(animal);
				}

				raza.setAnimales(animales); 
				//En este punto, la serie está completa.
				razas.add(raza);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return razas;
	}

	@Override
	public Raza buscarPorId(int id) {
		connection = openConnection();

		String query = "select * from razas where id = ?";
		Raza raza = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				raza = new Raza(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"), rs.getBoolean("esPeligrosa"));
				raza.setAnimales(obtenerAnimales(raza));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return raza;
	}
	
	
	public Raza buscarPorNombre(String nombre) {
		connection = openConnection();

		String query = "select * from razas where nombre = ?";
		Raza raza = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				raza = new Raza(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"), rs.getBoolean("esPeligrosa"));
			}

			raza.setAnimales(obtenerAnimales(raza));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return raza;
	}
	

	public ArrayList<Animal> obtenerAnimales(Raza raza) {
		ArrayList<Animal> animales = new ArrayList<>();

		connection = openConnection();

		String query = "select * from animales where raza_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, raza.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Animal animal = new Animal(rs.getInt("id"), rs.getString("nombreComun"), rs.getString("nombreCientifico"), rs.getString("tipoAnimal"), rs.getBoolean("esDomestico"), rs.getBoolean("enPeligroDeExtincion"), raza);
				animales.add(animal);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeConnection();

		return animales;
	}

}
