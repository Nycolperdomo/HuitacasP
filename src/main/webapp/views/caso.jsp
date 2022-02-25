<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Caso</h1>

<a href="CasoController?accion=abrirFormRegis" class="btn btn-success" role="button">Agregar</a>
<a href="CasoController?accion=reporteCasos" class="btn btn-primary" role="button">Generar Reporte de los casos</a>

<table class="table table-bordered table-hover" id="dataTable">
	<!--ESTA INFO SE MUESTRA CUANDO YA SE SEPA QUIEN TRATO EL CASO Y DEMA EES DECIR EL CASO YA ESTA ASIGNADO RESPECTIVAMENTE-->
	<tr>
		<th>Id</th>
		<th>Tipo<br>
			Abuso</th>
		<th>Tipo<br>
			Asesoria</th>

		<th>Nombre<br>
			Afectada</th>
<!--afeCas y profCaso-->
		<th>Nombre<br>
			Profesional a cargo</th>

		<th>Documento Caso</th>
		<th>Fecha <br> Inicio</th>
		<th>Fecha </br>Fin</th>
		<th>Estado</th>
		<th>Acciones</th>
		<th colspan="2">Acciones</th>
	</tr>
	<!-- el member esta request.setAttribute("member", inte);para recibir datos (controller) -->
	<c:forEach items="${caso}" var="a">	
		<tr>
			<td>${a.getIDcaso()}</td>
			<td>${a.getTipoAbuso()}</td>
			<td>${a.getTipoAsesoria()}</td>
			<td>${a.profCaso.nombre}</td>
			<td>${a.afeCas.nombre}</td>
			<td>${a.getUrlDocumento()}</td>
			<td>${a.getFechaInicio()}</td>
			<td>${a.getFechaFin()}</td>
			<c:if test="${a.isEstado()==true}">
				<td><span class="badge bg-success">Activo</span>
					<a class="btn btn-danger btn-sm" onclick="changeEstado(event,${a.getIDcaso()},${a.isEstado()},'Caso')" role="button">Inactivar</a>

				</td>
			</c:if>
			<c:if test="${a.isEstado()==false}">
				<td><span class="badge bg-danger">Inactivo</span>
				
				<a class="btn btn-success btn-sm" onclick="changeEstado(event,${a.getIDcaso()},${a.isEstado()},'Caso')" role="button">Activar</a>
				</td>
			</c:if>
			<td></td>
			<td>
			<a class="btn btn-warning" href="CasoController?accion=ver&id=${a.getIDcaso()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
			<a class="btn btn-danger" onclick="borrar(event,${a.getIDcaso()},'Caso')" role="button">Borrar</a>
			</td>
		</tr>
	</c:forEach>

</table>

</div>


<!-- datatable  -->

<script>

<!--queryselector para seleccionar la tabla que se va autilizatr , nos permite identificar en este caso por un ID  -->
var myTable = document.querySelector("#dataTable");
<!--inicializar el objeto datatable que tiene js -->
var dataTable = new DataTable("#dataTable", {
    perPage:5,
    labels: {
        placeholder: "Buscar...",
        perPage: "{select} Registros por pagina",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});

</script>

<%@include file="footer.jsp" %>
