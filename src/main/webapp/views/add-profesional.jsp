<%@include file="header.jsp"%>
<div class="flex-fill flex-grow-1 ms-3">

	<h1>Registrar Profesional</h1>

	<form method="post" action="ProfesionalController?accion=add">

		<!-- ESTOS DATOS SE MIRAN EN LA BD  -->


		<div class="form-group">
			<label for="nombre">Nombre</label> 
			<input class="form-control" type="text" name="nombre" placeholder="Ingrese su nombre" required>
		</div>
		<div class="form-group">
			<label for="apellido">Apellido</label> 
			<input class="form-control" type="text" name="apellido" placeholder="Ingrese su Apellido" required>
		</div>
		<div class="form-group">
			<label for="telefono">Telefono</label> 
			<input class="form-control" type="number" name="telefono" placeholder="Ingrese su Numero de Telefono" required>
		</div>
		<div class="form-group">
			<label for="correo">Correo</label>
			<input class="form-control" type="email" name="correo" placeholder="Ingrese su correo " required>
		</div>


		<div class="form-group">
			<label for="tipoDocumento">Tipo Documento</label>
			<!-- SELECT INDISPENSABLE EL NAME -->
			<select name="tipoDocumento" class="form-select">
				<option selected>Selecione un tipo de documento</option>
				<option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
				<option value="Cedula de Ciudadania">Cedula de Ciudadania</option>
			</select>
		</div>


		<div class="form-group">
			<label for="numeroDocumento">Numero de Documento</label>
			 <input class="form-control" type="text" name="numeroDocumento" placeholder="Ingrese su numero de documento" required>
		</div>



		<!--<div class="form-group">
			<label for="direccion">Direccion</label> <input class="form-control" type="text" name="direccion" placeholder="Ingrese su Direccion">
		</div>-->



		<div class="form-group">
			<label for="fechaNacimiento">Fecha Nacimiento</label>
			 <input	class="form-control" type="date" name="fechaNacimiento" placeholder="Ingrese su Fecha de Nacimiento">
		</div>


		<!--  <div class="form-group">
			<label for="password">Contrase�a</label> 
			<input class="form-control" type="password" name="password" placeholder="Ingrese su Contrase�a">
		</div>
		
		<!-- ESTE ES UN EJEMPLO DONDE SE TRAEN DATOS DE ROL (DATOS RELACIONADOS) 
		<div class="form-group">
			<label for="carpro">Cargo Profesional</label>
			 <select class="form-select" name="carpro">
				<option>Seleccione el cargo del profesional</option>
				<c:forEach items="${cargos}" var="c">
				<option value="${c.IDcargo}">${c.cargo}</option>
				</c:forEach>
			</select>

		</div> -->
	
		
		<div>
			<button type="submit" class="btn btn-primary">Guardar</button>
			
<a href="Controller?accion=" class="btn btn-secondary" role="button">Siguiente</a>
		</div>
		
		
	</form>

</div>


<%@include file="footer.jsp"%>