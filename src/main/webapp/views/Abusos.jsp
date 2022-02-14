<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Tipos de Abusos</h1>

<a href="TipoAbusoController?accion=abrirForm" class="btn btn-success" role="button">Agregar</a>

<table class="table table-bordered table-hover" id="datat">
	
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Descripciòn</th>
		<th colspan="2">Acciones</th>
	</tr>
	
	<c:forEach items="${abusos}" var="r">
	
		<tr>
			<td>${r.getIDabuso()}</td>
			<td>${r.getNombre()}</td>
			<td>${r.getDescripcion()} </td>
		
		<td>
			<a class="btn btn-secondary" href="TipoAbusoController?accion=ver&id=${r.getIDabuso()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
			<a class="btn btn-danger" onclick="borrar(event,${r.getIDabuso()},'TipoAbuso')" role="button">Borrar</a>
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
        perPage: "{select} Registros por pàgina",
        noRows: "No se encontraron registros",
        info: "Mostrando {start} al {end} de {rows} registros",
    }

});
</script>

<%@include file="footer.jsp" %>
	