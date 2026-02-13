package Controlador;

import Modelo.Libros;
import Modelo.LibrosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarLibro extends HttpServlet implements Servlets {

    private LibrosDAO librosDAO = new LibrosDAO();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("buscar".equals(action)) {
            int idLibro = Integer.parseInt(request.getParameter("idLibro"));
            Libros libro = librosDAO.obtenerLibroPorId(idLibro);

            if (libro != null) {
                request.setAttribute("libro", libro);
            } else {
                request.setAttribute("alertMessage", "Book not found.");
            }
            request.getRequestDispatcher("Modificarlibro.jsp").forward(request, response);
        } else if ("modificar".equals(action)) {
            int idLibro = Integer.parseInt(request.getParameter("idLibro"));
            String titulo = request.getParameter("titulo");
            String idioma = request.getParameter("idioma");
            String editorial = request.getParameter("editorial");
            String link = request.getParameter("link");

            Libros libro = new Libros(idLibro, titulo, null, null, idioma, editorial, link);
            boolean isUpdated = librosDAO.modificarLibro(libro);

            if (isUpdated) {
                request.setAttribute("successMessage", "The book has been successfully updated.");
            } else {
                request.setAttribute("alertMessage", "There was an error updating the book.");
            }
            request.getRequestDispatcher("Modificarlibro.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


