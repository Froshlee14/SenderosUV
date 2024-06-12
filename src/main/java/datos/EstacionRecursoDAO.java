package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.EstacionRecursoJB;

public class EstacionRecursoDAO {
	
	public static final String insertSQL = "INSERT INTO estacion_recurso (id_estacion, id_recurso) VALUES (?,?);";
	public static final String deleteSQL = "DELETE FROM estacion_recurso WHERE id_recurso=?;";
	
	public int insert(EstacionRecursoJB cartel_recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,cartel_recurso.get_id_estacion());
			state.setInt(2,cartel_recurso.get_id_recurso());
			
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
	
	public int delete(int id_recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_recurso);
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
