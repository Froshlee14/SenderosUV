package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.ZonaSenderoJB;

public class ZonaSenderoDAO {

	public static final String selectSQL = "SELECT * from zona_sendero where id_zona = ?;";
	public static final String insertSQL = "INSERT INTO zona_sendero (id_zona, id_sendero) VALUES (?,?);";
	public static final String deleteSQL = "DELETE FROM zona_sendero WHERE id_sendero=?;";
	
	public int insert(ZonaSenderoJB zona_sendero) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,zona_sendero.get_id_zona());
			state.setInt(2,zona_sendero.get_id_sendero());
			
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
