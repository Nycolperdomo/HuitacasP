package model;

public class tipoAsesoriaVo {
	private int IDasesoria;
	private String tipo;
	
	public tipoAsesoriaVo() {
		
	}

	public tipoAsesoriaVo(int iDasesoria, String tipo) {
		super();
		IDasesoria = iDasesoria;
		this.tipo = tipo;
	}

	public int getIDasesoria() {
		return IDasesoria;
	}

	public void setIDasesoria(int iDasesoria) {
		IDasesoria = iDasesoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
