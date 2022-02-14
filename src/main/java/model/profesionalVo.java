package model;

import java.util.Date;

public class profesionalVo {

	private int IDprofesional;
	private String 	fechaNacimiento,nombre,apellido,telefono,correo,tipoDocumento,numeroDocumento;
	//private Date fechaNacimiento ;
	
	private UsuarioVo proUs;
	
	public profesionalVo() {
		
	}


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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public UsuarioVo getProUs() {
		return proUs;
	}

	public void setProUs(UsuarioVo proUs) {
		this.proUs = proUs;
	}


	
	
	
}
