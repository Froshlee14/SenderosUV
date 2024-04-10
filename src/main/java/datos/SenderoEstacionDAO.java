package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.SenderoEstacionJB;

public class SenderoEstacionDAO {
	
	public static final String selectSQL = "SELECT * from sendero_estacion where id_sendero = ?;";
	public static final String insertSQL = "INSERT INTO sendero_estacion (id_sendero, id_estacion) VALUES (?,?);";
	public static final String deleteSQL = "DELETE FROM sendero_estacion WHERE id_estacion=?;";
	
	public int insert(SenderoEstacionJB sendero_estacion) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,sendero_estacion.get_id_sendero());
			state.setInt(2,sendero_estacion.get_id_estacion());
			
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
	
	public int delete(int id_estacion) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_estacion);
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
