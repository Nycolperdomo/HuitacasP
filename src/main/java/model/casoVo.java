package model;

import java.sql.Date;

public class casoVo {

	private int IDcaso;
	private Boolean estado ;
	private String fechaInicio, fechaFin;

	private tipoAbusoVo abuCas;
	private tipoAsesoriaVo aseCas;
	private  profesionalVo profCaso;
	
	
	
	public casoVo () {
		
	}


	public casoVo(int iDcaso, Boolean estado, String fechaInicio, String fechaFin, tipoAbusoVo abuCas,
			tipoAsesoriaVo aseCas, profesionalVo profCaso) {
		super();
		IDcaso = iDcaso;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.abuCas = abuCas;
		this.aseCas = aseCas;
		this.profCaso = profCaso;
		
	}


	public int getIDcaso() {
		return IDcaso;
	}


	public void setIDcaso(int iDcaso) {
		IDcaso = iDcaso;
	}



	public Boolean isEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public tipoAbusoVo getAbuCas() {
		return abuCas;
	}


	public void setAbuCas(tipoAbusoVo abuCas) {
		this.abuCas = abuCas;
	}


	public tipoAsesoriaVo getAseCas() {
		return aseCas;
	}


	public void setAseCas(tipoAsesoriaVo aseCas) {
		this.aseCas = aseCas;
	}


	public String getAbuCasRep() {
		return this.abuCas!=null ? this.abuCas.getNombre() : "--";
	}
	
	public String getEstadoRep() {
		return this.estado ? "Activo" : "Inactivo";
	}

	public profesionalVo getProfCaso() {
		return profCaso;
	}

	public void setProfCaso(profesionalVo profCaso) {
		this.profCaso = profCaso;
	}
}
