<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar My Caso</h1>
<form method="post" action="MisCasosController?accion=add">
  	
  	<div class="form-group">
  		<label for="descripcion">Descripcion</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion">
  	</div>
  	<br>
  
  	<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
 
<%@include file="footer.jsp" %>