
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Modalidad;


public class ModalidadDao {
    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ModalidadDao(Conexion conn) {
        this.conn = conn;
    }

    
    public List<Modalidad> obtenerTodos(){
        sql = "select * from modalidad";
        
        List<Modalidad> modalidades = new LinkedList<>();
        Modalidad modalidad;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                modalidad = new Modalidad();
                modalidad.setIdModalidad(rs.getInt("id_modalidad"));
                modalidad.setNombre(rs.getString("nombre"));
                modalidades.add(modalidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modalidades;
    }
}
