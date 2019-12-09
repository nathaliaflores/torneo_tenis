package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

public class UsuarioDao {

    Conexion conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public UsuarioDao(Conexion conn) {
        this.conn = conn;
    }

    public Usuario obtenerUsuario(String usuarioLogin, String passwordLogin) {
        sql = "select * from usuario where usuario = ? and password = ?";

        Usuario usuario = null;

        try {
            ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usuarioLogin);
            ps.setString(2, passwordLogin);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
