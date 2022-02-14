package model;

public class informeVo {
private int IDinforme;
private String informe;
private casoVo caIn;

public informeVo() {
	
}

public informeVo(int iDinforme, String informe, casoVo caIn) {
	super();
	IDinforme = iDinforme;
	this.informe = informe;
	this.caIn = caIn;
}

public int getIDinforme() {
	return IDinforme;
}

public void setIDinforme(int iDinforme) {
	IDinforme = iDinforme;
}

public String getInforme() {
	return informe;
}

public void setInforme(String informe) {
	this.informe = informe;
}

public casoVo getCaIn() {
	return caIn;
}

public void setCaIn(casoVo caIn) {
	this.caIn = caIn;
}


}
