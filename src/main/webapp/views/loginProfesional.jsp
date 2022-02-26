<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

</head>
<body style="background-color:#A1BFF5;">

<div class="row justify-content-center align-items-center vh-100">
    <aside class="col-sm-4">

        <div class="card">
            <article class="card-body">
                <h4 class="card-title mb-4 mt-1">Iniciar sesionn</h4>
                <form method="post" action="ProfesionalController?accion=login">
                    <div class="form-group">
                        <label for="correo" class="form-label">Correo</label>
                        <div class="input-group">
                            <div class="input-group-text">@</div>
                            <input type="email" class="form-control" placeholder="correo" id="correo" name="correo" autofocus required>
                        </div>

                        <div class="form-group">

                            <label for="password" class="form-label">Contraseña</label>
                            <input class="form-control" placeholder="******" type="password" id="password" name="password" required >

                            <a class="float-right" href="#">Olvidaste tu contraseña?</a>
                            <br>
                        </div> <!-- form-group// -->
                        <div class="form-group">
                            <div class="checkbox">
                                <!-- <label> <input type="checkbox"> Save password </label>-->
                            </div> <!-- checkbox .// -->
                        </div> <!-- form-group// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Iniciar sesion</button>

                            <!-- <button  href="RolController?accion=registrar" type="submit" class="btn btn-success btn-block"> Crear Cuenta</button> -->


                        </div> <!-- form-group// -->
                </form>
            </article>

            <div class="card-footer bg-transparent border-success">
                <p>
                    <%
                        if(request.getParameter("msn")!=null){
                            out.println(request.getParameter("msn"));
                        }
                    %>
                </p>
            </div>
        </div> <!-- card.// -->

    </aside> <!-- col.// -->
    <aside class="col-sm-4">
</body>
</html>
