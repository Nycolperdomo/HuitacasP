<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Tipo de Asesoria</h1>

<form method="post" action="TipoAsesoriaController?accion=edit">


  	<div class="form-group">
  		<input type="hidden" class="form-control" name="id" id="id" placeholder="" value="${asesorias.IDasesoria}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="tipo">Tipo</label>
  		<input type="text" class="form-control" name="tipo" id="tipo" value="${asesorias.tipo}"/>
  	</div>

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>