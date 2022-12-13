package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que realiza la conexión con la base de datos
 * 
 * @author letic
 *
 */
public class DatabaseConnection {
	/**
	 * Variable de tipo Connection que representa la conexión
	 */
	Connection connection;
	/**
	 * Función que establece la conexión con la base de datos
	 * @return Devuelve la conexión
	 */
	public Connection getConnection() {
		String bdName = "bd_animales_razas";
		String userName = "root";
		String password = "Midna1993";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + bdName, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

}
