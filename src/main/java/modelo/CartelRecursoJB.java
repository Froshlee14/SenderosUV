package modelo;

import java.io.Serializable;

public class CartelRecursoJB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id_cartel;
	private int id_recurso;
	
	public CartelRecursoJB() {
		//Constructor vacio
	}

	public CartelRecursoJB(int id_cartel, int id_recurso) {
		this.id_cartel = id_cartel;
		this.id_recurso = id_recurso;
	}

	public int get_id_cartel() {
		return id_cartel;
	}

	public void set_id_cartel(int id_cartel) {
		this.id_cartel = id_cartel;
	}

	public int get_id_recurso() {
		return id_recurso;
	}

	public void set_id_recurso(int id_recurso) {
		this.id_recurso = id_recurso;
	}
	
	
}
