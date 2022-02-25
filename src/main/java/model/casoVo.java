package model;

import java.sql.Date;

public class casoVo {

	private int IDcaso;
	private Boolean estado ;
	private String fechaInicio, fechaFin,tipoAbuso,tipoAsesoria,urlDocumento;
	private afectadaVo afeCas;
	private  profesionalVo profCaso;

	/*

	private tipoAsesoriaVo aseCas;
	private  profesionalVo profCaso;
	*/
	public casoVo () {
		
	}

	public casoVo(int IDcaso, Boolean estado, String fechaInicio, String fechaFin, String tipoAbuso, String tipoAsesoria, String urlDocumento, afectadaVo afeCas, profesionalVo profCaso) {
		this.IDcaso = IDcaso;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoAbuso = tipoAbuso;
		this.tipoAsesoria = tipoAsesoria;
		this.urlDocumento = urlDocumento;
		this.afeCas = afeCas;
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


	public Boolean getEstado() {
		return estado;
	}

	public String getTipoAbuso() {
		return tipoAbuso;
	}

	public void setTipoAbuso(String tipoAbuso) {
		this.tipoAbuso = tipoAbuso;
	}

	public String getTipoAsesoria() {
		return tipoAsesoria;
	}

	public void setTipoAsesoria(String tipoAsesoria) {
		this.tipoAsesoria = tipoAsesoria;
	}

	public String getUrlDocumento() {
		return urlDocumento;
	}

	public void setUrlDocumento(String urlDocumento) {
		this.urlDocumento = urlDocumento;
	}

	public afectadaVo getAfeCas() {
		return afeCas;
	}

	public void setAfeCas(afectadaVo afeCas) {
		this.afeCas = afeCas;
	}
	public profesionalVo getProfCaso() {
		return profCaso;
	}

	public void setProfCaso(profesionalVo profCaso) {
		this.profCaso = profCaso;
	}
	public String getAfeCasRep() {
		return this.afeCas!=null ? this.afeCas.getNombre() : "--";
	}


        public String getEstadoRep() {
            return this.estado ? "Activo" : "Inactivo";
        }


}
