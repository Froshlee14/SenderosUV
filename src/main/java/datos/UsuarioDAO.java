package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.UsuarioJB;

public class UsuarioDAO {

	public static final String selectSQL = 
			"SELECT usuario.nombre, usuario.contrasena, usuario.id_rol_usuario, rol_usuario.rol_usuario FROM  usuario JOIN rol_usuario ON usuario.id_rol_usuario = rol_usuario.id_rol_usuario WHERE id_usuario = ?;";
	public static final String selectAllSQL = 
			"SELECT usuario.id_usuario, usuario.nombre, usuario.contrasena, usuario.id_rol_usuario, rol_usuario.rol_usuario FROM  usuario JOIN rol_usuario ON usuario.id_rol_usuario = rol_usuario.id_rol_usuario ORDER BY rol_usuario.rol_usuario;";
	public static final String selectPorRolSQL = 
			"SELECT usuario.id_usuario, usuario.nombre, usuario.id_rol_usuario, rol_usuario.rol_usuario FROM  usuario JOIN rol_usuario ON usuario.id_rol_usuario = rol_usuario.id_rol_usuario WHERE id_rol_usuario = ?;";
	public static final String selectPorNombreSQL = 
		    "SELECT usuario.id_usuario, usuario.contrasena, usuario.id_rol_usuario, rol_usuario.rol_usuario FROM usuario JOIN rol_usuario ON usuario.id_rol_usuario = rol_usuario.id_rol_usuario WHERE usuario.nombre = ?";
	public static final String insertSQL = "INSERT INTO usuario (nombre,contrasena,id_rol_usuario) VALUES (?,?,?);";
	public static final String updateSQL = "UPDATE usuario SET  nombre=?, contrasena=?, id_rol_usuario=? where id_usuario=?;";
	public static final String deleteSQL = "DELETE FROM usuario WHERE id_usuario=?;";
	
	public UsuarioJB select(int id_usuario){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        UsuarioJB usuario = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_usuario);
            
			result = state.executeQuery();
			
			while(result.next()) {
				String nombre = result.getString("nombre");
				String contrasena = result.getString("contrasena");
				int id_rol_usuario = result.getInt("id_rol_usuario");
				String rol_usuario = result.getString("rol_usuario");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				usuario = new UsuarioJB(id_usuario, nombre, contrasena, id_rol_usuario, rol_usuario);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public List<UsuarioJB>  selectPorRol(int id_rol_usuario){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        UsuarioJB usuario = null;
		
		List<UsuarioJB> lista_usuarios = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorRolSQL);
            
            //state.setInt(1,id_rol_usuario);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_usuario = result.getInt("id_usuario");
				String nombre = result.getString("nombre");
				String rol_usuario = result.getString("rol_usuario");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				usuario = new UsuarioJB(id_usuario,nombre,id_rol_usuario,rol_usuario);
				lista_usuarios.add(usuario);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_usuarios;
	}
	
	public List<UsuarioJB>  selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        UsuarioJB usuario = null;
		
		List<UsuarioJB> lista_usuarios = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
			result = state.executeQuery(selectAllSQL);
			
			while(result.next()) {
				int id_usuario = result.getInt("id_usuario");
				String nombre = result.getString("nombre");
				int id_rol_usuario = result.getInt("id_rol_usuario");
				String rol_usuario = result.getString("rol_usuario");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				usuario = new UsuarioJB(id_usuario,nombre,id_rol_usuario,rol_usuario);
				lista_usuarios.add(usuario);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_usuarios;
	}
	
	public UsuarioJB selectPorNombre(String nombre){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        UsuarioJB usuario = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorNombreSQL);
            
            state.setString(1,nombre);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_usuario = result.getInt("id_usuario");
				//String nombre = result.getString("nombre");
				String contrasena = result.getString("contrasena");
				int id_rol_usuario = result.getInt("id_rol_usuario");
				String rol_usuario = result.getString("rol_usuario");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				usuario = new UsuarioJB(id_usuario, nombre, contrasena, id_rol_usuario, rol_usuario);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	
	public int insert(UsuarioJB usuario) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,usuario.get_nombre());
			state.setString(2,usuario.get_contrasena());
			state.setInt(3,usuario.get_id_rol_usuario());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

	public int update(UsuarioJB usuario) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,usuario.get_nombre());
			state.setString(2,usuario.get_contrasena());
			state.setInt(3,usuario.get_id_rol_usuario());
			state.setInt(4,usuario.get_id_usuario());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int delete(int id_usuario) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_usuario);
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
}
