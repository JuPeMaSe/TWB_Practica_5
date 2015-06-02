package com.mistrutswebapp.model;

import java.io.Serializable;

public class Tecnologia implements Serializable{
	private static final long serialVersionUID = 1L;
	int tecnologia_ID;
	String nombre_Tec;
	public Tecnologia(){
		super(); 		
	}
	/**
	 * @return the tecnologia_ID
	 */
	public int getTecnologia_ID() {
		return tecnologia_ID;
	}
	/**
	 * @param tecnologia_ID the tecnologia_ID to set
	 */
	public void setTecnologia_ID(int tecnologia_ID) {
		this.tecnologia_ID = tecnologia_ID;
	}
	/**
	 * @return the nombre_Tec
	 */
	public String getNombre_Tec() {
		return nombre_Tec;
	}
	/**
	 * @param nombre_Tec the nombre_Tec to set
	 */
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
	}
	

}
