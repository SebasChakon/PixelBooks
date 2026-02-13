package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Modificar extends HttpServlet implements Servlets {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario user = new Usuario();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long codUser = Long.parseLong(request.getParameter("Cod_User"));
            String nombre = request.getParameter("Name_User");
            String apellido = request.getParameter("Apellido_User");
            String nomUser = request.getParameter("Nom_User");
            String passUser = request.getParameter("Pass_User");

            // OBTENER LA FOTO QUE YA TIENE POR SI LE DA AL BOTÓN Y NO LA MODIFICÓ
            
            Part filePart = request.getPart("Profile_Pic");
            Usuario usuarioActual = usuarioDAO.obtenerUsuario(codUser);
            String imagePath = usuarioActual.getFoto_User();

            if (filePart != null && filePart.getSize() > 0) {
                String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) uploadDir.mkdir();
                String fileName = "profile_" + codUser + "_" + filePart.getSubmittedFileName();
                imagePath = "img/" + fileName;
                filePart.write(uploadPath + File.separator + fileName);
            }

            Usuario usuario = new Usuario(codUser, nombre, apellido, nomUser, passUser, 0, imagePath);
            int resultado = usuarioDAO.actualizarUsuario(usuario);

            if (resultado > 0) {
                request.getSession().setAttribute("usuario", usuario);
                request.setAttribute("successMessage", "Profile successfully modified (Refresh PixelBooks to check).");
            } else {
                throw new Exception("Error updating profile.");
            }
            request.getRequestDispatcher("Profile.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error during profile update: " + e.getMessage());
            request.getRequestDispatcher("Profile.jsp").forward(request, response);
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
