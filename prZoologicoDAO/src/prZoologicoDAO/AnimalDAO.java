package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AnimalDAO {
	
	private static Connection connection;
	
	//Modificar animal:
	public static void updateAnimal(Animal animal) {
		connection = openConnection();
		
		int id = animal.getId();
		String nombre = animal.getNombre();
		String habitat = animal.getHabitat();
		double peso = animal.getPeso_aproximado();
		
		String query = "update animales set nombre = ?, habitat = ?, peso_aproximado = ? where id = ?";
		 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, habitat);
			preparedStatement.setDouble(3, peso);
			preparedStatement.setDouble(4, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	//Buscar todos los animales:
	public static ArrayList<Animal> findAllAnimales(){
		
		connection = openConnection();
		
		ArrayList<Animal> animales = new ArrayList<Animal>();
		String query = "select * from animales";
		Animal animal = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"), rs.getDouble("peso_aproximado"));
				animales.add(animal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
		
		
		return animales;
	}
	
	
	//Buscar un animal por id:
	public static Animal selectAnimalById(int id) {
		
		connection = openConnection();
		
		String query = "select * from animales where id = ?";
		Animal animal = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				animal = new Animal(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("habitat"), resultSet.getDouble("peso_aproximado"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return animal;
	}
	
	
	//Borrar un animal dado su nombre:
	public static void deleteAnimalByNombre(String nombre) {
		
		connection = openConnection();
		
		String query = "delete from animales where nombre = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nombre);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	
	//Borrar todos los animales:
	public static void deleteAllAnimales() {
		connection = openConnection();
		
		//Statement es para cuando no hay que pasarle ningún parámetro a la query
		//PrepareStatemen es para cuando sí que hay que pasarle parámetros a la query
		
		String query = "delete from animales";
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
	//Método para insertar los datos en la bd. En este caso, se le pasa  por parámetros en objeto Animal.
	public static void insertAnimal(Animal animal) {
		
		try {
			connection = openConnection(); //Abrimos una conexion
			
			String query = "insert into animales (nombre, habitat, peso_aproximado) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query); //Permite construir la sentencia sql con ?
			preparedStatement.setString(1, animal.getNombre()); //El primer parámetro (la primera interrogación) insertamos el nombre del animal 
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());
			
			preparedStatement.executeUpdate(); //Cuando queremos ejecutar cambios en la bd se utiliza el executeUpdate.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		closeConnection();
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
