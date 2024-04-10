package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.EstacionCartelJB;

public class EstacionCartelDAO {
	
	public static final String insertSQL = "INSERT INTO estacion_cartel (id_estacion, id_cartel) VALUES (?,?);";
	public static final String deleteSQL = "DELETE FROM estacion_cartel WHERE id_cartel=?;";

	public int insert(EstacionCartelJB estacion_cartel) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,estacion_cartel.get_id_estacion());
			state.setInt(2,estacion_cartel.get_id_cartel());
			
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
	
	public int delete(int id_cartel) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_cartel);
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
