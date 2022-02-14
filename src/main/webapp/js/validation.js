  const contrasena = document.getElementById("contrasena") 
  const form = document.getElementById("warnings") 
  
  form.addEventListener("submit", e=>{
	e.preventDefault()
	let warnings = ""
	let entrar = false
	if (contrasena.value.lengh <6){
		warnings += 'la contraseña no es valida <br>'
		entrar = true
	}
	 
	if (entrar){
		parrafo.innerHTML = warnings
	}else{
	
			parrafo.innerHTML = "enviado"
	
	}
	
  })
  
