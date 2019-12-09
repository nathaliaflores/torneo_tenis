package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Torneo;

public class TorneoDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public TorneoDao(Conexion conn) {
        this.conn = conn;
    }

    public List<Torneo> obtenerTodos() {
        sql = "select \n"
                + "	tor.id_torneo as id_torneo,\n"
                + "    tor.nombre as nombre,\n"
                + "    tor.anio as anio,\n"
                + "    tor.premio as premio,\n"
                + "    lg.id_lugar_torneo as id_lugar_torneo,\n"
                + "    lg.nombre as nombre_lugar_torneo\n"
                + "    \n"
                + "from \n"
                + "	torneo tor\n"
                + "    join lugar_torneo lg on tor.id_lugar_torneo = lg.id_lugar_torneo";
        List<Torneo> torneos = new LinkedList<>();
        Torneo torneo = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                torneo = new Torneo();
                torneo.setIdTorneo(rs.getInt("id_torneo"));
                torneo.setNombre(rs.getString("nombre"));
                torneo.setAnio(rs.getString("anio"));
                torneo.setPremio(rs.getDouble("premio"));
                torneo.setIdLugarTorneo(rs.getInt("id_lugar_torneo"));
                torneo.setNombreLugarTorneo(rs.getString("nombre_lugar_torneo"));
                torneos.add(torneo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return torneos;
    }

    public Torneo obtenerUno(int idTorneo) {
        sql = "select \n"
                + "     tor.id_torneo as id_torneo,\n"
                + "     tor.nombre as nombre,\n"
                + "     tor.anio as anio,\n"
                + "     tor.premio as premio,\n"
                + "     lg.id_lugar_torneo as id_lugar_torneo,\n"
                + "     lg.nombre as nombre_lugar_torneo\n"
                + "			\n"
                + "from \n"
                + "     torneo tor\n"
                + "     join lugar_torneo lg on tor.id_lugar_torneo = lg.id_lugar_torneo\n"
                + " where id_torneo = ?";
        Torneo torneo = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idTorneo);
            rs = ps.executeQuery();
            while (rs.next()) {
                torneo = new Torneo();
                torneo.setIdTorneo(rs.getInt("id_torneo"));
                torneo.setNombre(rs.getString("nombre"));
                torneo.setAnio(rs.getString("anio"));
                torneo.setPremio(rs.getDouble("premio"));
                torneo.setIdLugarTorneo(rs.getInt("id_lugar_torneo"));
                torneo.setNombreLugarTorneo(rs.getString("nombre_lugar_torneo"));        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return torneo;
    }

    public boolean insertar(Torneo torneo) {
        sql = "insert into torneo(nombre, anio, premio, id_lugar_torneo) values(?, ?, ?, ?)";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, torneo.getNombre());
            ps.setString(2, torneo.getAnio());
            ps.setDouble(3, torneo.getPremio());
            ps.setInt(4, torneo.getIdLugarTorneo());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean actualizar(Torneo torneo) {
        sql = "update torneo set nombre = ?, anio = ?, premio = ?, id_lugar_torneo = ? where id_torneo = ? ";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, torneo.getNombre());
            ps.setString(2, torneo.getAnio());
            ps.setDouble(3, torneo.getPremio());
            ps.setInt(4, torneo.getIdLugarTorneo());
            ps.setInt(5, torneo.getIdTorneo());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean eliminar(int idTorneo) {
        sql = "delete from torneo where id_torneo = ? ";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idTorneo);
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
