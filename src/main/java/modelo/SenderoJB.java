package modelo;

import java.io.Serializable;

public class SenderoJB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id_sendero;
	private String nombre;
	private String sede;
	private int year;
	private int id_zona;
	private String nombre_zona;
	private String url_recursos;


	public SenderoJB() {
		//Constructor vacio
	}


	public SenderoJB(int id_sendero, String nombre,String sede, int year, int id_zona, String url_recursos) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.sede = sede;
		this.year = year;
		this.id_zona = id_zona;
		this.url_recursos = url_recursos;
	}

	public SenderoJB(int id_sendero, String nombre, String sede, int year, int id_zona, String nombre_zona,String url_recursos) {
		this.id_sendero = id_sendero;
		this.nombre = nombre;
		this.sede = sede;
		this.year = year;
		this.id_zona = id_zona;
		this.nombre_zona = nombre_zona;
		this.url_recursos = url_recursos;
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


	public int get_year() {
		return year;
	}


	public void set_year(int year) {
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


	public String get_url_recursos() {
		return url_recursos;
	}


	public void set_url_recursos(String url_recursos) {
		this.url_recursos = url_recursos;
	}
	
	
	

}
