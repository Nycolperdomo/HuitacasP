<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Mi Caso</h1>
<form method="post" action="MisCasosController?accion=addDocumentCase" enctype="multipart/form-data" >

	<div class="form-group">
		<label for="nombre">Nombre Afectada</label>
		<input type="text" class="form-control" name="nombre" id="nombre">
	</div>
  	<div class="form-group">
  		<label for="descripcion">Descripcion/Tipo de ayuda que solicita</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion">
  	</div>

	<div class="form-group">
		<label for="documento">Subir Documento</label>
		<input type="file" class="form-control" name="documento" id="documento">
	</div>
  	<br>
  <div>
  	<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
 
<%@include file="footer.jsp" %>