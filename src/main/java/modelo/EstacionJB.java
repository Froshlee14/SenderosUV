package modelo;

import java.io.Serializable;

public class EstacionJB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_estacion;
	private int numero;
	private String nombre;
	private String descripcion;
	private String latitud;
	private String longitud;
	
	public EstacionJB() {
		//Constructor vacio
	}

	public EstacionJB(int id_estacion, int numero, String nombre, String descripcion, String latitud, String longitud) {
		this.id_estacion = id_estacion;
		this.numero = numero;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int get_id_estacion() {
		return id_estacion;
	}

	public void set_id_estacion(int id_estacion) {
		this.id_estacion = id_estacion;
	}

	public int get_numero() {
		return numero;
	}

	public void set_numero(int numero) {
		this.numero = numero;
	}

	public String get_nombre() {
		return nombre;
	}

	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}

	public String get_descripcion() {
		return descripcion;
	}

	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String get_latitud() {
		return latitud;
	}

	public void set_latitud(String latitud) {
		this.latitud = latitud;
	}

	public String get_longitud() {
		return longitud;
	}

	public void set_longitud(String longitud) {
		this.longitud = longitud;
	}
	
	
	
	

}
