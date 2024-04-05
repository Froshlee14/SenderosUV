package modelo;

import java.io.Serializable;

public class SenderoEstacionJB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_sendero;
	private int id_estacion;
	
	public SenderoEstacionJB() {
		//Constructor vacio
	}

	public SenderoEstacionJB(int id_sendero, int id_estacion) {
		this.id_sendero = id_sendero;
		this.id_estacion = id_estacion;
	}

	public int get_id_sendero() {
		return id_sendero;
	}

	public void set_id_sendero(int id_sendero) {
		this.id_sendero = id_sendero;
	}

	public int get_id_estacion() {
		return id_estacion;
	}

	public void set_id_estacion(int id_estacion) {
		this.id_estacion = id_estacion;
	}
	
}
