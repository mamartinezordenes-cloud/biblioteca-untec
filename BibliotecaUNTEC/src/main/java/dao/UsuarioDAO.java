package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;

public class UsuarioDAO {

    public Usuario validarLogin(String nombre, String password) {
        Usuario user = null;
        String sql = "SELECT * FROM usuario WHERE LOWER(nombre) = LOWER(?) AND password = ?";

        try {
            // Se fuerza la inicialización de la base de datos
            Connection con = ConexionBD.getInstancia().getConexion();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre.trim());
            ps.setString(2, password.trim());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
