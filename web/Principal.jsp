<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario" %>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>PixelBooks</title>
    </head>
    <body>
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuario");
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            
            <div class="container-fluid">
                
                <img src="img/blanco png.png" alt="Logo" width="80"/>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light"  href="Controlador?accion=Catalog" target="myFrame">Catalog</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?accion=Mybooks" target="myFrame">My Books</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?accion=Principal">About Us</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?accion=Profile" target="myFrame">Profile</a>
                        </li>
                        
                        <% if (usuario != null && usuario.getId_Rol() == 1) { %>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?accion=Agregarlibro" target="myFrame">Add Book</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?accion=Eliminarlibro" target="myFrame">Delete Book</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?accion=Modificarlibro" target="myFrame">Modify book</a>
                            </li>
                        <% } %>
                    </ul>
                    
                    <div class="dropdown ms-lg-auto">
                        <button class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%= (usuario != null) ? usuario.getNick_Name() : "User" %>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end text-center">
                            <li><img src="<%= (usuario != null) ? usuario.getFoto_User() : "Photo" %>" alt="User Profile Picture" width="150" height="150" class="rounded-circle"></li>
                            <li><a class="dropdown-item" href="#">Profile information</a></li>
                            <li><a class="dropdown-item" href="#">Name: <%= usuario != null ? usuario.getName_User() : "" %> <%= usuario != null ? usuario.getApellido_User() : "" %></a></li>
                            <li><a class="dropdown-item" href="#">Code: <%= usuario != null ? usuario.getCod_User() : "" %></a></li>
                            <div class="dropdown-divider"></div>
                            <form action="Validar" method="POST">
                                <button name="accion" value="Salir" class="dropdown-item">Log Out</button>
                            </form>
                        </ul>
                    </div>
                            
                </div>
            </div>
        </nav>

        <div class="m-4" style="height: 550px;">
            <iframe name="myFrame" style="height: 100%; width: 100%;" srcdoc="
                <!DOCTYPE html>
                <html lang='en'>
                    <head>
                        <meta charset='UTF-8'>
                        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                        <title>About Us - PixelBooks</title>
                        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>
                        <style>
                            body {
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                height: 100vh;
                                background-color: #ffffff; /* Cambiado a fondo blanco */
                                font-family: Arial, sans-serif;
                            }
                            .content {
                                text-align: center;
                                padding: 20px;
                                background-color: #ffffff; /* Fondo blanco */
                                border-radius: 10px;
                                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                            }
                            h1 {
                                font-size: 2.5rem;
                                color: #007bff;
                            }
                            h2 {
                                font-size: 1.8rem;
                                margin-top: 20px;
                            }
                            p {
                                font-size: 1.2rem;
                                margin-top: 10px;
                                color: #333;
                            }
                        </style>
                    </head>
                    <body>
                        <div class='content'>
                            <h1>Welcome to PixelBooks!</h1>
                            <p>Explore our vast collection of books and enjoy your reading experience.</p>
                            <h2>About Us</h2>
                            <p>At PixelBooks, we provide a wide range of digital books for you to browse, save, and download at your convenience. Our platform is designed to make your reading experience seamless and enjoyable.</p>
                            <p>Whether you're looking for fiction, non-fiction, or educational materials, you'll find an extensive library to suit your interests.</p>
                            <p>Join us and dive into the world of reading. Happy reading!</p>
                        </div>
                    </body>
                </html>
            "></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
    
