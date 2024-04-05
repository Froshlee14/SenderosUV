package modelo;

import java.io.Serializable;

public class TipoRecursoJB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_tipo_recurso;
	private String tipo;
	
	public TipoRecursoJB() {
		//Constructor vacio
	}

	public TipoRecursoJB(int id_tipo_recurso, String tipo) {
		this.id_tipo_recurso = id_tipo_recurso;
		this.tipo = tipo;
	}

	public int get_id_tipo_recurso() {
		return id_tipo_recurso;
	}

	public void set_id_tipo_recurso(int id_tipo_recurso) {
		this.id_tipo_recurso = id_tipo_recurso;
	}

	public String get_tipo() {
		return tipo;
	}

	public void set_tipo(String tipo) {
		this.tipo = tipo;
	}
	

}
