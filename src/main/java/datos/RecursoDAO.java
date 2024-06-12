package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.RecursoJB;

public class RecursoDAO {
	
	public static final String selectSQL = "SELECT * from recurso where id_recurso=?;";
	public static final String selectPorEstacionSQL = 
			"SELECT recurso.id_recurso,recurso.numero, recurso.url, recurso.creditos, recurso.id_tipo_recurso, tipo_recurso.tipo FROM  estacion JOIN estacion_recurso ON estacion.id_estacion = estacion_recurso.id_estacion JOIN recurso ON estacion_recurso.id_recurso = recurso.id_recurso JOIN tipo_recurso ON recurso.id_tipo_recurso = tipo_recurso.id_tipo_recurso where estacion.id_estacion = ? ORDER BY recurso.numero ASC;";
	public static final String insertSQL = "INSERT INTO recurso (numero,url, creditos, id_tipo_recurso) VALUES (?,?,?,?);";
	public static final String updateSQL = "UPDATE recurso SET  numero=?, url=?, creditos=?, id_tipo_recurso=? where id_recurso=?;";
	public static final String deleteSQL = "DELETE FROM recurso WHERE id_recurso=?;";

	public RecursoJB select(int id_recurso){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        RecursoJB recurso = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_recurso);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numero = result.getInt("numero");
				String url = result.getString("url");
				String creditos = result.getString("creditos");
				int id_tipo_recurso = result.getInt("id_tipo_recurso");
				
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				recurso = new RecursoJB(id_recurso, numero, url, creditos, id_tipo_recurso);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return recurso;
	}
	
	public List<RecursoJB>  selectPorEstacion(int id_estacion){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        RecursoJB recurso = null;
		
		List<RecursoJB> lista_recursos = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorEstacionSQL);
            
            state.setInt(1,id_estacion);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_recurso = result.getInt("id_recurso");
				int numero = result.getInt("numero");
				String url = result.getString("url");
				String creditos = result.getString("creditos");
				int id_tipo_recurso = result.getInt("id_tipo_recurso");
				String tipo_recurso = result.getString("tipo");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				recurso = new RecursoJB(id_recurso,numero,url,creditos,id_tipo_recurso, tipo_recurso);
				lista_recursos.add(recurso);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_recursos;
	}

	public int insert(RecursoJB recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		int id_generado = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			
			state.setInt(1,recurso.get_numero());
			state.setString(2,recurso.get_url());
			state.setString(3,recurso.get_creditos());
			state.setInt(4,recurso.get_id_tipo_recurso());
			
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
	
	public int update(RecursoJB recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,recurso.get_numero());
			state.setString(2,recurso.get_url());
			state.setString(3,recurso.get_creditos());
			state.setInt(4,recurso.get_id_tipo_recurso());
			state.setInt(5,recurso.get_id_recurso());
			
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
