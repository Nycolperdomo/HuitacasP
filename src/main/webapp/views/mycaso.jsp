<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Mi Caso</h1>

<a href="MisCasosController?accion=abrirFormRegis" class="btn btn-success" role="button">Agregar Casos</a>

<table class="table table-bordered table-hover" id="dataTable">
	
	<tr>
		<th>Id</th>
		<th>Descripcion</th>
	</tr>
	<!-- el member esta request.setAttribute("member", inte);para recibir datos (controller) -->
	<c:forEach items="${caso}" var="p">	
		<tr>
			<td>${p.getIDmicaso()}</td>
			<td>${p.getDescripcion}</td>
			
			
			<td>
			
			<a class="btn btn-warning" href="MisCasosController?accion=ver&id=${p.getIDmicaso()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
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
        perPage: "{select} Registros por página",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});

</script>

<%@include file="footer.jsp" %>
