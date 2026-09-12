package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection conexion;

    private String url = "jdbc:h2:mem:bibliotecadb;DB_CLOSE_DELAY=-1";
    private String usuario = "sa";
    private String password = "";

    private ConexionBD() {
        try {
            Class.forName("org.h2.Driver");
            this.conexion = DriverManager.getConnection(url, usuario, password);
            crearTablas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    private void crearTablas() {
        try (Statement stmt = conexion.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS usuario (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY, " +
                         "nombre VARCHAR(100), " +
                         "email VARCHAR(100), " +
                         "password VARCHAR(100), " +
                         "rol VARCHAR(20))");

            stmt.execute("CREATE TABLE IF NOT EXISTS libro (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY, " +
                         "titulo VARCHAR(100), " +
                         "autor VARCHAR(100), " +
                         "disponible BOOLEAN)");

            stmt.execute("CREATE TABLE IF NOT EXISTS prestamo (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY, " +
                         "id_libro INT, " +
                         "titulo_libro VARCHAR(100), " +
                         "usuario VARCHAR(100), " +
                         "fecha VARCHAR(20), " +
                         "estado VARCHAR(20))");

            var rs = stmt.executeQuery("SELECT COUNT(*) FROM usuario");
            if (rs.next() && rs.getInt(1) == 0) {
                stmt.execute("INSERT INTO usuario (nombre, email, password, rol) VALUES ('admin', 'admin@untec.cl', '1234', 'ADMIN')");
                stmt.execute("INSERT INTO usuario (nombre, email, password, rol) VALUES ('juan', 'juan@untec.cl', '1234', 'ESTUDIANTE')");

                stmt.execute("INSERT INTO libro (titulo, autor, disponible) VALUES ('Don Quijote de la Mancha', 'Miguel de Cervantes', true)");
                stmt.execute("INSERT INTO libro (titulo, autor, disponible) VALUES ('Cien Años de Soledad', 'Gabriel García Márquez', true)");
                stmt.execute("INSERT INTO libro (titulo, autor, disponible) VALUES ('El Principito', 'Antoine de Saint-Exupéry', true)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
  