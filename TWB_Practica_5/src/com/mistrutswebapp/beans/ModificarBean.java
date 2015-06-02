package com.mistrutswebapp.beans;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;

public class ModificarBean extends ValidatorForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String accion;
	public ModificarBean(){
		super();
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
