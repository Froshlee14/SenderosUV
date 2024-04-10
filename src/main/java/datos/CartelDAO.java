package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.CartelJB;

public class CartelDAO {

	public static final String selectSQL = "SELECT * from cartel where id_cartel=?;";
	public static final String selectPorEstacionSQL = "SELECT cartel.id_cartel, cartel.descripcion "
			+ "FROM  cartel JOIN estacion_cartel ON cartel.id_cartel = estacion_cartel.id_cartel"
			+ "JOIN estacion ON estacion_cartel.id_estacion = estacion.id_estacion where id_estacion = ?;";
	public static final String insertSQL = "INSERT INTO cartel (descripcion) VALUES (?);";
	public static final String updateSQL = "UPDATE cartel SET  descripcion=? where id_estacion=?;";
	public static final String deleteSQL = "DELETE FROM cartel WHERE id_cartel=?;";
	
	public CartelJB select(int id_cartel){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        CartelJB cartel = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,id_cartel);
            
			result = state.executeQuery();
			
			while(result.next()) {
				String descripcion = result.getString("descripcion");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				cartel = new CartelJB(id_cartel, descripcion);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cartel;
	}
	
	public List<CartelJB>  selectPorEstacion(int id_estacion){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        CartelJB cartel = null;
		
		List<CartelJB> carteles = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectPorEstacionSQL);
            
            state.setInt(1,id_estacion);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int id_cartel = result.getInt("id_cartel");
				String descripcion = result.getString("descripcion");
				//boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				cartel = new CartelJB(id_cartel,descripcion);
				carteles.add(cartel);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return carteles;
	}
	
	public int insert(CartelJB cartel) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,cartel.get_descripcion());
			
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
	
	public int update(CartelJB cartel) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,cartel.get_descripcion());
			state.setInt(2,cartel.get_id_cartel());
			
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
