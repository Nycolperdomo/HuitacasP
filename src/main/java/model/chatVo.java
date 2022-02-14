package model;

import java.sql.Date;
import java.sql.Time;

public class chatVo {
	
	private int IDchat;
	private String mensaje;
	private Date fecha;
	private Time hora;
	
	public chatVo(){
		
	}

	public chatVo(int iDchat, String mensaje, Date fecha, Time hora) {
		super();
		IDchat = iDchat;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getIDchat() {
		return IDchat;
	}

	public void setIDchat(int iDchat) {
		IDchat = iDchat;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	
}
