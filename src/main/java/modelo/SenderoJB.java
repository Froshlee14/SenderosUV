package modelo;

import java.io.Serializable;
import java.util.Date;

public class SenderoJB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id_sendero;
	private String nombre;
	private int id_sede;
	private String nombre_sede;
	private Date year;
	private int id_zona;
	private String nombre_zona;
	
	
	public SenderoJB() {
		//Constructor vacio
	}


	public SenderoJB(int id_sendero, String nombre,int id_sede, Date year, int id_zona) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.id_sede = id_sede;
		this.year = year;
		this.id_zona = id_zona;
	}

	public SenderoJB(int id_sendero, String nombre,int id_sede, String nombre_sede, Date year, int id_zona, String nombre_zona) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.id_sede = id_sede;
		this.nombre_sede = nombre_sede;
		this.year = year;
		this.id_zona = id_zona;
		this.nombre_zona = nombre_zona;
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


	public int get_id_sede() {
		return id_sede;
	}


	public void set_id_sede(int id_sede) {
		this.id_sede = id_sede;
	}


	public String get_nombre_sede() {
		return nombre_sede;
	}


	public void set_nombre_sede(String nombre_sede) {
		this.nombre_sede = nombre_sede;
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


	public String get_nombre_zona() {
		return nombre_zona;
	}


	public void set_nombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}
	
	
	

}
