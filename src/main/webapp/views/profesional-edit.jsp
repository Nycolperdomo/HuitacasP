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
  	</div>
  	
  	<div class="form-group">
  		<label for="telefono">Telefono</label>
  		<input type="texto" class="form-control" name="telefono" id="telefono" placeholder="Ingrese numero telefonico" value="${profesional.telefono}"/>
  	</div>
  	
  	<div class="form-group">
			<label for="tipodoc">Tipo Documento</label>
			<!-- SELECT INDISPENSABLE EL NAME -->
			<select name="tipodoc" class="form-select" value="${profesional.tipoDocumento}">
				<option selected>Selecione un tipo de documento</option>
				<option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
				<option value="Cedula de Ciudadania">Cedula de Ciudadania</option>
			</select>
		</div>
		
  	<div class="form-group">
  		<label for="nuDocumento">Numero Documento</label>
  		<input type="texto" class="form-control" name="nuDocumento" id="nuDocumento" placeholder="Ingrese numero de documento" value="${profesional.numeroDocumento}"/>
  	</div>
  	
  	

		<div class="form-group">
			<label for="fechaNa">Fecha Nacimiento</label>
			 <input	class="form-control" type="date" name="fechaNa" placeholder="Ingrese su Fecha de Nacimiento" value="${profesional.fechaNacimiento}"/>
		</div>
		
  	

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>