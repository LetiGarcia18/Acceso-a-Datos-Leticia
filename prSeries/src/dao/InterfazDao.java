package dao;

import java.util.ArrayList;

public interface InterfazDao<T>{
	/**
	 * Inserta en objeto T recibido en la base de datos.
	 * @param t Un objeto T
	 */
	public void insertar(T t);
	/**
	 * Modifica un objeto T de la base de datos.
	 * @param t Un objeto T.
	 */
	public void modificar(T t);
	/**
	 * Elimina un objeto T de la base de datos.
	 * @param t Un objeto T.
	 */
	public void borrar(T t);
	/**
	 * Muestra todos los objetos T de la base de datos.
	 * @return ArrayList de objetos T.
	 */
	public ArrayList<T> buscarTodos();
	/**
	 * Muestra el objeto T con el id especificado.
	 * @param i El id del objeto T
	 * @return Un objeto T
	 */
	public T buscarPorId(int i);

}
