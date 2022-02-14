<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Editar mi caso</h1>

<form method="post" action="MisCasosController?accion=edit">


  	<div class="form-group">
  		<input class="form-control" name="id" id="id" placeholder="" value="${caso.IDmicaso}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="Descripcion">Descripcion</label>
  		<input type="text" class="form-control" name="Descripcion" id="Descripcion" value="${caso.Descripcion}"/>
  	</div>
  	

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>