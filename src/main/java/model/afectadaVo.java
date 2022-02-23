package model;

import java.sql.Date;

public class afectadaVo {

	private int IDafectada;
	private String fechaNacimiento,nombre,apellido,numeroDocumento,cargo,correo,contrasena;
	//private Date ;
	private boolean estado;
	
	//private UsuarioVo afecUs;
	
	public afectadaVo () {
		
	}
/*
	public afectadaVo(int iDafectada, String nombre, String apellido,
			String numeroDocumento, String fechaNacimiento, ) {
		super();
		IDafectada = iDafectada;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.afecUs = afecUs;
	}
*/

	public afectadaVo(int IDafectada, String fechaNacimiento, String nombre, String apellido, String numeroDocumento, String cargo, String correo, String contrasena, boolean estado) {
		this.IDafectada = IDafectada;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroDocumento = numeroDocumento;
		this.cargo = cargo;
		this.correo = correo;
		this.contrasena = contrasena;
		this.estado = estado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getIDafectada() {
		return IDafectada;
	}

	public void setIDafectada(int iDafectada) {
		IDafectada = iDafectada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	
	/*public String getAfecUsRep() {
		return this.afecUs ? "Activo" : "Inactivo" this.afecUs.isEstado() : "--";
	}*/
}
