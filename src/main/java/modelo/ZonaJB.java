package modelo;

import java.io.Serializable;

public class ZonaJB implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_zona;
	private String nombre;
	
	public ZonaJB() {
		//Constructor vacio
	}
	
	public ZonaJB(int id_zona) {
		this.id_zona = id_zona;
	}

	public ZonaJB(int id_zona, String nombre) {
		this.id_zona = id_zona;
		this.nombre = nombre;
	}

	public int get_id_zona() {
		return id_zona;
	}
	public void set_id_zona(int id_zona) {
		this.id_zona = id_zona;
	}
	public String get_nombre() {
		return nombre;
	}
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
