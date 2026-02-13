package Controlador;

import Modelo.MislibrosDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;

public class Eliminar extends HttpServlet implements Servlets {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long codUser = Long.parseLong(request.getParameter("codUser"));
        int idBook = Integer.parseInt(request.getParameter("idBook"));

        MislibrosDAO mislibrosDAO = new MislibrosDAO();
        boolean resultado = mislibrosDAO.eliminarLibroGuardado(codUser, idBook);

        if (resultado) {
            request.setAttribute("successMessage", "Book removed successfully.");
        } else {
            request.setAttribute("alertMessage", "Failed to remove the book.");
        }

        request.getRequestDispatcher("Mybooks.jsp").forward(request, response);
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

