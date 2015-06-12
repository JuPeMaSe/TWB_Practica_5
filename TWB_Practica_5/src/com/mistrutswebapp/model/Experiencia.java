package com.mistrutswebapp.model;

import java.io.Serializable;
/**
 * Clase que guarda la experiencia de un determinado perfil. Tiene como atributros: empresa, cargo, a_Inicio, a_Fin;
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class Experiencia implements Serializable{
	private static final long serialVersionUID = 1L;
	int exp_ID;
	String empresa;
	String cargo;
	int a_Inicio;
	int a_Fin;
	String strA_Inicio;
	String strA_Fin;
	int profile_ID;
	
	/**
	 * Constructor por defecto
	 */
	public Experiencia(){
		super();
	}


	/**
	 * @return exp_ID
	 */
	public int getExp_ID() {
		return exp_ID;
	}


	/**
	 * Establece el valor de exp_ID con el valor del parametro 
	 * @param exp_ID
	 */
	public void setExp_ID(int exp_ID) {
		this.exp_ID = exp_ID;
	}


	/**
	 * @return empresa
	 */
	public String getEmpresa() {
		return empresa;
	}


	/**
	 * Establece el valor de empresa con el valor del parametro 
	 * @param empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	/**
	 * @return cargo
	 */
	public String getCargo() {
		return cargo;
	}


	/**
	 * Establece el valor de cargo con el valor del parametro 
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	/**
	 * @return a_Inicio
	 */
	public int getA_Inicio() {
		return a_Inicio;
	}


	/**
	 * Establece el valor de a_Inicio con el valor del parametro 
	 * @param a_Inicio
	 */
	public void setA_Inicio(int a_Inicio) {
		this.a_Inicio = a_Inicio;
	}


	/**
	 * @return a_Fin
	 */
	public int getA_Fin() {
		return a_Fin;
	}


	/**
	 * Establece el valor de a_Fin con el valor del parametro 
	 * @param a_Fin
	 */
	public void setA_Fin(int a_Fin) {
		this.a_Fin = a_Fin;
	}


	/**
	 * @return strA_Inicio
	 */
	public String getStrA_Inicio() {
		return strA_Inicio;
	}


	/**
	 * @param strA_Inicio the strA_Inicio to set
	 */
	public void setStrA_Inicio(String strA_Inicio) {
		this.strA_Inicio = strA_Inicio;
		this.a_Inicio=Integer.parseInt(strA_Inicio);
	}

	/**
	 * @return the strA_Fin
	 */
	public String getStrA_Fin() {
		return (""+a_Fin);
	}

	/**
	 * @param strA_Fin the strA_Fin to set
	 */
	public void setStrA_Fin(String strA_Fin) {
		this.strA_Fin = strA_Fin;
		this.a_Fin=Integer.parseInt(strA_Fin);
	}

	/**
	 * @return the profile_ID
	 */
	public int getProfile_ID() {
		return profile_ID;
	}

	/**
	 * @param profile_ID the profile_ID to set
	 */
	public void setProfile_ID(int profile_ID) {
		this.profile_ID = profile_ID;
	}


	
}
