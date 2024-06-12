package modelo;

import java.io.Serializable;

public class RecursoJB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_recurso;
	private int numero;
	private String url;
	private String creditos;
	private int id_tipo_recurso;
	private String tipo_recurso;
	
	
	public RecursoJB() {
		//Constructor vacio
	}

	public RecursoJB(int id_recurso,int numero, String url, String creditos, int id_tipo_recurso) {
		this.id_recurso = id_recurso;
		this.numero = numero;
		this.url = url;
		this.creditos = creditos;
		this.id_tipo_recurso = id_tipo_recurso;
	}


	public RecursoJB(int id_recurso,int numero, String url, String creditos, int id_tipo_recurso, String tipo_recurso) {
		this.id_recurso = id_recurso;
		this.numero = numero;
		this.url = url;
		this.creditos = creditos;
		this.id_tipo_recurso = id_tipo_recurso;
		this.tipo_recurso = tipo_recurso;
	}


	public int get_id_recurso() {
		return id_recurso;
	}


	public int get_numero() {
		return numero;
	}

	public void set_numero(int numero) {
		this.numero = numero;
	}

	public void set_id_recurso(int id_recurso) {
		this.id_recurso = id_recurso;
	}


	public String get_url() {
		return url;
	}


	public void set_url(String url) {
		this.url = url;
	}


	public String get_creditos() {
		return creditos;
	}


	public void set_creditos(String creditos) {
		this.creditos = creditos;
	}


	public int get_id_tipo_recurso() {
		return id_tipo_recurso;
	}


	public void set_id_tipo_recurso(int id_tipo_recurso) {
		this.id_tipo_recurso = id_tipo_recurso;
	}


	public String get_tipo_recurso() {
		return tipo_recurso;
	}


	public void set_tipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}
	
	
}
