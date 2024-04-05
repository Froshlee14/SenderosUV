package modelo;

import java.io.Serializable;

public class ZonaSenderoJB implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_zona;
	private int id_sendero;
	
	public ZonaSenderoJB() {
	//Constructir vacio
	}

	public ZonaSenderoJB(int id_zona, int id_sendero) {
		this.id_zona = id_zona;
		this.id_sendero = id_sendero;
	}

	public int get_id_zona() {
		return id_zona;
	}

	public void set_id_zona(int id_zona) {
		this.id_zona = id_zona;
	}

	public int get_id_sendero() {
		return id_sendero;
	}

	public void set_id_sendero(int id_sendero) {
		this.id_sendero = id_sendero;
	}
	
	
	

	
}
