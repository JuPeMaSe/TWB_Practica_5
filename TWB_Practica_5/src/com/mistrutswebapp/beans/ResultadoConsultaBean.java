package com.mistrutswebapp.beans;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;

public class ResultadoConsultaBean extends ValidatorForm implements Serializable{

	private String accion;
	private String mostrar;

	/**
	 * @return the mostrar
	 */
	public String getMostrar() {
		return mostrar;
	}

	/**
	 * @param mostrar the mostrar to set
	 */
	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}


}
