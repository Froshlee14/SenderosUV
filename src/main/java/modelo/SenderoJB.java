package modelo;

import java.io.Serializable;
import java.util.Date;

public class SenderoJB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id_sendero;
	private String nombre;
	private Date year;
	private int id_zona;
	
	
	public SenderoJB() {
		//Constructor vacio
	}


	public SenderoJB(int id_sendero, String nombre, Date year, int id_zona) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.year = year;
		this.id_zona = id_zona;
	}


	public int get_id_sendero() {
		return id_sendero;
	}


	public void set_id_sendero(int id_sendero) {
		this.id_sendero = id_sendero;
	}


	public String get_nombre() {
		return nombre;
	}


	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}


	public Date get_year() {
		return year;
	}


	public void set_year(Date year) {
		this.year = year;
	}


	public int get_id_zona() {
		return id_zona;
	}


	public void set_id_zona(int id_zona) {
		this.id_zona = id_zona;
	}
	
	
	

}
