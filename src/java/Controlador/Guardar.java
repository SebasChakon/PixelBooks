package Controlador;

import Modelo.GuardarDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Guardar extends HttpServlet implements Servlets {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long codUser = Long.parseLong(request.getParameter("codUser"));
        int idBook = Integer.parseInt(request.getParameter("idBook"));

        GuardarDAO guardarDAO = new GuardarDAO();
        boolean isSuccess = guardarDAO.guardarLibro(codUser, idBook);

        if (isSuccess) {
            request.setAttribute("successMessage", "The book has been saved successfully!");
        } else {
            request.setAttribute("alertMessage", "This book is already saved in your library.");
        }
        request.getRequestDispatcher("Catalog.jsp").forward(request, response);
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
