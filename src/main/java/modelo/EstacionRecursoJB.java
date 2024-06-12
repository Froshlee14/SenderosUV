package modelo;

import java.io.Serializable;

public class EstacionRecursoJB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id_estacion;
	private int id_recurso;
	
	public EstacionRecursoJB() {
		//Constructor vacio
	}

	public EstacionRecursoJB(int id_estacion, int id_recurso) {
		this.id_estacion = id_estacion;
		this.id_recurso = id_recurso;
	}

	public int get_id_estacion() {
		return id_estacion;
	}

	public void set_id_estacion(int id_estacion) {
		this.id_estacion = id_estacion;
	}

	public int get_id_recurso() {
		return id_recurso;
	}

	public void set_id_recurso(int id_recurso) {
		this.id_recurso = id_recurso;
	}
	
	
}
