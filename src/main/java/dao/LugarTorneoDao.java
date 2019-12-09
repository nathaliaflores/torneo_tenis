package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.LugarTorneo;

public class LugarTorneoDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public LugarTorneoDao(Conexion conn) {
        this.conn = conn;
    }

    public List<LugarTorneo> obtenerTodos() {
        sql = "select \n"
                + "	lg.id_lugar_torneo as id_lugar_torneo,\n"
                + "    lg.nombre as nombre,\n"
                + "    pai.id_pais as id_pais,\n"
                + "    pai.nombre as nombre_pais\n"
                + "    \n"
                + "from\n"
                + "	lugar_torneo lg\n"
                + "    join pais pai on lg.id_pais = pai.id_pais";
        List<LugarTorneo> lugarTorneos = new LinkedList<>();
        LugarTorneo lugarTorneo=null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lugarTorneo = new LugarTorneo();
                lugarTorneo.setIdLugarTorneo(rs.getInt("id_lugar_torneo"));
                lugarTorneo.setNombre(rs.getString("nombre"));
                lugarTorneo.setIdPais(rs.getInt("id_pais"));
                lugarTorneo.setNombrePais(rs.getString("nombre_pais"));
                lugarTorneos.add(lugarTorneo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lugarTorneos;
    }

    public LugarTorneo obtenerUno(int idLugarTorneo) {
        sql = "select \n"
                + "	lg.id_lugar_torneo as id_lugar_torneo,\n"
                + "    lg.nombre as nombre,\n"
                + "    pai.id_pais as id_pais,\n"
                + "    pai.nombre as nombre_pais\n"
                + "    \n"
                + "from\n"
                + "	lugar_torneo lg\n"
                + "    join pais pai on lg.id_pais = pai.id_pais\n"
                + "    \n"
                + "where \n"
                + "	id_lugar_torneo = ?\n";
        LugarTorneo lugarTorneo = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idLugarTorneo);
            rs = ps.executeQuery();
            while (rs.next()) {
                lugarTorneo = new LugarTorneo();
                lugarTorneo.setIdLugarTorneo(rs.getInt("id_lugar_torneo"));
                lugarTorneo.setNombre(rs.getString("nombre"));
                lugarTorneo.setIdPais(rs.getInt("id_pais"));
                lugarTorneo.setNombrePais(rs.getString("nombre_pais"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lugarTorneo;
    }
    
    public boolean insertar(LugarTorneo lugarTorneo){
        sql = "insert into lugar_torneo(nombre, id_pais) values(?, ?)";
        boolean res = false;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, lugarTorneo.getNombre());
            ps.setInt(2, lugarTorneo.getIdPais());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        
    } 
    
    public boolean actualizar(LugarTorneo lugarTorneo){
        sql = "update lugar_torneo set nombre = ?, id_pais = ? where id_lugar_torneo = ?";
        boolean res = false;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, lugarTorneo.getNombre());
            ps.setInt(2, lugarTorneo.getIdPais());
            ps.setInt(3, lugarTorneo.getIdLugarTorneo());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        
    }
    
    public boolean eliminar(int idLugarTorneo){
        sql = "delete from lugar_torneo where id_lugar_torneo = ?";
        boolean res = false;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idLugarTorneo);
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        
    }
  
}
