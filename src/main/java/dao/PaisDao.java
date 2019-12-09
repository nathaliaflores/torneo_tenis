
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Pais;


public class PaisDao {
    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public PaisDao(Conexion conn) {
        this.conn = conn;
    }
    
    
    
    public List<Pais> obtenerTodos(){
        sql = "select * from pais";
        
        List<Pais> paises = new LinkedList<>();
        Pais pais;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pais = new Pais();
                pais.setIdPais(rs.getInt("id_pais"));
                pais.setNombre(rs.getString("nombre"));
                paises.add(pais);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paises;
    }
    
    public Pais obtenerUno(int idPais){
        sql = "select * from pais where id_pais = ?";
        
        Pais pais = null;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idPais);
            rs = ps.executeQuery();
            while(rs.next()){
                pais = new Pais();
                pais.setIdPais(rs.getInt("id_pais"));
                pais.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pais;
    }
    
    public boolean insertar(Pais pais){
        sql = "insert into pais(nombre) values(?)";
         boolean res = false;
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.executeUpdate();
            res =  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public boolean actualizar(Pais pais){
        sql = "update pais set nombre = ? where id_pais = ?";
        boolean res = false;
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, pais.getNombre());
            ps.setInt(2, pais.getIdPais());
            ps.executeUpdate();
            res = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public boolean eliminar(int idPais){
        sql = "select from pais where id_pais = ?";
        boolean res = false;
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idPais);
            ps.executeUpdate();
            res = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
