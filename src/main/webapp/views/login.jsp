<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animalandia Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="./css/estilos.css">
</head>
<body>
<div class="login">
	<div class="card border-success mb-3" style="width: 25rem;">
	  <div class="card-header bg-transparent border-success"><strong>Login</strong></div>
	  <div class="card-body text-success">
	    <form method="post" action="UsuarioController?accion=login">
		  <div class="mb-3">
		    <label for="correo" class="form-label">Correo Electrónico</label>
		    <input type="email" class="form-control" id="correo" name="correo">
		  </div>
		  <div class="mb-3">
		    <label for="password" class="form-label">Password</label>
		    <input type="password" class="form-control" id="password" name="password">
		  </div>
		  <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
		</form>
	  </div>
	  <div class="card-footer bg-transparent border-success">
	  	<p>
	  		<%
	  			if(request.getParameter("msn")!=null){
	  				out.println(request.getParameter("msn"));
	  			}
	  		%>
	  	</p>
	  </div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>