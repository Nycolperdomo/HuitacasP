function borrar(e,id,con){
	//EVITAR QUE UN FORMULARIO SE EJECUTE Y PUEDA DETENER ESAS ACCIONES
	e.preventDefault();
	
	console.log(id);
	console.log(con);
	
	Swal.fire({
  title: 'Seguro desea eliminar este registro?',
  text: "Esta accion no se puede revertir",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Ok, Eliminalo!'
}).then((result) => {
  if (result.isConfirmed) {
	
	ruta=con+"Controller?accion=delete&id="+id;
	window.setTimeout(function(){window.location.href=ruta},2000);
	
    Swal.fire(
      'Registro eliminado!',
      'Su registro ha sido eliminado satisfactoriamente',
      'success'
    )
  }
else{
	Swal.fire(
      'Accion cancelada!',
      'No se eleminiara el registro',
      'error'
	)}
})
}


