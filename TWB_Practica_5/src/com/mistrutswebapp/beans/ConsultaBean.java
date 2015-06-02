package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class ConsultaBean extends ValidatorForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String localidad;
	private String provincia;
	private String pais;
	private boolean chkLocalidad;
	private boolean chkProvincia;
	private boolean chkPais;
	
	private String tecn_ID;
	private String nombre_Tec;
	private boolean chkTecnologia;
	
	private String titu_ID;
	private String nombre_Tit;
	private boolean chkTitulacion;
	
	private String a_Experiencia;
	private boolean chkExperiencia;
	

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the tecnologia_ID
	 */
	public String getTecn_ID() {
		return tecn_ID;
	}
	/**
	 * @param tecnologia_ID the tecnologia_ID to set
	 */
	public void setTecn_ID(String tecn_ID) {
		this.tecn_ID = tecn_ID;
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
	/**
	 * @return the titulacion_ID
	 */
	public String getTitu_ID() {
		return titu_ID;
	}
	/**
	 * @param titulacion_ID the titulacion_ID to set
	 */
	public void setTitu_ID(String titu_ID) {
		this.titu_ID = titu_ID;
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
	
	/**
	 * @return the a_Experiencia
	 */
	public String getA_Experiencia() {
		return a_Experiencia;
	}
	/**
	 * @param a_Experiencia the a_Experiencia to set
	 */
	public void setA_Experiencia(String a_Experiencia) {
		this.a_Experiencia = a_Experiencia;
	}
	
	
	/**
	 * @return the chkLocalidad
	 */
	public boolean isChkLocalidad() {
		return chkLocalidad;
	}
	/**
	 * @param chkLocalidad the chkLocalidad to set
	 */
	public void setChkLocalidad(boolean chkLocalidad) {
		this.chkLocalidad = chkLocalidad;
	}
	/**
	 * @return the chkProvincia
	 */
	public boolean isChkProvincia() {
		return chkProvincia;
	}
	/**
	 * @param chkProvincia the chkProvincia to set
	 */
	public void setChkProvincia(boolean chkProvincia) {
		this.chkProvincia = chkProvincia;
	}
	/**
	 * @return the chkPais
	 */
	public boolean isChkPais() {
		return chkPais;
	}
	/**
	 * @param chkPais the chkPais to set
	 */
	public void setChkPais(boolean chkPais) {
		this.chkPais = chkPais;
	}
	/**
	 * @return the chkTecnologia
	 */
	public boolean isChkTecnologia() {
		return chkTecnologia;
	}
	/**
	 * @param chkTecnologia the chkTecnologia to set
	 */
	public void setChkTecnologia(boolean chkTecnologia) {
		this.chkTecnologia = chkTecnologia;
	}
	/**
	 * @return the chkTitulacion
	 */
	public boolean isChkTitulacion() {
		return chkTitulacion;
	}
	/**
	 * @param chkTitulacion the chkTitulacion to set
	 */
	public void setChkTitulacion(boolean chkTitulacion) {
		this.chkTitulacion = chkTitulacion;
	}
	/**
	 * @return the chkExperiencia
	 */
	public boolean isChkExperiencia() {
		return chkExperiencia;
	}
	/**
	 * @param chkExperiencia the chkExperiencia to set
	 */
	public void setChkExperiencia(boolean chkExperiencia) {
		this.chkExperiencia = chkExperiencia;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(!this.isChkPais() && !this.isChkLocalidad() && !this.isChkProvincia() && !this.isChkTecnologia() && !this.isChkTitulacion() && !this.isChkExperiencia() ){
			errors.add("consulta", new ActionMessage("error.consulta.seleccion"));
		}
		return errors;
	}
	

}
