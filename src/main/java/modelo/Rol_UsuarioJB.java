package modelo;

import java.io.Serializable;

public class Rol_UsuarioJB implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_rol_usuario;
	private String rol_usuario;

	public Rol_UsuarioJB() {
		//Constructor vacio
	}
	
	public Rol_UsuarioJB(int id_rol_usuario, String rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
		this.rol_usuario = rol_usuario;
	}

	public int get_id_rol_usuario() {
		return id_rol_usuario;
	}

	public void set_id_rol_usuario(int id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}

	public String get_rol_usuario() {
		return rol_usuario;
	}

	public void set_rol_usuario(String rol_usuario) {
		this.rol_usuario = rol_usuario;
	}
	
	
	
	

}
