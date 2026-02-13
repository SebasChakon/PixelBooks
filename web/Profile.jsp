<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario" %>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Modify Profile</title>
    </head>
    
    <body>
        <div class="container mt-4 col-lg-6">
            <h1 class="text-center">Modify Profile</h1>
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                String successMessage = (String) request.getAttribute("successMessage");
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (successMessage != null) {
            %>
                <div class="alert alert-success" role="alert">
                    <%= successMessage %>
                </div>
            <% 
                } else if (errorMessage != null) {
            %>
                <div class="alert alert-danger" role="alert">
                    <%= errorMessage %>
                </div>
            <% 
                }
                if (usuario != null) {
            %>
            <div class="card col-sm-10 mx-auto">
                <div class="card-body">
                    <form action="Modificar" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="accion" value="modificar">
                        <input type="hidden" name="Cod_User" value="<%= usuario.getCod_User() %>">

                        <div class="text-center mb-4">
                            <img src="<%= usuario.getFoto_User() %>" alt="User Profile Picture" width="200" height="200" class="rounded-circle">
                        </div>

                        <div class="form-group mt-3">
                            <label for="Profile_Pic">Change Profile Picture:</label>
                            <input type="file" name="Profile_Pic" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="Name_User">Name:</label>
                            <input type="text" name="Name_User" class="form-control" value="<%= usuario.getName_User() %>">
                        </div>

                        <div class="form-group mt-3">
                            <label for="Apellido_User">Last name:</label>
                            <input type="text" name="Apellido_User" class="form-control" value="<%= usuario.getApellido_User() %>">
                        </div>

                        <div class="form-group mt-3">
                            <label for="Nom_User">Username:</label>
                            <input type="text" name="Nom_User" class="form-control" value="<%= usuario.getNick_Name() %>">
                        </div>

                        <div class="form-group mt-3">
                            <label for="Pass_User">Password:</label>
                            <input type="password" name="Pass_User" class="form-control" value="<%= usuario.getPass_User() %>">
                        </div>

                        <div class="text-center mt-4">
                            <input type="submit" value="Update" class="btn btn-primary w-100">
                        </div>
                    </form>
                </div>
        </div>
        <% } else { %>
            <div class="alert alert-danger" role="alert">
                No user logged in. Please login to access your profile.
            </div>
        <% } %>
    </div>
</body>
</html>

