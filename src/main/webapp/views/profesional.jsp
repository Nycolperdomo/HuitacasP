<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Profesionales</h1>

<a href="ProfesionalController?accion=abrirFormRegis" class="btn btn-success" role="button">Agregar</a>

<table class="table table-bordered table-hover" id="dataTable">
	
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Correo</th>
		<th>Estado</th>
		<th>Cargo</th>
		<th colspan="2">Acciones</th>
	</tr>
	<!-- el member esta request.setAttribute("member", inte);para recibir datos (controller) -->
	<c:forEach items="${profesional}" var="p">	
		<tr>
			<td>${p.getIDprofesional()}</td>
			<td>${p.getNombre()}</td>
			<td>${p.getApellido()}</td>
			<td>${p.getCorreo()}</td>
			<c:if test="${p.isEstado()==true}">
				<td><span class="badge bg-success">Activo</span>
					<a class="btn btn-danger btn-sm" onclick="changeEstado(event,${p.getIDprofesional()},${p.isEstado()},'Profesional')" role="button">Inactivar</a>
				</td>
			</c:if>
			<c:if test="${p.isEstado()==false}">
				<td><span class="badge bg-danger">Inactivo</span>
					<a class="btn btn-success btn-sm" onclick="changeEstado(event,${p.getIDprofesional()},${p.isEstado()},'Profesional')" role="button">Activar</a>
				</td>
			</c:if>
			<td>${p.getCargo()}</td>
			<td>
			<a class="btn btn-warning" href="ProfesionalController?accion=ver&id=${p.getIDprofesional()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
			<a class="btn btn-danger" onclick="borrar(event,${p.getIDprofesional()},'Profesional')" role="button">Borrar</a>
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
        perPage: "{select} Registros por p�gina",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});

</script>

<%@include file="footer.jsp" %>
