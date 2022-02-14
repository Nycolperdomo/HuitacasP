package model;

public class UsuarioVo {

	//atributos encapsulados
	private int IDusuario;
	private String correo;
	private String contrasena,cargo;
	private boolean estado;
	
	profesionalVo profesional;
	afectadaVo afec;
	
	
	//constructores vacio,recibir datos sourse generate  (fields)
	public UsuarioVo() {
		
	}



	public UsuarioVo(int iDusuario, String correo, String contrasena, String cargo, boolean estado, profesionalVo profesional, afectadaVo afec) {
		super();
		IDusuario = iDusuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.cargo = cargo;
		this.estado = estado;
		this.profesional = profesional;
		this.afec = afec;
	}



	//getter y setter sourse generate  (acceder de forma segura a los datos)
	public int getIDusuario() {
		return IDusuario;
	}


	public void setIDusuario(int iDusuario) {
		IDusuario = iDusuario;
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



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public profesionalVo getProfesional() {
		return profesional;
	}



	public void setProfesional(profesionalVo profesional) {
		this.profesional = profesional;
	}



	public afectadaVo getAfec() {
		return afec;
	}



	public void setAfec(afectadaVo afec) {
		this.afec = afec;
	}
	
	
	
	
}
