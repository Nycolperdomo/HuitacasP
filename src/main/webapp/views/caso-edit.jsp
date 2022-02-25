<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Caso</h1>

<form method="post" action="CasoController?accion=edit">


  	<div class="form-group">
  		<input type="hidden" class="form-control" name="id" id="id" placeholder="" value="${caso.IDcaso}"/>
  	</div>
	<div class="form-group">
		<label for="tipoAbuso">Tipo Abuso</label>
		<input type="text" class="form-control" name="tipoAbuso" id="tipoAbuso"  value="${caso.tipoAbuso}"/>
	</div>

	<div class="form-group">
		<label for="tipoAsesoria">Tipo Asesoria</label>
		<select class="form-select" name="tipoAsesoria" id="tipoAsesoria" >
			<option>Seleccione el tipo de asesoria</option>
			<option>Juridica</option>
			<option>Psicologica</option>

		</select>

		<br>
	</div>

	<div class="form-group">
  		<label for="fechaInicio">Fecha Inicio Caso</label>
  		<input type="text" class="form-control" name="fechaInicio" id="fechaInicio" placeholder="" value="${caso.fechaInicio}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="fechaFin">Fecha Fin Caso</label>
  		<input type="text" class="form-control" name="fechaFin" id="fechaFin" placeholder="" value="${caso.fechaFin}"/>
  	</div>

	<div class="form-group">
		<label for="urlDocumento">urlDocumento</label>
		<input type="file" class="form-control" name="urlDocumento" id="urlDocumento"  value="${caso.urlDocumneto}"/>
	</div>
  	<div class="form-check">
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Caso Activo, desmarca para desactivar
  </label>
  </div>

	<div class="form-group">
		<label for="nombreAfectada">Nombre Afectada</label>
		<input type="text" class="form-control" name="nombreAfectada" id="nombreAfectada" placeholder="" value="${caso.fechaFin}"/>
	</div>
  	
  	<div class="form-group">
		<label for="nombreProfesional">Nombre Profesional</label>
		<input type="text" class="form-control" name="nombreProfesional" id="nombreProfesional" placeholder="" value="${caso.fechaFin}"/>
	</div>

<div>

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
</div>
  </form>

</div>


<%@include file="footer.jsp" %>

