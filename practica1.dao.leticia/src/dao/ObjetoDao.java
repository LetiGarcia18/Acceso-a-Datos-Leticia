package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;
/**
 * Clase padre donde se van a declarar métodos comunes para las clases hijas que hereden de ella.
 * @author Leticia
 *
 */
public class ObjetoDao {
	/**
	 * Variable interna privada, de tipo Connection que representa la conexión a la base de datos.
	 */
	private static Connection connection;

	/**
	 * Método que abre la conexión con la base de datos.
	 * @return Devuelve la conexión.
	 */
	protected static Connection openConnection() {
		DatabaseConnection bdConnection = new DatabaseConnection();
		connection = bdConnection.getConnection();
		return connection;
	}

	/**
	 * Método que cierra la conexión con la base de datos.
	 */
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
