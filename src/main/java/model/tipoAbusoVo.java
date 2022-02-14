package model;

public class tipoAbusoVo {
private int IDabuso; 
private String nombre,descripcion;

public tipoAbusoVo() {
	
}

public tipoAbusoVo(int iDabuso, String nombre, String descripcion) {
	super();
	IDabuso = iDabuso;
	this.nombre = nombre;
	this.descripcion = descripcion;
}

public int getIDabuso() {
	return IDabuso;
}

public void setIDabuso(int iDabuso) {
	IDabuso = iDabuso;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}



}
