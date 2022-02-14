package model;

import java.sql.Date;

public class consejeriaVo {

private int IDconsejeria;
private Date fecha;
private afectadaVo afeCo ;
private tipoAsesoriaVo AseCo;


public consejeriaVo() {
	
}


public consejeriaVo(int iDconsejeria, Date fecha, afectadaVo afeCo, tipoAsesoriaVo aseCo) {
	super();
	IDconsejeria = iDconsejeria;
	this.fecha = fecha;
	this.afeCo = afeCo;
	AseCo = aseCo;
}


public int getIDconsejeria() {
	return IDconsejeria;
}


public void setIDconsejeria(int iDconsejeria) {
	IDconsejeria = iDconsejeria;
}


public Date getFecha() {
	return fecha;
}


public void setFecha(Date fecha) {
	this.fecha = fecha;
}


public afectadaVo getAfeCo() {
	return afeCo;
}


public void setAfeCo(afectadaVo afeCo) {
	this.afeCo = afeCo;
}


public tipoAsesoriaVo getAseCo() {
	return AseCo;
}


public void setAseCo(tipoAsesoriaVo aseCo) {
	AseCo = aseCo;
}


}
