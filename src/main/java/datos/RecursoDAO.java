package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.RecursoJB;

public class RecursoDAO {
	
	public static final String selectSQL = "SELECT * from recurso where id_recurso=?;";
	public static final String selectPorCartelSQL = "SELECT"
			+ "recurso.id_recurso, recurso.url, recurso.creditos, recurso.id_tipo_recurso, tipo_recurso.tipo "
			+ "FROM  cartel JOIN cartel_recurso ON cartel.id_cartel = cartel_recurso.id_cartel"
			+ "JOIN recurso ON cartel_recurso.id_recurso = recurso.id_recurso"
			+ "JOIN tip_recurso ON recurso.id_tipo_recurso = tipo_recurso.id_tipo_recurso"
			+ " where id_cartel = ?;";
	public static final String insertSQL = "INSERT INTO recurso (url, creditos, tipo_recurso) VALUES (?,?);";
	public static final String updateSQL = "UPDATE recurso SET  url=?, creditos=?, id_tipo_recurso=? where id_recurso=?;";
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
				String url = result.getString("url");
				String creditos = result.getString("creditos");
				int id_tipo_recurso = result.getInt("id_tipo_recurso");
				
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				recurso = new RecursoJB(id_recurso, url, creditos, id_tipo_recurso);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return recurso;
	}
	
	public List<RecursoJB>  selectPorCartel(int id_cartel){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        RecursoJB recurso = null;
		
		List<RecursoJB> recursos = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorCartelSQL);
            
            state.setInt(1,id_cartel);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_recurso = result.getInt("id_recurso");
				String url = result.getString("url");
				String creditos = result.getString("creditos");
				int id_tipo_recurso = result.getInt("id_tipo_recurso");
				String tipo_recurso = result.getString("tipo");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				recurso = new RecursoJB(id_recurso,url,creditos,id_tipo_recurso, tipo_recurso);
				recursos.add(recurso);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return recursos;
	}

	public int insert(RecursoJB recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,recurso.get_url());
			state.setString(2,recurso.get_creditos());
			state.setInt(3,recurso.get_id_tipo_recurso());
			
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
	
	public int update(RecursoJB recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,recurso.get_url());
			state.setString(2,recurso.get_creditos());
			state.setInt(3,recurso.get_id_tipo_recurso());
			state.setInt(4,recurso.get_id_recurso());
			
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
