<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Usuario</h1>

<form method="post" action="ProfesionalController?accion=edit">


  	<div class="form-group">
  		<input type="text" class="form-control" name="id" id="id" placeholder="" value="${profesional.IDprofesional}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${profesional.nombre}"/>
  	</div>
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese apellido" value="${profesional.apellido}"/>

	</div><div class="form-group">
	<label for="correo">Correo</label>
	<input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese el correo" value="${profesional.correo}"/>
</div>

	<div class="form-group">
		<label for="correo">Contraseña</label>
		<input type="password" class="form-control" name="password" id="password" placeholder="Ingrese la contraseña" value="${profesional.contrasena}"/>
	</div>
	<div class="form-group">
		<label for="nuDocumento">Numero Documento</label>
		<input type="texto" class="form-control" name="nuDocumento" id="nuDocumento" placeholder="Ingrese numero de documento" value="${profesional.numeroDocumento}"/>
	</div>
	<div class="form-group">
		<div class="form-check">
			<input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado"
			<c:out value="${profesional.estado==false ? 'unchecked':'checked'}"/> >
			<label class="form-check-label" for="flexCheckChecked">
				${profesional.estado==false ? 'Marca para Activar Usuario':'Desmarca para desactivar Usuario'}
			</label>
		</div>
		<div class="form-group">
			<label for="cargo">Cargo</label>
			<select name="cargo" id="cargo" class="form-select" value="${profesional.cargo}">
				<option selected>Selecione un tipo de documento</option>
				<option value="afectada">Abogada</option>
				<option value="psicologa">Psicologa</option>
				<option value="administrador">Administrador</option>
			</select>
		</div>

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>