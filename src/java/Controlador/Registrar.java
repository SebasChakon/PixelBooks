package Controlador;

import Modelo.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registrar extends HttpServlet implements Servlets {

    UsuarioDAO udao = new UsuarioDAO();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Log In")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (accion.equalsIgnoreCase("Register")) {
            try {
                String user = request.getParameter("txtuser");
                String name = request.getParameter("txtname");
                String lastname = request.getParameter("txtlastname");
                String pass = request.getParameter("txtpass");
                String codeString = request.getParameter("txtcode");
                long code = Long.parseLong(codeString);

                int registrar = udao.registrar(code, name, lastname, user, pass, 2); 

                if (registrar == 1) {
                    request.setAttribute("successMessage", "Registration successful. Welcome, " + name + "!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Error registering user. Please try again.");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Error registering user: " + e.getMessage());
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
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
