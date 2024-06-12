package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.TipoRecursoJB;

public class TipoRecursoDAO {
	public static final String selectSQL = "SELECT * from tipo_recurso where id_tipo_recurso=?;";
	public static final String selectAllSQL = "SELECT * from tipo_recurso";
	public static final String insertSQL = "INSERT INTO tipo_recurso (tipo) VALUES (?);";
	public static final String updateSQL = "UPDATE tipo_recurso SET  tipo=? where id_tipo_recurso=?;";
	public static final String deleteSQL = "DELETE FROM tipo_recurso WHERE id_tipo_recurso=?;";

	public TipoRecursoJB select(int id_tipo_recurso){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        TipoRecursoJB tipo_recurso = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_tipo_recurso);
            
			result = state.executeQuery();
			
			while(result.next()) {
				String tipo = result.getString("tipo");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				tipo_recurso = new TipoRecursoJB(id_tipo_recurso, tipo);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tipo_recurso;
	}
	
	public List<TipoRecursoJB> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        TipoRecursoJB tipo_recurso = null;
		
		List<TipoRecursoJB> lista_tipo_recursos = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectAllSQL);
			
			while(result.next()) {
				int id_tipo_recurso = result.getInt("id_tipo_recurso");
				String recurso = result.getString("recruso");
				
				tipo_recurso = new TipoRecursoJB(id_tipo_recurso,recurso);
				lista_tipo_recursos.add(tipo_recurso);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista_tipo_recursos;
	}
	
	public int insert(TipoRecursoJB tipo_recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,tipo_recurso.get_tipo());
			
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
	
	public int update(TipoRecursoJB tipo_recurso) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,tipo_recurso.get_tipo());
			state.setInt(4,tipo_recurso.get_id_tipo_recurso());
			
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
	
}
