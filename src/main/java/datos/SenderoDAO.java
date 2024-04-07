package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.SenderoJB;

public class SenderoDAO {
	
	public static final String selectSQL = "SELECT * from sendero where id_sendero = ?;";
	public static final String selectAllSQL = "SELECT * from sendero;";
	public static final String selectPorZonaSQL = "SELECT "
			+ "sendero.id_sendero, sendero.nombre, sede.nombre, sendero.anio_fundacion, zona.nombre "
			+ "FROM  zona JOIN zona_sendero ON zona.id_zona = zona_sendero.id_zona"
			+ "JOIN sendero ON zona_sendero.id_sendero = sendero.id_sendero"
			+ "JOIN sede ON sendero.id_sede = sede.id_sede where id_zona = ?;";
	public static final String insertSQL = "INSERT INTO sendero (nombre,id_sede,anio_fundacion,id_zona) VALUES (?,?,?,?);";
	public static final String updateSQL = "UPDATE sendero SET nombre=? id_sede=?, anio_fundacion=?, id_zona=? where id_sendero=?;";
	public static final String deleteSQL = "DELETE FROM sendero WHERE id_sendero=?;";
	
	
	public List<SenderoJB> selectAll(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		SenderoJB sendero = null;
		
		List<SenderoJB> senderos = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectAllSQL);
			
			while(result.next()) {
				int id_sendero = result.getInt("id_sendero");
				String nombre = result.getString("nombre");
				int id_sede = result.getInt("id_sede");
				Date year = result.getDate("anio_fundacion");
				int id_zona = result.getInt("id_zona");
				//boolean status = result.getBoolean("status");
				
				sendero = new SenderoJB(id_sendero,nombre,id_sede,year,id_zona);
				senderos.add(sendero);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return senderos;
	}

}
