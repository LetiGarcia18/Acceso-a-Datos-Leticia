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
		
		//Statement es para cuando no hay que pasarle ning�n par�metro a la query
		//PrepareStatemen es para cuando s� que hay que pasarle par�metros a la query
		
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
	
	//M�todo para insertar los datos en la bd. En este caso, se le pasa  por par�metros en objeto Animal.
	public static void insertAnimal(Animal animal) {
		
		try {
			connection = openConnection(); //Abrimos una conexion
			
			String query = "insert into animales (nombre, habitat, peso_aproximado) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query); //Permite construir la sentencia sql con ?
			preparedStatement.setString(1, animal.getNombre()); //El primer par�metro (la primera interrogaci�n) insertamos el nombre del animal 
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());
			
			preparedStatement.executeUpdate(); //Cuando queremos ejecutar cambios en la bd se utiliza el executeUpdate.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		closeConnection();
	}
	
	//Lo primero se crea un m�todo para abrir la bd y para cerrarla:
	private static Connection openConnection() {
		DatabaseConnection bdConnection = new DatabaseConnection();
		connection = bdConnection.getConnection();
		return connection;
	}
	
	//Se crea un m�todo para cerrar la bd:
	private static void closeConnection() {
		try {
			connection.close();
			connection = null; //Ponemos que es igual a null para cerrarla por completo, si no lo hacemos seguir�a existiendo.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
