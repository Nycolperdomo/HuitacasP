<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

<h1>Actualizar Correo</h1>

<form method="post" action="RolController?accion=changeCorreo">
  	
  	<div class="form-group">
  		<label for="id">Id Documento</label>
  		<input type="hidden" class="form-control" name="id" id="id" value="${us.IDafectada}"/>
  		<input type="hidden" class="form-control" name="passu" id="passu" value="${us.correo}"/>
  		
  	</div>
  	
  		<div class="form-group">
  		<label for="passant">Correo Actual</label><br>
  		<input type="email" class="form-control" onchange="verifyPass()" name="passant" id="passant" placeholder="Ingrese el correo actual"/>
  	</div>
  	
  		<div class="form-group">
  		<label for="passnew">Correo Nuevo</label><br>
  		<input type="email" class="form-control" onchange="verificarPass()" name="passnew" id="passnew" placeholder="Ingrese la contrase�a nueva"/>
  	</div>
  	
  	
  		<div class="form-group">
  		<label for="passnew2">Confirma Correo Nuevo</label><br>
  		<input type="email" class="form-control" name="passnew2" id="passnew2" placeholder="Confirme la contrase�a nueva"/>
  	</div>
  	
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
		
  </form>

</div>

<script>
function verifyPass(){
	console.log("estoy aqui");
	//password del ususario que se conecto
	const passus=document.getElementById("passu");
	//password que el usuario digita
	const passant=document.getElementById("passant");
	
	if(passus.value==passant.value){
		alert("El correo actual se ha confirmado");
	}else{
		alert("Los correos no coinciden con la base de datos");
		passant.focus();
		passant.value="";
	}
}

<!--

function vericarPass(){
	const passnew=document.getElementById("passnew");
	const passnew2=document.getElementById("passnew2");
	
	if(passnew.value==passnew2.value){
		alert("Las contrase�as coinciden");
	}else{
		alert("Las contrase�as no coinciden");
		passant.focus();
		passant.value="";
	}
}
-->
</script>

<%@include file="footer.jsp" %>
