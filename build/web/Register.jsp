<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Register</title>
    </head>
    <body>
        
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            String successMessage = (String) request.getAttribute("successMessage");
            if (errorMessage != null) { 
        %>
            <div class="alert alert-danger" role="alert">
                <%= errorMessage %>
            </div>
        <% 
            } else if (successMessage != null) {
        %>
            <div class="alert alert-success" role="alert">
                <%= successMessage %>
            </div>
        <% 
            }
        %>
        
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sing" action="Registrar" method="POST">
                        <div class="form-group text-center">
                        <img src="img/azul png.png" alt="Logo" width="200"/>
                        <br>
                        <h3>Register</h3>
                            <label>Sing up for free!🐐</label>
                        </div>
                        <div class="form-group">
                            <label>User: </label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Name: </label>
                            <input type="text" name="txtname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Last name: </label>
                            <input type="text" name="txtlastname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password: </label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Code: </label>
                            <input type="text" name="txtcode" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Register" class="btn btn-primary btn-block">
                        <input type="submit" name="accion" value="Log In" class="btn btn-primary btn-block">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>