package modelo;

import java.io.Serializable;
import java.util.Date;

public class SenderoJB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id_sendero;
	private String nombre;
	private String sede;
	private int logo;
	private Date year;
	private int id_zona;
	private String nombre_zona;
	
	
	public SenderoJB() {
		//Constructor vacio
	}


	public SenderoJB(int id_sendero, String nombre,String sede, int logo, Date year, int id_zona) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.sede = sede;
		this.logo = logo;
		this.year = year;
		this.id_zona = id_zona;
	}

	public SenderoJB(int id_sendero, String nombre, String sede, int logo, Date year, int id_zona, String nombre_zona) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.sede = sede;
		this.logo = logo;
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

	public String get_sede() {
		return sede;
	}


	public void set_sede(String sede) {
		this.sede = sede;
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


	public int get_logo() {
		return logo;
	}


	public void set_logo(int logo) {
		this.logo = logo;
	}
	
	
	

}
