package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Controlador para manejar las acciones principales y las del admin.
 */
public class Controlador extends HttpServlet implements Servlets {

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "Catalog":
                    request.getRequestDispatcher("Catalog.jsp").forward(request, response);
                    break;
                case "Mybooks":
                    request.getRequestDispatcher("Mybooks.jsp").forward(request, response);
                    break;
                case "Profile":
                    request.getRequestDispatcher("Profile.jsp").forward(request, response);
                    break;
                case "admin":
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                    break;
                case "Agregarlibro":
                    request.getRequestDispatcher("Agregarlibro.jsp").forward(request, response);
                    break;
                case "Modificarlibro":
                    request.getRequestDispatcher("Modificarlibro.jsp").forward(request, response);
                    break;
                case "Eliminarlibro":
                    request.getRequestDispatcher("Eliminarlibro.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
