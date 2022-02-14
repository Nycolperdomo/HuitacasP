<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Tipo de Asesoria</h1>

<form method="post" action="TipoAsesoriaController?accion=addA">
  	
  	
  		<div class="form-group">
  		<label for="tipo">tipo</label><br>
  		<input type="text" class="form-control" name="tipo" id="tipo">
  	</div>
  	
  	<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
 
<%@include file="footer.jsp" %>