package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Libro;

public class LibroDAO {

    public List<Libro> obtenerTodos() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try {
            Connection con = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setDisponible(rs.getBoolean("disponible"));
                libros.add(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }

    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libro (titulo, autor, disponible) VALUES (?, ?, ?)";
        try {
            Connection con = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setBoolean(3, true);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarEstado(int idLibro, boolean disponible) {
        String sql = "UPDATE libro SET disponible = ? WHERE id = ?";
        try {
            Connection con = ConexionBD.getInstancia().getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, disponible);
            ps.setInt(2, idLibro);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}