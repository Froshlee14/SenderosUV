package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.SenderoJB;

public class SenderoDAO {
	
	public static final String selectSQL = 
			"SELECT sendero.id_sendero, sendero.nombre, sendero.sede, sendero.anio_fundacion, sendero.id_zona, zona.nombre as nombre_zona, sendero.url_recursos FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero where sendero.id_sendero = ?;";
	
	public static final String selectAllSQL = 
			"SELECT sendero.id_sendero, sendero.nombre, sendero.sede, sendero.anio_fundacion, sendero.id_zona, zona.nombre as nombre_zona, sendero.url_recursos FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero ;";
	
	public static final String selectPorZonaSQL = 
			"SELECT sendero.id_sendero, sendero.nombre, sendero.sede, sendero.anio_fundacion, sendero.id_zona, zona.nombre, sendero.url_recursos FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero  where id_zona = ?;";
	
	public static final String insertSQL = "INSERT INTO sendero (nombre,sede,anio_fundacion,id_zona,url_recursos) VALUES (?,?,?,?,?);";
	public static final String updateSQL = "UPDATE sendero SET nombre=?, sede=?, anio_fundacion=?, id_zona=?, url_recursos=? where id_sendero=?;";
	public static final String deleteSQL = "DELETE FROM sendero WHERE id_sendero=?;";

	
	
	public SenderoJB select(int id_sendero){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		SenderoJB sendero = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_sendero);
            
			result = state.executeQuery();
			
			while(result.next()) {
				String nombre = result.getString("nombre");
				String sede = result.getString("sede");
				int year = result.getInt("anio_fundacion");
				int id_zona = result.getInt("id_zona");
				String nombre_zona = result.getString("nombre_zona");
				String url_recursos = result.getString("url_recursos");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				System.out.println(id_zona);
				sendero = new SenderoJB(id_sendero,nombre,sede,year,id_zona,nombre_zona,url_recursos);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sendero;
	}
	
	public List<SenderoJB> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		SenderoJB sendero = null;
		
		List<SenderoJB> lista_senderos = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectAllSQL);
			
			while(result.next()) {
				int id_sendero = result.getInt("id_sendero");
				System.out.println(id_sendero);
				String nombre = result.getString("nombre");
				String sede = result.getString("sede");
				int year = result.getInt("anio_fundacion");
				int id_zona = result.getInt("id_zona");
				String nombre_zona = result.getString("nombre_zona");
				String url_recursos = result.getString("url_recursos");
				//boolean status = result.getBoolean("status");
				
				sendero = new SenderoJB(id_sendero,nombre,sede,year,id_zona,nombre_zona,url_recursos);
				lista_senderos.add(sendero);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_senderos;
	}
	
	public List<SenderoJB>  selectPorZona(int id_zona){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		SenderoJB sendero = null;
		
		List<SenderoJB> lista_senderos = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorZonaSQL);
            
            state.setInt(1,id_zona);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_sendero = result.getInt("id_sendero");
				String nombre = result.getString("nombre");
				String sede = result.getString("nombre_sede");
				int year = result.getInt("anio_fundacion");
				//int id_zona = result.getInt("id_zona");
				String nombre_zona = result.getString("nombre_zona");
				String url_recursos = result.getString("url_recursos");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				sendero = new SenderoJB(id_sendero,nombre,sede,year,id_zona,nombre_zona,url_recursos);
				lista_senderos.add(sendero);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_senderos;
	}
	
	public int insert(SenderoJB sendero) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		int id_generado = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			
			state.setString(1,sendero.get_nombre());
			state.setString(2,sendero.get_sede());
			state.setInt(3,sendero.get_year());
			state.setInt(4,sendero.get_id_zona());
			state.setString(5,sendero.get_url_recursos());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
				ResultSet generatedKeys = state.getGeneratedKeys();
		        if (generatedKeys.next()) {
		        	id_generado = generatedKeys.getInt(1);
		        	System.out.println("ID generada: " + id_generado);
		        }
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id_generado;
	}
	
	public int update(SenderoJB sendero) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,sendero.get_nombre());
			state.setString(2,sendero.get_sede());
			state.setInt(3,sendero.get_year());
			state.setInt(4,sendero.get_id_zona());
			state.setString(5,sendero.get_url_recursos());
			state.setInt(6,sendero.get_id_sendero());
			
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
	
	public int delete(int id_sendero) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_sendero);
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
