package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.ZonaJB;

public class ZonaDAO {
	
	public static final String selectZonasSQL = "SELECT * from zona;";
	public static final String selectSenderosSQL = "SELECT "
			+ "sendero.id_sendero, sendero.nombre, sendero.anio_fundacion, sede.nombre "
			+ "FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona"
			+ "JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero"
			+ "JOIN sede ON sendero.id_sede = sede.id_sede where id_zona = ?;";
	public static final String insertSQL = "INSERT INTO zona (nombre) VALUES (?);";
	public static final String updateSQL = "UPDATE zona SET nombre=? where id_zona=?;";
	public static final String deleteSQL = "DELETE FROM zona WHERE id_zona=?;";
	
	public List<ZonaJB> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		ZonaJB zona = null;
		
		List<ZonaJB> zonas = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectZonasSQL);
			
			while(result.next()) {
				int id_zona = result.getInt("id_zona");
				String nombre = result.getString("nombre");
				
				zona = new ZonaJB(id_zona,nombre);
				zonas.add(zona);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return zonas;
	}
	
	
	public int insert(ZonaJB zona) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,zona.get_nombre());
			
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
	
	public int update(ZonaJB zona) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,zona.get_nombre());
			state.setInt(2,zona.get_id_zona());
			
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
	
	public int delete(int id_zona) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_zona);
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
