package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Animal;
import pojo.Raza;

/**
 * Clase AnimalDao que representa el dao de la clase Animal. Hereda de la clase ObjetoDao e implementa de la interfaz InterfazDao<Animal>
 * @author Leticia
 *
 */
public class AnimalDao extends ObjetoDao implements InterfazDao<Animal> {

	/**
	 * Variable privada De tipo Connection que representa la conexión.
	 */
	private static Connection connection;

	/**
	 * Constructor de la clase vacío.
	 */
	public AnimalDao() {

	}

	/**
	 * Función que inserta un objeto en la base de datos . No devuelve nada. 
	 * @param Se le pasa por parámetros el objeto Animal que se quiere insertar.
	 */
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

	/**
	 * Función que modifica un objeto de la base de datos. No devuelve nada. 
	 * @param Se le pasa por parámetros el objeto Animal que se quiere modificar
	 */
	@Override
	public void modificar(Animal animal) {
		connection = openConnection();

		int id = animal.getId();
		String nuevoNombre = animal.getNombreComun();
		String nuevoNombreCientífico = animal.getNombreCientifico();
		String nuevoTipoAnimal = animal.getTipoAnimal();
		boolean nuevoEsDomestico = animal.isEsDomestico();
		boolean nuevoEstaEnPeligro = animal.isEnPeligroDeExtincion();
		Raza razaAnimal = animal.getRaza();

		String query = "update animales set nombreComun = ?, nombreCientifico = ?, tipoAnimal = ? , esDomestico = ?, "
				+ "enPeligroDeExtincion = ? , raza_id = ? where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nuevoNombre);
			ps.setString(2, nuevoNombreCientífico);
			ps.setString(3, nuevoTipoAnimal);
			ps.setBoolean(4, nuevoEsDomestico);
			ps.setBoolean(5, nuevoEstaEnPeligro);
			ps.setInt(6, razaAnimal.getId());
			ps.setInt(7, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	/**
	 * Función que borra un objeto de la base de datos. No devuelve nada. 
	 * @param Se le pasa por parámetros un objeto Animal que se quiere borrar.
	 */
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

	/**
	 * Función que borra animales de la base de datos por raza. No devuelve nada
	 * @param raza_id Id de la raza por la que se va a buscar en base de datos.
	 */
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

	/**
	 * Función que busca todos los animales de la base de datos. Decuelve un ArrayList de animales. No se le pasa nada por parámetros.
	 */
	@Override
	public ArrayList<Animal> buscarTodos() {
		ArrayList<Animal> animales = new ArrayList<>();

        connection = openConnection();

        String query = "select * from animales";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Animal animal = new Animal(rs.getInt("id"), rs.getString("nombreComun"), rs.getString("nombreCientifico"), rs.getString("tipoAnimal"), 
						rs.getBoolean("esDomestico"), rs.getBoolean("enPeligroDeExtincion"), null);

                 String query_razas = "select * from razas where id = ?";
                 PreparedStatement ps_raza = connection.prepareStatement(query_razas);
                 ps_raza.setInt(1, rs.getInt("id")); 
                 ResultSet rs_raza = ps_raza.executeQuery();

                 while(rs_raza.next()) {

                    Raza raza = new Raza(rs_raza.getInt("id"), rs_raza.getString("nombre"), rs_raza.getString("habitat"), rs_raza.getBoolean("esPeligrosa"));

                     if(rs_raza.getInt("id") == rs.getInt("id")) {
                         animal.setRaza(raza);
                     }
                 }

                 animales.add(animal);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return animales;
	}

	/**
	 * Función que busca por id a los animales en la base de datos. Devuelve un objeto Animal. 
	 * @param int id Id del animal que se quiere buscar en base de datos.
	 */
	@Override
	public Animal buscarPorId(int id) {
		connection = openConnection();

		String query = "select * from animales where id = ?";
		Animal animal = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int razaAnimalId = rs.getInt("raza_id");
				Raza razaAnimal = null;
				
				String query_raza = "select * from razas where id = ?";
				PreparedStatement ps_raza = connection.prepareStatement(query_raza);
				ps_raza.setInt(1, razaAnimalId); 
				ResultSet rs_raza = ps_raza.executeQuery();
				
				while(rs_raza.next()) {
					razaAnimal = new Raza(rs_raza.getInt("id"), rs_raza.getString("nombre"), rs_raza.getString("habitat"), rs_raza.getBoolean("esPeligrosa"));
				}
				
				animal = new Animal(rs.getInt("id"), rs.getString("nombreComun"), rs.getString("nombreCientifico"), rs.getString("tipoAnimal"), 
						rs.getBoolean("esDomestico"), rs.getBoolean("enPeligroDeExtincion"), razaAnimal);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return animal;
	}
	
	/**
	 * Clase que busca por nombre a un animal en la base de datos. 
	 * @param nombre Se le pasa el nombre del animal que se quiere buscar
	 * @return Devuelve el objeto animal
	 */
	public Animal buscarPorNombre(String nombre) {
		connection = openConnection();

		String query = "select * from animales where nombreComun = ?";
		Animal animal = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombreComun"), rs.getString("nombreCientifico"), rs.getString("tipoAnimal"), 
						rs.getBoolean("esDomestico"), rs.getBoolean("enPeligroDeExtincion"), null);
			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return animal;
	}

}