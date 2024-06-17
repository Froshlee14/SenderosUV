package datos;

import java.sql.*;

public class Conexion {
    //private static String user = "postgres";
    //private static String pswd = "1234";
    //private static String bd = "SenderosUV";
    //private static String server = "jdbc:postgresql://localhost:5432/" + bd;
    //private static String driver = "org.postgresql.Driver";
    
    private static String user = "root";
    private static String pswd = "1234";
    private static String bd = "senderosUV";
    private static String server = "jdbc:mysql://localhost:3306/" + bd;
    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
    	
    	String server_url = System.getProperty("JDBC_SERVER_URL");
    	if (server == null) server_url = server;
    	
    	String server_username = System.getProperty("JDBC_USERNAME");
    	if (server_username == null) server_username = user;
    	
    	String server_password = System.getProperty("JDBC_PASSWORD");
    	if (server == null) server_password = pswd;

        try {
            Class.forName(driver);
            System.out.println("conexion establecida");
            return DriverManager.getConnection(server_url, server_username, server_password);
        } catch (SQLException ex) {
            System.out.println("Error al intentar conectarse a la BD " + server);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    }


    public static void close(ResultSet result){
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Statement state){
        try {
            state.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

