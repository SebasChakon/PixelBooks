<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="Modelo.Usuario" %>
<%@ page import="Modelo.LibrosDAO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Delete Book</title>
    </head>

    <body>
        <div class="container mt-4">
            <h1 class="text-center">Delete Book</h1>

            <div class="row mt-4">
                <% 
                    String successMessage = (String) request.getAttribute("successMessage");
                    String alertMessage = (String) request.getAttribute("alertMessage");

                    if (successMessage != null) { 
                %>
                    <div class="alert alert-success" role="alert">
                        <%= successMessage %>
                    </div>
                <% } else if (alertMessage != null) { %>
                    <div class="alert alert-warning" role="alert">
                        <%= alertMessage %>
                    </div>
                <% } %>

                <%
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    if (usuario == null) {
                %>
                    <div class="alert alert-danger" role="alert">
                        No user logged in. Please login to delete a book.
                    </div>
                <%
                    } else {
                %>
                    <div>
                        <form action="Borrar" method="post" class="col-lg-6 mx-auto">
                            <div class="mb-3">
                                <label for="idLibro" class="form-label">Book ID to Delete:</label>
                                <input type="number" class="form-control" id="idLibro" name="idLibro" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-danger w-100">Delete</button>
                            </div>
                        </form>
                    </div>
                <% } %>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>