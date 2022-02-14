function changeEstado(e,id,estad,con){
	e.preventDefault();
	
	console.log(id);
	console.log(estad);
	console.log(con);
	
	Swal.fire({
  title: 'Seguro desea cambiar el estado?',
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Ok, Cambie su estado!'
}).then((result) => {
  if (result.isConfirmed) {
	
	if(estad===true){
	
	//la accion cambiarEstado esta en el controlador en elncase
	ruta=con+"Controller?accion=changeEstado&id="+id+"&estad=false";
	window.setTimeout(function(){window.location.href=ruta},2000);
	}
	else{
	ruta=con+"Controller?accion=changeEstado&id="+id+"&estad=true";
	window.setTimeout(function(){window.location.href=ruta},2000);	
	}
    Swal.fire({
	 position: 'top-end',
	 icon: 'success',
     title: 'el registro ha sido cambiado!',
	showConfirmButton: false,
	timer: 1500
    })
  }
else{
	Swal.fire(
      'Accion cancelada!',
      'No se cambiara el estado del registro',
      'error'
	)}
})
}