
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Fase;


public class FaseDao {
    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public FaseDao(Conexion conn) {
        this.conn = conn;
    }

    
    public List<Fase> obtenerTodos(){
        sql = "select * from fase";
        
        List<Fase> fases = new LinkedList<>();
        Fase fase;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                fase = new Fase();
                fase.setIdFase(rs.getInt("id_fase"));
                fase.setNombre(rs.getString("nombre"));
                fases.add(fase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fases;
    }
}
