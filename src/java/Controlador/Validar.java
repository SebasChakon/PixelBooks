package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validar extends HttpServlet implements Servlets {

    UsuarioDAO udao = new UsuarioDAO();
    Usuario usu = new Usuario();

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("Log In")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            usu = udao.validar(user, pass);

            if (usu.getNick_Name() != null) {
                // Crear sesión
                request.getSession().setAttribute("usuario", usu);
                request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Error logging in");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (accion.equalsIgnoreCase("Sign Up")) {
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

