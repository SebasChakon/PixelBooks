<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario" %>
<%@page import="Modelo.LibrosDAO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Add Book</title>
    </head>

    <body>
        <div class="container mt-4 col-lg-6">
            <h1 class="text-center">Add Book</h1>

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
                        No user logged in. Please login to add a book.
                    </div>
                <% 
                    } else {
                %>
                    <form action="Agregar" method="post">
                        <div class="card col-sm-10 mx-auto">
                            <div class="card-body">

                                <div class="form-group">
                                    <label for="Tittle_Book">Title:</label>
                                    <input type="text" name="Tittle_Book" class="form-control" required>
                                </div>

                                <div class="form-group mt-3">
                                    <label for="Name_Autor">Author's Name:</label>
                                    <input type="text" name="Name_Autor" class="form-control" required>
                                </div>

                                <div class="form-group mt-3">
                                    <label for="Last_Name_Autor">Author's Last Name:</label>
                                    <input type="text" name="Last_Name_Autor" class="form-control" required>
                                </div>

                                <div class="form-group mt-3">
                                    <label for="Lan_Book">Language:</label>
                                    <input type="text" name="Lan_Book" class="form-control">
                                </div>

                                <div class="form-group mt-3">
                                    <label for="Edit_Book">Editorial:</label>
                                    <input type="text" name="Edit_Book" class="form-control">
                                </div>

                                <div class="form-group mt-3">
                                    <label for="Link_Book">Link:</label>
                                    <input type="text" name="Link_Book" class="form-control">
                                </div>

                                <div class="text-center mt-4">
                                    <button type="submit" class="btn btn-primary w-100">Add</button>
                                </div>
                            </div>
                        </div>
                    </form>
                <% } %>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>