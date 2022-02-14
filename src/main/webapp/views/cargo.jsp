<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Cargos</h1>

<a href="CargoController?accion=abrirForm" class="btn btn-success" role="button">Agregar</a>

<table class="table table-bordered table-hover" id="datat">
	
	<tr>
		<th>IdCargo</th>
		<!--<th>IdProfesional</th>-->
		<th>Cargo</th>
		<th>No<br>Documento</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th colspan="2">Acciones</th>
	</tr>
	
	<c:forEach items="${cargo}" var="c">
	
		<tr>
			<td>${c.getIDcargo()}</td>
			<td>${c.getCargo()}</td>
			
			<td>${c.AfeCa.numeroDocumento} </td>
			<td>${c.AfeCa.nombre} </td>
			<td>${c.AfeCa.apellido} </td>
			
			<td>
			
			<a class="btn btn-secondary" href="CargoController?accion=ver$id=${c.getIDcargo()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
			<a class="btn btn-danger" onclick="borrar(event,${c.getIDcargo()},'Cargo')" role="button">Borrar</a>
			</td>
		</tr>
	</c:forEach>

</table>

</div>

<!-- datatable  -->
<script>


var myTable = document.querySelector("#datat");
var dataTable = new DataTable("#datat", {
    perPage:5,
    labels: {
        placeholder: "Buscar...",
        perPage: "{select} Registros por página",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});
</script>

<%@include file="footer.jsp" %>
