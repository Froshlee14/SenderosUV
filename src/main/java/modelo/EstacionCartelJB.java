package modelo;

import java.io.Serializable;

public class EstacionCartelJB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_estacion;
	private int id_cartel;
	
	public EstacionCartelJB() {
		//Constructir vacio
	}

	public EstacionCartelJB(int id_estacion, int id_cartel) {
		this.id_estacion = id_estacion;
		this.id_cartel = id_cartel;
	}

	public int get_id_estacion() {
		return id_estacion;
	}

	public void set_id_estacion(int id_estacion) {
		this.id_estacion = id_estacion;
	}

	public int get_id_cartel() {
		return id_cartel;
	}

	public void set_id_cartel(int id_cartel) {
		this.id_cartel = id_cartel;
	}	
	
}
