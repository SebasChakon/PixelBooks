<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="Modelo.Usuario" %>
<%@ page import="Modelo.Libros" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Modify Book</title>
    </head>

    <body>
        <div class="container mt-4">
            <h1 class="text-center">Modify Book</h1>

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
            </div>

            <div class="row mt-4">
                <% 
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    if (usuario == null) {
                %>
                    <div class="alert alert-danger" role="alert">
                        No user logged in. Please login to modify a book.
                    </div>
                <% 
                    } else {
                %>
                    <div>
                        <form action="ModificarLibro" method="post" class="col-lg-6 mx-auto">
                            <input type="hidden" name="action" value="buscar">
                            
                            <div class="mb-3">
                                <label for="idLibro" class="form-label">Book ID:</label>
                                <input type="number" class="form-control" id="idLibro" name="idLibro" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary w-100">Search</button>
                            </div>
                        </form>
                    </div>

                    <div class="row mt-4">
                        <% 
                            Libros libro = (Libros) request.getAttribute("libro");
                            if (libro != null) {
                        %>

                        <div class="card col-sm-6 mx-auto">
                            <form action="ModificarLibro" method="post" class="col-lg-12 mx-auto">
                                <input type="hidden" name="action" value="modificar">
                                <input type="hidden" name="idLibro" value="<%= libro.getId_Book() %>">
                                
                                <div class="mb-3">
                                    <label for="titulo" class="form-label">Book Title:</label>
                                    <input type="text" class="form-control" id="titulo" name="titulo" value="<%= libro.getTittle_Book() %>" required>
                                </div>
                                <div class="mb-3">
                                    <label for="idioma" class="form-label">Language:</label>
                                    <input type="text" class="form-control" id="idioma" name="idioma" value="<%= libro.getLan_Book() %>" required>
                                </div>
                                <div class="mb-3">
                                    <label for="editorial" class="form-label">Publisher:</label>
                                    <input type="text" class="form-control" id="editorial" name="editorial" value="<%= libro.getEdit_Book() %>" required>
                                </div>
                                <div class="mb-3">
                                    <label for="link" class="form-label">Link:</label>
                                    <input type="text" class="form-control" id="link" name="link" value="<%= libro.getLink_Book() %>">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary w-100">Update</button>
                                </div>
                            </form>
                        </div>
                        <% } %>
                    </div>
                <% } %>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>