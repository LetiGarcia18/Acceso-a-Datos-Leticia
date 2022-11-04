package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;

public class ObjetoDao {

	private static Connection connection;

	// Lo primero se crea un método para abrir la bd y para cerrarla:
	protected static Connection openConnection() {
		DatabaseConnection bdConnection = new DatabaseConnection();
		connection = bdConnection.getConnection();
		return connection;
	}

	// Se crea un método para cerrar la bd:
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null; // Ponemos que es igual a null para cerrarla por completo, si no lo hacemos seguiría existiendo.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
