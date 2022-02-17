f<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Registrar Rol</h1>

<form method="post" action="RolController?accion=add">
  	
  	<div class="form-group">
  		<label for="correo">Correo</label>
  		<input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese el correo" onchange="verifyCorreo()" required/>
  	</div>
	<!--
  <div id="validarC" class="text-danger"></div>	
  		<div class="form-group">
  		<label for="password">Contrase�a</label><br>
  		<input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="Ingrese la contrase�a" required/>
  	</div>
  	-->
  	<div class="form-check">
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Activo
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
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>
<!-- LIBRERIA JQUERY -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
function verifyCorreo(){
	const correo=document.getElementById("correo").value;
	
	$.ajax({
		url:"RolController?accion=validarCorreo",
		data:{
			correo:correo
		},
		success: function(result){
			$("#validarC").html(result);
			//alert(result);
			return false;
		}
	})
}

</script>

<%@include file="footer.jsp" %>
