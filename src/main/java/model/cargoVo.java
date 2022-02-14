package model;

public class cargoVo {
 private int IDcargo;
 private String cargo;
 
 private profesionalVo proCa;
 
 public cargoVo(){
 
 }

public cargoVo(int iDcargo, String cargo, profesionalVo proCa) {
	super();
	IDcargo = iDcargo;
	this.cargo = cargo;
	this.proCa = proCa;
}

public int getIDcargo() {
	return IDcargo;
}

public void setIDcargo(int iDcargo) {
	IDcargo = iDcargo;
}

public String getCargo() {
	return cargo;
}

public void setCargo(String cargo) {
	this.cargo = cargo;
}

public profesionalVo getProCa() {
	return proCa;
}

public void setProCa(profesionalVo proCa) {
	this.proCa = proCa;
}


}
