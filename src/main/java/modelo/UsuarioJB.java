package modelo;

import java.io.Serializable;

public class UsuarioJB implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_usuario;
	private String nombre;
	private String contrasena;
	private int id_rol_usuario;
	private String rol_usuario;
	
	public UsuarioJB() {
		//Constructor bacio
	}

	public UsuarioJB(int id_usuario, String nombre, String contrasena, int id_rol_usuario) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.id_rol_usuario = id_rol_usuario;
	}

	public UsuarioJB(int id_usuario, String nombre, String contrasena, int id_rol_usuario, String rol_usuario) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.id_rol_usuario = id_rol_usuario;
		this.rol_usuario = rol_usuario;
	}

	public UsuarioJB(int id_usuario, String nombre, int id_rol_usuario, String rol_usuario) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.id_rol_usuario = id_rol_usuario;
		this.rol_usuario = rol_usuario;
	}

	public int get_id_usuario() {
		return id_usuario;
	}

	public void set_id_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String get_nombre() {
		return nombre;
	}

	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}

	public String get_contrasena() {
		return contrasena;
	}

	public void set_contrasena(String contrasena) {
		this.contrasena = contrasena;
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
