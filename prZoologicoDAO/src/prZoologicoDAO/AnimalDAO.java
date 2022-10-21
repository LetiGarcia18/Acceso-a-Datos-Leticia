package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AnimalDAO {
	
	private static Connection connection;
	
	//Borrar todos los animales
	public static void deleteAnimal() {
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
