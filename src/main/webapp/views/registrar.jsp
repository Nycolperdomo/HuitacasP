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


<body >
<div class="row justify-content-center align-items-center">
	<aside class="col-sm-6">
<br>
<br>
<div class="card justify-content-center align-items-center ">
<article class="card-body">
<h4 class="card-title mb-4 mt-1">Registro</h4>
	 <form>
	 <div class="form-group">
    	<label>Nombre</label>
    	<div class="input-group">
      <input type="text" class="form-control" id="nombres" placeholder="Ingrese sus nombres">
     
    </div>
    
     <div class="form-group">
    	<label>Apellidos</label>
    	
    	<div class="input-group">
      <input type="text" class="form-control" id="apellidos" placeholder="Ingrese sus apellidos">
    </div>
	 
	 <div class="form-group">
    	<label>Telefono</label>
    	
    	<div class="input-group">
      <input type="number" class="form-control" id="telefono" placeholder="Ingrese su numero de contacto">
    </div>
	 
    <div class="form-group">
    
    	<label>Correo</label>
    	<div class="input-group">
      <div class="input-group-text">@</div>
      <input type="email" class="form-control" id="correo" placeholder="ingrese su correo">
    </div>
    <br>
    	 <div class="form-group">
    
    	<label>Fecha de Nacimiento</label>
        <input class="form-control" id="fnacimiento" placeholder="00/00/0000" type="date">
        
    	<br>
    	
    	<div class="btn-group">
  <button type="button" class="btn btn-success dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
    <span >Tipo de documento</span>
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">CC</a></li>
    <li><a class="dropdown-item" href="#">TI</a></li>
  </ul>
  <label>Numero Documento</label>
        <input class="form-control" id="numeroDocumento" placeholder="numero documetno" type="number">
  
</div>
 
   
    </div> <!-- form-group// --> 
    <div class="form-group"> 
    <div class="checkbox">
     <!-- <label> <input type="checkbox"> Save password </label>-->
    </div> <!-- checkbox .// -->
    </div> <!-- form-group// -->  
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Registrate</button>
        
    </div> <!-- form-group// -->                                                           
</form>
</article>
</div> <!-- card.// -->

	</aside> <!-- col.// -->
	<aside class="col-sm-4">


</body>



</html>