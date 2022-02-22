package model;

import java.sql.Date;

public class afectadaVo {

	private int IDafectada;
	private String fechaNacimiento,nombre,apellido,telefono,tipoDocumento,numeroDocumento;
	//private Date ;
	
	private UsuarioVo afecUs;
	
	public afectadaVo () {
		
	}

	public afectadaVo(int iDafectada, String nombre, String apellido, String telefono, String tipoDocumento,
			String numeroDocumento, String fechaNacimiento, UsuarioVo afecUs) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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


	public UsuarioVo getAfecUs() {return afecUs;}

	public void setAfecUs(UsuarioVo afecUs) {
		this.afecUs = afecUs;
	}
	
	/*public String getAfecUsRep() {
		return this.afecUs ? "Activo" : "Inactivo" this.afecUs.isEstado() : "--";
	}*/
}
