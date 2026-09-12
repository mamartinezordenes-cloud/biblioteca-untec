package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.LibroDAO;
import model.Libro;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private LibroDAO libroDAO = new LibroDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Libro> lista = libroDAO.obtenerTodos();
        request.setAttribute("libros", lista);
        request.getRequestDispatcher("libros.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");

        if (titulo != null && !titulo.trim().isEmpty() && autor != null && !autor.trim().isEmpty()) {
            Libro nuevoLibro = new Libro();
            nuevoLibro.setTitulo(titulo);
            nuevoLibro.setAutor(autor);
            nuevoLibro.setDisponible(true);
            
            libroDAO.agregarLibro(nuevoLibro);
        }

        response.sendRedirect("LibroServlet");
    }
}
