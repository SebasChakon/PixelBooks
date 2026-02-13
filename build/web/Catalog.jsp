<%@ page import="java.util.List" %>
<%@ page import="Modelo.Usuario" %>
<%@ page import="Modelo.Libros" %>
<%@ page import="Modelo.LibrosDAO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Catalog</title>
    </head>

    <body>
        <div class="container mt-4">
            <h1 class="text-center">Catalog</h1>

            <div class="row mt-3 mb-4">
                <div class="col-md-6 offset-md-3">
                    <input type="text" id="searchBar" class="form-control" placeholder="Search for a book by title..." onkeyup="filterBooks()">
                </div>
            </div>

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
                        No user logged in. Please login to access the catalog.
                    </div>
                <%
                    } else {
                        LibrosDAO libroDAO = new LibrosDAO();
                        List<Libros> listaLibros = libroDAO.listarLibros();
                        int size = listaLibros.size();
                        long codUser = usuario.getCod_User();
                %>

                    <% for (int i = 0; i < size; i++) {
                        Libros libro = listaLibros.get(i);
                    %>
                    <div class="col-lg-4 col-md-6 mb-4 book-card">
                        <div class="card h-100">
                            <div class="card-body">
                                <h5 class="card-title book-title"><%= libro.getTittle_Book() %></h5>
                                <p class="card-text"><strong>Author:</strong> <%= libro.getName_Autor() %> <%= libro.getLast_Name_Autor() %></p>
                                <p class="card-text"><strong>Language:</strong> <%= libro.getLan_Book() %></p>
                                <p class="card-text"><strong>Publisher:</strong> <%= libro.getEdit_Book() %></p>
                                <div class="d-flex justify-content-center">
                                    <a href="<%= libro.getLink_Book() %>" target="_blank" class="btn btn-primary w-100">Download</a>
                                </div>

                                <form action="Guardar" method="POST" class="mt-2 d-flex justify-content-center">
                                    <input type="hidden" name="codUser" value="<%= codUser %>">
                                    <input type="hidden" name="idBook" value="<%= libro.getId_Book() %>">
                                    <button type="submit" class="btn btn-success d-flex justify-content-center w-100">Save</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <% } %>
                <% } %>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="filterBooks.js"></script>
    </body>
</html>