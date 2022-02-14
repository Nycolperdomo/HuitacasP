f<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Caso</h1>

<form method="post" action="CasoController?accion=add">
  	
  	<div class="form-group">
  		<label for="fi">Fecha Inicio</label>
  		<input type="text" class="form-control" name="FechaInicio" id="FechaInicio" placeholder="Ingrese la fecha inicio del caso" required/>
  	</div>
	
  	<div class="form-group">
  		<label for="ff">Fecha Fin</label>
  		<input type="text" class="form-control" name="FechaFin" id="FechaFin" placeholder="Ingrese la fecha final del caso" required/>
  	</div>
  		
  	
  	<div class="form-check">
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Caso Activo
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
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>

<%@include file="footer.jsp" %>
