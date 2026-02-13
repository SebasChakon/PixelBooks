package Controlador;

import Modelo.LibrosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Agregar extends HttpServlet implements Servlets {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("Tittle_Book");
        String nombreAutor = request.getParameter("Name_Autor");
        String apellidoAutor = request.getParameter("Last_Name_Autor");
        String idioma = request.getParameter("Lan_Book");
        String editorial = request.getParameter("Edit_Book");
        String link = request.getParameter("Link_Book");

        LibrosDAO librosDAO = new LibrosDAO();
        
        boolean isSuccess = librosDAO.agregarLibro(titulo, nombreAutor, apellidoAutor, idioma, editorial, link);

        if (isSuccess) {
            request.setAttribute("successMessage", "The book has been successfully added.");
        } else {
            request.setAttribute("alertMessage", "The book could not be added.");
        }
        request.getRequestDispatcher("Agregarlibro.jsp").forward(request, response);
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


