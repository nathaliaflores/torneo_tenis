
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    static String bd = "torneo_tenis";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost/" + bd + "?useSSL=false";
    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if(conn != null){
                System.out.println("Exito de conexion");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de conexion" + e);
            
        }
    }
    
    public Connection conectar(){
        return conn;
    
    }
    
    public void desconectar() throws Exception{
        conn.close();
    }
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
    
    
}
