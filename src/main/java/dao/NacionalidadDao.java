package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Nacionalidad;

public class NacionalidadDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public NacionalidadDao(Conexion conn) {
        this.conn = conn;
    }

    public List<Nacionalidad> obtenerTodos() {
        sql = "select\n"
                + "	nac.id_nacionalidad as id_nacionalidad,\n"
                + "    nac.nombre as nombre,\n"
                + "    pai.id_pais as id_pais,\n"
                + "    pai.nombre as nombre_pais\n"
                + "from\n"
                + "    nacionalidad nac\n"
                + "    join pais pai on nac.id_pais = pai.id_pais";
        List<Nacionalidad> Nacionalidades = new LinkedList<>();
        Nacionalidad nacionalidad = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nacionalidad = new Nacionalidad();
                nacionalidad.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                nacionalidad.setNombre(rs.getString("nombre"));
                nacionalidad.setIdPais(rs.getInt("id_pais"));
                nacionalidad.setNombrePais(rs.getString("nombre_pais"));
                Nacionalidades.add(nacionalidad);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Nacionalidades;
    }

    public Nacionalidad obtenerUno(int idNacionalidad) {
        sql = "select\n"
                + "	nac.id_nacionalidad as id_nacionalidad,\n"
                + "    nac.nombre as nombre,\n"
                + "    pai.id_pais as id_pais,\n"
                + "    pai.nombre as nombre_pais\n"
                + "from\n"
                + "	nacionalidad nac\n"
                + "    join pais pai on nac.id_pais = pai.id_pais\n"
                + "\n"
                + "where id_nacionalidad = ?";
        Nacionalidad nacionalidad = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idNacionalidad);
            rs = ps.executeQuery();
            while (rs.next()) {
                nacionalidad = new Nacionalidad();
                nacionalidad.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                nacionalidad.setNombre(rs.getString("nombre"));
                nacionalidad.setIdPais(rs.getInt("id_pais"));
                nacionalidad.setNombrePais(rs.getString("nombre_pais"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nacionalidad;
    }

    public boolean insertar(Nacionalidad nacionalidad) {
        sql = "insert into nacionalidad(nombre, id_pais) values(?, ?)";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, nacionalidad.getNombre());
            ps.setInt(2, nacionalidad.getIdPais());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    public boolean actualizar(Nacionalidad nacionalidad) {
        sql = "update nacionalidad set nombre = ?, id_pais = ? where id_nacionalidad = ?";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, nacionalidad.getNombre());
            ps.setInt(2, nacionalidad.getIdPais());
            ps.setInt(3, nacionalidad.getIdNacionalidad());
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    public boolean eliminar(int idNacionalidad) {
        sql = "select from nacionalidad where id_nacionalidad = ?";
        boolean res = false;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, idNacionalidad);
            ps.executeUpdate();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

}
