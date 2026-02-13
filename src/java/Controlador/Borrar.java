package Controlador;

import Modelo.LibrosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Borrar extends HttpServlet implements Servlets {
    private LibrosDAO librosDAO = new LibrosDAO();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));

        boolean isSuccess = librosDAO.eliminarLibro(idLibro);

        if (isSuccess) {
            request.setAttribute("successMessage", "The book has been successfully deleted.");
        } else {
            request.setAttribute("alertMessage", "The book could not be deleted.");
        }
        request.getRequestDispatcher("Eliminarlibro.jsp").forward(request, response);
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

