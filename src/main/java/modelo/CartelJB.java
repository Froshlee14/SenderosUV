package modelo;

import java.io.Serializable;

public class CartelJB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_cartel;
	private String descripcion;
	
	public CartelJB() {
		//Constructor vacio
	}

	public CartelJB(int id_cartel, String descripcion) {
		this.id_cartel = id_cartel;
		this.descripcion = descripcion;
	}

	public int get_id_cartel() {
		return id_cartel;
	}

	public void set_id_cartel(int id_cartel) {
		this.id_cartel = id_cartel;
	}

	public String get_descripcion() {
		return descripcion;
	}

	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
