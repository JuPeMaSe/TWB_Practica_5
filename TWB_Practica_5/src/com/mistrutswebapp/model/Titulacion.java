package com.mistrutswebapp.model;

import java.io.Serializable;

public class Titulacion implements Serializable {
	private static final long serialVersionUID = 1L;
	int titulacion_ID;
	String nombre_Tit;
	public Titulacion(){
		super();
	}
	/**
	 * @return the titulacion_ID
	 */
	public int getTitulacion_ID() {
		return titulacion_ID;
	}
	/**
	 * @param titulacion_ID the titulacion_ID to set
	 */
	public void setTitulacion_ID(int titulacion_ID) {
		this.titulacion_ID = titulacion_ID;
	}
	/**
	 * @return the nombre_Tit
	 */
	public String getNombre_Tit() {
		return nombre_Tit;
	}
	/**
	 * @param nombre_Tit the nombre_Tit to set
	 */
	public void setNombre_Tit(String nombre_Tit) {
		this.nombre_Tit = nombre_Tit;
	}
	

}
