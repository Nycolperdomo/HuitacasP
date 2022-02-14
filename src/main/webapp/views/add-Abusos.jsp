<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Tipo de Abuso</h1>

<form method="post" action="TipoAbusoController?accion=addA">
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre">
  	</div>
  	
  		<div class="form-group">
  		<label for="descripcion">Descripricion</label><br>
  		<input type="text" class="form-control" name="descripcion" id="descripcion">
  	</div>
  	
  	<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
 
<%@include file="footer.jsp" %>