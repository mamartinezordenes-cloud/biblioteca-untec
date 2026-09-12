package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Prestamo;

public class PrestamoDAO {

    public List<Prestamo> obtenerTodos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";

        try {
            Connection con = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setId(rs.getInt("id"));
                p.setIdLibro(rs.getInt("id_libro"));
                p.setTituloLibro(rs.getString("titulo_libro"));
                p.setUsuario(rs.getString("usuario"));
                p.setFechaPrestamo(rs.getString("fecha"));
                p.setEstado(rs.getString("estado"));
                prestamos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prestamos;
    }

    public void registrarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (id_libro, titulo_libro, usuario, fecha, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, prestamo.getIdLibro());
            ps.setString(2, prestamo.getTituloLibro());
            ps.setString(3, prestamo.getUsuario());
            ps.setString(4, prestamo.getFechaPrestamo());
            ps.setString(5, "ACTIVO");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}