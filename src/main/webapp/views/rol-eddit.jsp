<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Usuario</h1>

<form method="post" action="RolController?accion=edit">


  	<div class="form-group">
  		<input type="hidden" class="form-control" name="id" id="id" placeholder="" value="${roles.IDusuario}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="correo">Correo</label>
  		<input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese el correo" value="${roles.correo}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="correo">Contraseña</label>
  		<input type="password" class="form-control" name="password" id="password" placeholder="Ingrese la contraseña" value="${roles.contraseña}"/>
  	</div>
  	
  	
  	<div class="form-check">
	  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
	  <c:out value="${roles.estado==false ? 'unchecked':'checked'}"/> >
	  <label class="form-check-label" for="flexCheckChecked">
	    ${roles.estado==false ? 'Marca para Activar Usuario':'Desmarca para desactivar Usuario'}
	  </label>
	</div>


  	<div class="form-group">
			<label for="cargo">Cargo Usuario</label>
			 <select class="form-select" name="cargo">
				<option>Seleccione el cargo del Usuario</option>
				<option>Abogada</option>
				<option>Psicologa</option>
				<option>Cliente</option>
			</select>
  	

<div>

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>