package pojo;
// Generated 25 Nov 2022, 14:02:57 by Hibernate Tools 5.5.9.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Temporadas generated by hbm2java
 */
@Entity
@Table(name = "temporadas")
public class Temporada implements java.io.Serializable {

	@Id //Esto es para decir que esta variable interna es un id
	@Column(name = "id") //Esto es para decir que pertenece a la columna id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Esto es decir que el id es autoincrementable
	private Integer id;
	
	@Column(name = "serie_id", unique = true, nullable = false)
	private Serie series;
	
	@Column(name = "num_temporada", unique = true, nullable = false)
	private int numTemporada;
	
	@Column(name = "titulo", unique = true, nullable = false, length = 100)
	private String titulo;

	public Temporada() {
	}

	public Temporada(Serie series, int numTemporada, String titulo) {
		this.series = series;
		this.numTemporada = numTemporada;
		this.titulo = titulo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Serie getSeries() {
		return this.series;
	}

	public void setSeries(Serie series) {
		this.series = series;
	}

	public int getNumTemporada() {
		return this.numTemporada;
	}

	public void setNumTemporada(int numTemporada) {
		this.numTemporada = numTemporada;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
