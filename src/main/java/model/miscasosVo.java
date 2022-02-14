package model;

public class miscasosVo {

	private int IDmicaso;
	private String Descripcion ;
	
	
	public miscasosVo () {
		
	}
	

	public miscasosVo(int iDmicaso, String descripcion) {
		super();
		IDmicaso = IDmicaso;
		this.Descripcion = Descripcion;
		
	}



	public int getIDmicaso() {
		return IDmicaso;
	}




	public void setIDmicaso(int iDmicaso) {
		IDmicaso = iDmicaso;
	}


	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}




}


	