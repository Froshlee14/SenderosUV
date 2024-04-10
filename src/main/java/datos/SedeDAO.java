package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.SedeJB;

public class SedeDAO {
	
	public static final String selectSQL = "SELECT nombre FROM sede where id_sede = ?;";
	
	public static final String selectAllSQL = "SELECT * FROM sede;";

	public static final String insertSQL = "INSERT INTO sede (nombre) VALUES (?);";
	public static final String updateSQL = "UPDATE sede SET nombre=?  where id_sede=?;";
	public static final String deleteSQL = "DELETE FROM sede WHERE id_sede=?;";

	public SedeJB  select(int id_sede){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        SedeJB sede = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_sede);
            
			result = state.executeQuery();
			
			while(result.next()) {
				String nombre = result.getString("nombre");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				sede = new SedeJB(id_sede,nombre);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sede;
	}
	
	public List<SedeJB> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		SedeJB sede = null;
		
		List<SedeJB> lista_sedes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectAllSQL);
			
			while(result.next()) {
				int id_sede = result.getInt("id_sede");
				String nombre = result.getString("nombre");
				
				sede = new SedeJB(id_sede,nombre);
				lista_sedes.add(sede);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_sedes;
	}
	
	public int insert(SedeJB sede) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,sede.get_nombre());
			state.setInt(2,sede.get_id_sede());
			
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
	
	public int update(SedeJB sede) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,sede.get_id_sede());
			state.setString(2,sede.get_nombre());
			
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
	
	public int delete(int id_sede) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_sede);
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
