<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Usuarios</h1>

<a href="RolController?accion=abrirForm" class="btn btn-success" role="button">Agregar</a>

<table class="table table-bordered table-hover" id="datat">
	
	<tr>
		<th>Id</th>
		<th>correo</th>
		<th>contraseña</th>
		<th>Estado</th>
		<th>Cargo</th>
		<th colspan="2">Acciones</th>
	</tr>
	
	<c:forEach items="${roles}" var="r">
	
		<tr>
			<td>${r.getIDusuario()}</td>
			<td>${r.getCorreo()}</td>
			<td>${r.getContraseña()} </td>
			
			<c:if test="${r.isEstado()==true}">
				<td><span class="badge bg-success">Activo</span>
					<a class="btn btn-danger btn-sm" onclick="changeEstado(event,${r.getIDusuario()},${r.isEstado()},'Rol')" role="button">Inactivar</a>
				
				</td>
			</c:if>
			<c:if test="${r.isEstado()==false}">
				<td><span class="badge bg-danger">Inactivo</span>
				
				<a class="btn btn-success btn-sm" onclick="changeEstado(event,${r.getIDusuario()},${r.isEstado()},'Rol')" role="button">Activar</a>
				</td>
			</c:if>
		<td>${r.getCargo()}</td>
			<td>
			<a class="btn btn-secondary" href="RolController?accion=ver&id=${r.getIDusuario()}" role="button">Editar</a>
			<!--invocar una funcion con onclick(borrar es el nombre de la funcion)-->
			<a class="btn btn-danger" onclick="borrar(event,${r.getIDusuario()},'Rol')" role="button">Borrar</a>
			</td>
	
			<c:if test="${r.isEstado()==false}">
				<td><span class="badge bg-danger">Inactivo</span>
				
				<a class="btn btn-success btn-sm" onclick="changeEstado(event,${r.getIDusuario()},${r.isEstado()},'Rol')" role="button">Activar</a>
				</td>
			</c:if>
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
