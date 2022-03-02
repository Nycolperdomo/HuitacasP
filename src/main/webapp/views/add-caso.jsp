<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

	<h1>Registrar Mi Caso</h1>

	<form method="post" action="CasoController?accion=add">

		<div class="form-group">
			<label for="tipoAbuso">Tipo Abuso:</label>
			<input type="text" class="form-control" name="tipoAbuso" id="tipoAbuso">
		</div>


		<div class="form-group">
			<label for="tipoAsesoria">Tipo Asesoria</label>
			<select class="form-select" name="tipoAsesoria" id="tipoAsesoria">
				<option>Seleccione el tipo de asesoria</option>
				<option>Juridica</option>
				<option>Psicologica</option>
			</select>
		</div>
		<div class="form-group">
			<label for="fechaInicio">Fecha Inicio</label>
			<input type="text" class="form-control" name="fechaInicio" id="fechaInicio" placeholder="Ingrese la fecha inicio del caso" required/>
		</div>

		<div class="form-group">
			<label for="fechaFin">Fecha Fin</label>
			<input type="text" class="form-control" name="fechaFin" id="fechaFin" placeholder="Ingrese la fecha final del caso" required/>
		</div>

		<div class="form-group">
			<label for="documento">Subir Documento</label>
			<input type="file" class="form-control" name="documento" id="documento">
		</div>
		<br>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
			<label class="form-check-label" for="flexCheckChecked">
				Caso Activo
			</label>
		</div>


		<select name="procaso"><br>
			<option> Seleccione al profesional con el que desea asesoria</option><br>
			<c:forEach items="${prof}" var="r">
				<option value="${r.getIDprofesional()}"> ${r.getNombre() } </option>
			</c:forEach>
		</select><br>
		<br>
		<div class="form-group">

			<input type="hidden" class="form-control"  name="afecas" id="procaso" value="${us.getIDafectada()}">
		</div>


		<div>
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
		<div>
			<button type="submit" class="btn btn-primary">hptaaa</button>
		</div>
		<h1>hola</h1>
	</form>

</div>

<%@include file="footer.jsp" %>