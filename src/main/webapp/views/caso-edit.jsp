<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Caso</h1>

<form method="post" action="CasoController?accion=edit">


  	<div class="form-group">
  		<input type="hidden" class="form-control" name="id" id="id" placeholder="" value="${caso.IDcaso}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="fi">Fecha Inicio Caso</label>
  		<input type="text" class="form-control" name="FechaInicio" id="FechaInicio" placeholder="Ingrese la fecha inicio caso" value="${caso.fechaInicio}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="ff">Fecha Fin Caso</label>
  		<input type="text" class="form-control" name="FechaFin" id="FechaFin" placeholder="Ingrese la fecha fin caso" value="${caso.fechaFin}"/>
  	</div>
  	
  	<div class="form-check">
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Caso Activo, desmarca para desactivar
  </label>
  </div>


	<div class="form-group">
			<label for="asesoria">Tipo Asesoria</label>
			 <select class="form-select" name="asesoria">
				<option>Seleccione el tipo de asesoria</option>
				<option>Juridica</option>
				<option>Psicologica</option>
			
			</select>
			
			<br>
			</div>
  	
  	

<div>

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>

