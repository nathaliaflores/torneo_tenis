package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.TorneoModalidadFase;

public class TorneoModalidadFaseDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public TorneoModalidadFaseDao(Conexion conn) {
        this.conn = conn;
    }

    public List<TorneoModalidadFase> obtenerTodos() {
        sql = "select\n"
                + "	tmf.id_tmf as id_tmf,\n"
                + "    tmf.premio_consuelo as premio_consuelo,\n"
                + "    tor.id_torneo as id_torneo,\n"
                + "    tor.nombre as nombre_torneo,\n"
                + "    mo.id_modalidad as id_modalidad,\n"
                + "    mo.nombre as nombre_modalidad,\n"
                + "    fa.id_fase as id_fase,\n"
                + "    fa.nombre nombre_fase\n"
                + "from\n"
                + "	torneo_modalidad_fase tmf\n"
                + "    join torneo tor on tmf.id_torneo = tor.id_torneo\n"
                + "    join modalidad mo on tmf.id_modalidad = mo.id_modalidad\n"
                + "    join fase fa on tmf.id_fase = fa.id_fase";
        List<TorneoModalidadFase> tmfs = new LinkedList<>();
        TorneoModalidadFase tmf = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tmf = new TorneoModalidadFase();
                tmf.setIdTmf(rs.getInt("id_tmf"));
                tmf.setPremioConsuelo(rs.getInt("premio_consuelo"));
                tmf.setIdTorneo(rs.getInt("id_torneo"));
                tmf.setIdModalidad(rs.getInt("id_modalidad"));
                tmf.setIdFase(rs.getInt("id_fase"));
                tmf.setNombreTorneo(rs.getString("nombre_torneo"));
                tmf.setNombreModalidad(rs.getString("nombre_modalidad"));
                tmf.setNombreFase(rs.getString("nombre_fase"));
                tmfs.add(tmf);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmfs;
    }

    public TorneoModalidadFase obtenerUno(int idTmf) {
        sql = "select\n"
                + "	tmf.id_tmf as id_tmf,\n"
                + "    tmf.premio_consuelo as premio_consuelo,\n"
                + "    tor.id_torneo as id_torneo,\n"
                + "    tor.nombre as nombre_torneo,\n"
                + "    mo.id_modalidad as id_modalidad,\n"
                + "    mo.nombre as nombre_modalidad,\n"
                + "    fa.id_fase as id_fase,\n"
                + "    fa.nombre nombre_fase\n"
                + "from\n"
                + "	torneo_modalidad_fase tmf\n"
                + "    join torneo tor on tmf.id_torneo = tor.id_torneo\n"
                + "    join modalidad mo on tmf.id_modalidad = mo.id_modalidad\n"
                + "    join fase fa on tmf.id_fase = fa.id_fase \n"
                + "where id_tmf = ?";
        List<TorneoModalidadFase> tmfs = new LinkedList<>();
        TorneoModalidadFase tmf = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idTmf);
            rs = ps.executeQuery();
            while (rs.next()) {
                tmf = new TorneoModalidadFase();
                tmf.setIdTmf(rs.getInt("id_tmf"));
                tmf.setPremioConsuelo(rs.getInt("premio_consuelo"));
                tmf.setIdTorneo(rs.getInt("id_torneo"));
                tmf.setIdModalidad(rs.getInt("id_modalidad"));
                tmf.setIdFase(rs.getInt("id_fase"));
                tmf.setNombreTorneo(rs.getString("nombre_torneo"));
                tmf.setNombreModalidad(rs.getString("nombre_modalidad"));
                tmf.setNombreFase(rs.getString("nombre_fase"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmf;
    }
    
    public boolean insertar(TorneoModalidadFase tmf){
        sql = "insert into torneo_modalidad_fase(id_torneo, id_modalidad, id_fase, premio_consuelo) values(?,?,?,?)";
        boolean res = false;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, tmf.getIdTorneo());
            ps.setInt(2, tmf.getIdModalidad());
            ps.setInt(3, tmf.getIdFase());
            ps.setDouble(4, tmf.getPremioConsuelo());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        
    } 
    
    public boolean actualizar(TorneoModalidadFase tmf){
        sql = "update torneo_modalidad_fase set premio_consuelo = ?, id_torneo = ?, id_modalidad= ?, id_fase = ? where id_tmf = ? ";
        boolean res = false;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, tmf.getIdTorneo());
            ps.setInt(2, tmf.getIdModalidad());
            ps.setInt(3, tmf.getIdFase());
            ps.setDouble(4, tmf.getPremioConsuelo());
            ps.setInt(5, tmf.getIdTmf());
            
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        
    }
    
    public boolean eliminar(int idTmf){
        sql = "delete from torneo_modalidad_fase where id_tmf = ?";
        boolean res = false;
        
        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idTmf);
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
        
    }

}
