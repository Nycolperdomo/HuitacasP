package model;

import java.util.Date;

public class profesionalVo {

	private int IDprofesional;
	private String 	nombre,apellido,correo,contrasena,numeroDocumento,cargo;
	//private Date fechaNacimiento ;
	private boolean estado;
	

	
	public profesionalVo() {
		
	}

/*
	public profesionalVo(int iDprofesional, String nombre, String apellido, String telefono, String correo,
			String tipoDocumento, String numeroDocumento, String fechaNacimiento, UsuarioVo proUs) {
		super();
		IDprofesional = iDprofesional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.proUs = proUs;
	}
*/

	public profesionalVo(int IDprofesional, String fechaNacimiento, String nombre, String apellido, String correo, String contrasena, String numeroDocumento, String cargo, boolean estado) {
		this.IDprofesional = IDprofesional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.numeroDocumento = numeroDocumento;
		this.cargo = cargo;
		this.estado = estado;
	}

	public int getIDprofesional() {
		return IDprofesional;
	}

	public void setIDprofesional(int iDprofesional) {
		IDprofesional = iDprofesional;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
