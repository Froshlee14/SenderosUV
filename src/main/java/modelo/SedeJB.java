package modelo;

import java.io.Serializable;

public class SedeJB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_sede;
	private String nombre;
	
	public SedeJB() {
		//Constructor vacio
	}

	public SedeJB(int id_sede, String nombre) {
		this.id_sede = id_sede;
		this.nombre = nombre;
	}

	public int get_id_sede() {
		return id_sede;
	}

	public void set_id_sede(int id_sede) {
		this.id_sede = id_sede;
	}

	public String get_nombre() {
		return nombre;
	}

	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
