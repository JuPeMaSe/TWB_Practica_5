package com.mistrutswebapp.model;

import java.io.Serializable;
/**
 * Clase que guarda las Tecnologías disponibles para insertarlas en un perfil
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class Tecnologia implements Serializable{
	private static final long serialVersionUID = 1L;
	int tecnologia_ID;
	String nombre_Tec;
	/**
	 * Constructor
	 */
	public Tecnologia(){
		super(); 		
	}
	/**
	 * @return tecnologia_ID
	 */
	public int getTecnologia_ID() {
		return tecnologia_ID;
	}
	/**
	 * Establece el valor de tecnologia_ID con el valor del parametro 
	 * @param tecnologia_ID
	 */
	public void setTecnologia_ID(int tecnologia_ID) {
		this.tecnologia_ID = tecnologia_ID;
	}
	/**
	 * @return nombre_Tec
	 */
	public String getNombre_Tec() {
		return nombre_Tec;
	}
	/**
	 * Establece el valor de nombre_Tec con el valor del parametro 
	 * @param nombre_Tec
	 */
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
	}
	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
