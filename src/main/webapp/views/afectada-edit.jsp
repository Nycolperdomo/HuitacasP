<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">


<h1>Actualizar Afectada</h1>

<form method="post" action="AfectadaController?accion=edit">


  	
  	<div class="form-group">
  		<input type="hidden" class="form-control" name="id" id="id" placeholder="" value="${afectada.IDafectada}"/>
  	</div>
  	
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${afectada.nombre}"/>
  	</div>
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese apellido" value="${afectada.apellido}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="telefono">Telefono</label>
  		<input type="texto" class="form-control" name="telefono" id="telefono" placeholder="Ingrese numero telefonico" value="${afectada.telefono}"/>
  	</div>
  	
  	<div class="form-group">
			<label for="tipodoc">Tipo Documento</label>
			<!-- SELECT INDISPENSABLE EL NAME -->
			<select name="tipodoc" class="form-select" value="${afectada.tipoDocumento}">
				<option selected>Selecione un tipo de documento</option>
				<option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
				<option value="Cedula de Ciudadania">Cedula de Ciudadania</option>
			</select>
		</div>
		
  	<div class="form-group">
  		<label for="nuDocumento">Numero Documento</label>
  		<input type="texto" class="form-control" name="nuDocumento" id="nuDocumento" placeholder="Ingrese numero de documento" value="${afectada.numeroDocumento}"/>
  	</div>
  	
  	
		<div class="form-group">
			<label for="fechaNa">Fecha Nacimiento</label>
			 <input	class="form-control" type="date" name="fechaNa" placeholder="Ingrese su Fecha de Nacimiento" value="${afectada.fechaNacimiento}"/>
		</div>
		
  	

<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>