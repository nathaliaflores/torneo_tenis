package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.ArbitroTorneo;

public class ArbitroTorneoDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public ArbitroTorneoDao(Conexion conn) {
        this.conn = conn;
    }

    public List<ArbitroTorneo> obtenerTodos() {
        sql = "select\n"
                + "	art.id_arbitro_torneo as id_arbitro_torneo,\n"
                + "    arb.id_arbitro as id_arbitro,\n"
                + "    arb.nombre as nombre_arbitro,\n"
                + "    tor.id_torneo as id_torneo,\n"
                + "    tor.nombre as nombre_torneo\n"
                + "from\n"
                + "	arbitro_torneo art\n"
                + "    join arbitro arb on art.id_arbitro = arb.id_arbitro\n"
                + "    join torneo tor on art.id_torneo = tor.id_torneo";
        List<ArbitroTorneo> arbitroTorneos = new LinkedList<>();
        ArbitroTorneo arbitroTorneo = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                arbitroTorneo = new ArbitroTorneo();
                arbitroTorneo.setIdArbitroTorneo(rs.getInt("id_arbitro_torneo"));
                arbitroTorneo.setIdArbitro(rs.getInt("id_arbitro"));
                arbitroTorneo.setNombreArbitro(rs.getString("nombre_arbitro"));
                arbitroTorneo.setIdTorneo(rs.getInt("id_torneo"));
                arbitroTorneo.setNombreTorneo(rs.getString("nombre_torneo"));
                arbitroTorneos.add(arbitroTorneo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arbitroTorneos;
    }

    public ArbitroTorneo obtenerUno(int idArbitroTorneo) {
        sql = "select\n"
                + "	art.id_arbitro_torneo as id_arbitro_torneo,\n"
                + "    arb.id_arbitro as id_arbitro,\n"
                + "    arb.nombre as nombre_arbitro,\n"
                + "    tor.id_torneo as id_torneo,\n"
                + "    tor.nombre as nombre_torneo\n"
                + "from\n"
                + "	arbitro_torneo art\n"
                + "    join arbitro arb on art.id_arbitro = arb.id_arbitro\n"
                + "    join torneo tor on art.id_torneo = tor.id_torneo\n"
                + "where id_arbitro_torneo = ?";
        List<ArbitroTorneo> arbitroTorneos = new LinkedList<>();
        ArbitroTorneo arbitroTorneo = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idArbitroTorneo);
            rs = ps.executeQuery();
            while (rs.next()) {
                arbitroTorneo = new ArbitroTorneo();
                arbitroTorneo.setIdArbitroTorneo(rs.getInt("id_arbitro_torneo"));
                arbitroTorneo.setIdArbitro(rs.getInt("id_arbitro"));
                arbitroTorneo.setNombreArbitro(rs.getString("nombre_arbitro"));
                arbitroTorneo.setIdTorneo(rs.getInt("id_torneo"));
                arbitroTorneo.setNombreTorneo(rs.getString("nombre_torneo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arbitroTorneo;
    }
    
     public boolean insertar(ArbitroTorneo arbitroTorneo) {
        sql = "insert into arbitro_torneo(id_arbitro, id_torneo) values(?, ?)";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, arbitroTorneo.getIdArbitro());
            ps.setInt(2, arbitroTorneo.getIdTorneo());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
     
    public boolean actualizar(ArbitroTorneo arbitroTorneo) {
        sql = "update arbitro_torneo set id_arbitro = ?, id_torneo = ? where id_arbitro_torneo = ?";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, arbitroTorneo.getIdArbitro());
            ps.setInt(2, arbitroTorneo.getIdTorneo());
            ps.setInt(3, arbitroTorneo.getIdArbitroTorneo());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public boolean eliminar(int idArbitroTorneo) {
        sql = "delete from arbitro_torneo where id_arbitro_torneo = ?";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idArbitroTorneo);
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
