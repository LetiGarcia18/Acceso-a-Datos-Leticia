package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;
/**
 * Clase padre donde se van a declarar m�todos comunes para las clases hijas que hereden de ella.
 * @author Leticia
 *
 */
public class ObjetoDao {
	/**
	 * Variable interna privada, de tipo Connection que representa la conexi�n a la base de datos.
	 */
	private static Connection connection;

	/**
	 * M�todo que abre la conexi�n con la base de datos.
	 * @return Devuelve la conexi�n.
	 */
	protected static Connection openConnection() {
		DatabaseConnection bdConnection = new DatabaseConnection();
		connection = bdConnection.getConnection();
		return connection;
	}

	/**
	 * M�todo que cierra la conexi�n con la base de datos.
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
