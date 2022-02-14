<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Tipo de abuso</h1>

<form method="post" action="TipoAbusoController?accion=edit">


  	<div class="form-group">
  		<input class="form-control" name="id" id="id" placeholder="" value="${abusos.IDabuso}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" value="${abusos.nombre}"/>
  	</div>
  	
  		<div class="form-group">
  		<label for="descripcion">Descripcion</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" value="${abusos.descripcion}"/>
  	</div>
  	

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>