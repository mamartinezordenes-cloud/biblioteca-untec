package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dao.LibroDAO;
import dao.PrestamoDAO;
import model.Prestamo;

@WebServlet("/PrestamoServlet")
public class PrestamoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private PrestamoDAO prestamoDAO = new PrestamoDAO();
    private LibroDAO libroDAO = new LibroDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Prestamo> lista = prestamoDAO.obtenerTodos();
        request.setAttribute("prestamos", lista);
        request.getRequestDispatcher("prestamos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));
        String tituloLibro = request.getParameter("tituloLibro");
        String usuario = request.getParameter("usuario");
        String fecha = LocalDate.now().toString();

        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setIdLibro(idLibro);
        nuevoPrestamo.setTituloLibro(tituloLibro);
        nuevoPrestamo.setUsuario(usuario);
        nuevoPrestamo.setFechaPrestamo(fecha);
        nuevoPrestamo.setEstado("ACTIVO");

        prestamoDAO.registrarPrestamo(nuevoPrestamo);
        libroDAO.actualizarEstado(idLibro, false);

        response.sendRedirect("PrestamoServlet");
    }
}