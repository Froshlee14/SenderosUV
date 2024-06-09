package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.EstacionJB;

public class EstacionDAO {
	
	public static final String selectSQL = "SELECT * from estacion where id_estacion=?;";
	public static final String selectPorSenderoSQL = 
			"SELECT estacion.id_estacion, estacion.numero, estacion.nombre, estacion.descripcion, estacion.latitud, estacion.longitud FROM  estacion JOIN sendero_estacion ON estacion.id_estacion = sendero_estacion.id_estacion JOIN sendero ON sendero_estacion.id_sendero = sendero.id_sendero where sendero.id_sendero = ? ORDER BY estacion.numero ASC;";
	public static final String insertSQL = "INSERT INTO estacion (numero, nombre, descripcion,latitud,longitud) VALUES (?,?,?,?,?);";
	public static final String updateSQL = "UPDATE estacion SET numero=?, nombre=?, descripcion=?, latitud=?, longitud=? where id_estacion=?;";
	public static final String deleteSQL = "DELETE FROM estacion WHERE id_estacion=?;";
	public static final String deletePorSenderoSQL = 
			"DELETE FROM estacion WHERE id_estacion IN (SELECT estacion.id_estacion FROM estacion JOIN sendero_estacion ON estacion.id_estacion = sendero_estacion.id_estacion WHERE sendero_estacion.id_sendero = ?);";
	
	public EstacionJB select(int id_estacion){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		EstacionJB estacion = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_estacion);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numero = result.getInt("numero");
				String nombre = result.getString("nombre");
				String descripcion = result.getString("descripcion");
				String latitud = result.getString("latitud");
				String longitud = result.getString("longitud");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				estacion = new EstacionJB(id_estacion, numero, nombre, descripcion, latitud, longitud);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return estacion;
	}

	public List<EstacionJB> selectPorSendero(int id_sendero){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        EstacionJB estacion = null;
		
		List<EstacionJB> lista_estaciones = new ArrayList<>();
		
		try {
			conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorSenderoSQL);
            
            state.setInt(1,id_sendero);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_estacion = result.getInt("id_estacion");
				int numero = result.getInt("numero");
				String nombre = result.getString("nombre");
				String descripcion = result.getString("descripcion");
				String latitud = result.getString("latitud");
				String longitud = result.getString("longitud");
				
				estacion = new EstacionJB(id_estacion, numero, nombre, descripcion, latitud, longitud);
				lista_estaciones.add(estacion);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_estaciones;
	}
	
	public int insert(EstacionJB estacion) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		int id_generado = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			
			state.setInt(1,estacion.get_numero());
			state.setString(2,estacion.get_nombre());
			state.setString(3,estacion.get_descripcion());
			state.setString(4,estacion.get_latitud());
			state.setString(5,estacion.get_longitud());
			
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
	
	public int update(EstacionJB estacion) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,estacion.get_numero());
			state.setString(2,estacion.get_nombre());
			state.setString(3,estacion.get_descripcion());
			state.setString(4,estacion.get_latitud());
			state.setString(5,estacion.get_longitud());
			state.setInt(6,estacion.get_id_estacion());
			
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
	
	public int deletePorSendero(int id_sendero) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deletePorSenderoSQL);
			
			state.setInt(1,id_sendero);
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registros eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
}
