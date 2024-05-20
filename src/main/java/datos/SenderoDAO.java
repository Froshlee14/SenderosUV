package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.SenderoJB;

public class SenderoDAO {
	
	public static final String selectSQL = 
			"SELECT sendero.id_sendero, sendero.nombre, sede.id_sede, sede.nombre, sendero.anio_fundacion, zona.id_zona, zona.nombre FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero JOIN sede ON sendero.id_sede = sede.id_sede where id_sendero = ?;";
	
	public static final String selectAllSQL = 
			"SELECT sendero.id_sendero, sendero.nombre, sede.id_sede, sede.nombre, sendero.anio_fundacion, zona.id_zona, zona.nombre FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero JOIN sede ON sendero.id_sede = sede.id_sede;";
	
	public static final String selectPorZonaSQL = 
			"SELECT sendero.id_sendero, sendero.nombre, sede.id_sede, sede.nombre, sendero.anio_fundacion, zona.id_zona, zona.nombre FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero JOIN sede ON sendero.id_sede = sede.id_sede where id_zona = ?;";
	
	public static final String insertSQL = "INSERT INTO sendero (nombre,id_sede,anio_fundacion,id_zona) VALUES (?,?,?,?);";
	public static final String updateSQL = "UPDATE sendero SET nombre=? id_sede=?, anio_fundacion=?, id_zona=? where id_sendero=?;";
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
				int id_sede = result.getInt("id_sede");
				String nombre_sede = result.getString("nombre_sede");
				Date year = result.getDate("anio_fundacion");
				int id_zona = result.getInt("id_zona");
				String nombre_zona = result.getString("nombre_zona");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				sendero = new SenderoJB(id_sendero,nombre,id_sede,nombre_sede,year,id_zona,nombre_zona);
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
				String nombre = result.getString("nombre");
				int id_sede = result.getInt("id_sede");
				String nombre_sede = result.getString("nombre_sede");
				Date year = result.getDate("anio_fundacion");
				int id_zona = result.getInt("id_zona");
				String nombre_zona = result.getString("nombre_zona");
				//boolean status = result.getBoolean("status");
				
				sendero = new SenderoJB(id_sendero,nombre,id_sede,nombre_sede,year,id_zona,nombre_zona);
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
				int id_sede = result.getInt("id_sede");
				String nombre_sede = result.getString("nombre_sede");
				Date year = result.getDate("anio_fundacion");
				//int id_zona = result.getInt("id_zona");
				String nombre_zona = result.getString("nombre_zona");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				sendero = new SenderoJB(id_sendero,nombre,id_sede,nombre_sede,year,id_zona,nombre_zona);
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
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,sendero.get_nombre());
			state.setInt(2,sendero.get_id_sede());
			state.setDate(3,(Date)sendero.get_year());
			state.setInt(4,sendero.get_id_zona());
			
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
	
	public int update(SenderoJB sendero) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,sendero.get_nombre());
			state.setInt(2,sendero.get_id_sede());
			state.setDate(3,(Date)sendero.get_year());
			state.setInt(4,sendero.get_id_zona());
			
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
