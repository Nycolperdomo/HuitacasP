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
			<label for="correo">Correo</label>
			<input class="form-control" type="email" name="correo" placeholder="Ingrese su Correo" required>
		</div>
		<!--<div class="form-group">
			<label for="contrasena">Contraseña</label>
			<input class="form-control" type="password" name="contrasena" placeholder="Ingrese su contraseña " required>
		</div>-->
		<div class="form-group">
			<label for="numeroDocumento">Numero de Documento</label>
			<input class="form-control" type="number" name="numeroDocumento" placeholder="Ingrese su Numero De Documento " required>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
			<label class="form-check-label" for="flexCheckChecked">
				Activo
			</label>
		</div>
		<div class="form-group">
			<label for="cargo">Cargo</label>
			<!-- SELECT INDISPENSABLE EL NAME -->
			<select name="cargo" class="form-select">
				<option selected>Rol Profesional</option>
				<option value="Abogada">Abogada</option>
				<option value="Psicologa">Psicologa</option>
			</select>
		</div>

		<!--<div class="form-group">
			<label for="direccion">Direccion</label> <input class="form-control" type="text" name="direccion" placeholder="Ingrese su Direccion">
		</div>-->

		<!--  <div class="form-group">
			<label for="password">Contrase�a</label> 
			<input class="form-control" type="password" name="password" placeholder="Ingrese su Contrase�a">
		</div>
		
		ESTE ES UN EJEMPLO DONDE SE TRAEN DATOS DE ROL (DATOS RELACIONADOS)
		<div class="form-group">
			<label for="carpro">Cargo Profesional</label>
			 <select class="form-select" name="carpro">
				<option>Seleccione el cargo del profesional</option>
		</div> -->



<!-- Remind Passowrd -->

<div>

	<br>
	<button type="submit" class="btn btn-primary">Guardar</button>
</div>








		
		
	</form>

</div>


<%@include file="footer.jsp"%>