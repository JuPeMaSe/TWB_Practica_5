package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con los campos
 * correspondientes a los filtros elegidos en el formulario consultaPage.jsp con los que
 * se desea realizar la consulta de usuarios de la base de datos.</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class ConsultaBean extends ValidatorForm implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Campo con la localidad por la que filtrar la consulta
	 */
	private String localidad;
	/**
	 * Campo con la provincia por la que filtrar la consulta
	 */
	private String provincia;
	/**
	 * Campo con el pais por el que filtrar la consulta
	 */
	private String pais;
	/**
	 * Realizar filtro por localidad
	 */
	private boolean chkLocalidad;
	/**
	 * Realizar filtro por provincia
	 */
	private boolean chkProvincia;
	/**
	 * Realizar filtro por pais
	 */
	private boolean chkPais;
	/**
	 * Campo con el ID de la tecnología por la que filtrar la consulta
	 */
	private String tecn_ID;
	/**
	 * Campo con el nombre de la tecnología por la que filtrar la consulta
	 */
	private String nombre_Tec;
	/**
	 * Realizar filtro por tecnología
	 */
	private boolean chkTecnologia;
	/**
	 * Campo con el ID de la titulación por la que filtrar la consulta
	 */
	private String titu_ID;
	/**
	 * Campo con el nombre de la titulación por la que filtrar la consulta
	 */
	private String nombre_Tit;
	/**
	 * Realizar el filtro por la titulación
	 */
	private boolean chkTitulacion;
	/**
	 * Campo con los años de experiencia por los que filtrar la consulta
	 */
	private String a_Experiencia;
	/**
	 * Realizar el filtro por los años de experiencia
	 */
	private boolean chkExperiencia;
	

	/**
	 * @return localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return tecnologia_ID
	 */
	public String getTecn_ID() {
		return tecn_ID;
	}
	/**
	 * @param tecnologia_ID
	 */
	public void setTecn_ID(String tecn_ID) {
		this.tecn_ID = tecn_ID;
	}
	/**
	 * @return nombre_Tec
	 */
	public String getNombre_Tec() {
		return nombre_Tec;
	}
	/**
	 * @param nombre_Tec
	 */
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
	}
	/**
	 * @return titulacion_ID
	 */
	public String getTitu_ID() {
		return titu_ID;
	}
	/**
	 * @param titulacion_ID
	 */
	public void setTitu_ID(String titu_ID) {
		this.titu_ID = titu_ID;
	}
	/**
	 * @return nombre_Tit
	 */
	public String getNombre_Tit() {
		return nombre_Tit;
	}
	/**
	 * @param nombre_Tit
	 */
	public void setNombre_Tit(String nombre_Tit) {
		this.nombre_Tit = nombre_Tit;
	}
	
	/**
	 * @return a_Experiencia
	 */
	public String getA_Experiencia() {
		return a_Experiencia;
	}
	/**
	 * @param a_Experiencia
	 */
	public void setA_Experiencia(String a_Experiencia) {
		this.a_Experiencia = a_Experiencia;
	}
	
	
	/**
	 * @return chkLocalidad
	 */
	public boolean isChkLocalidad() {
		return chkLocalidad;
	}
	/**
	 * @param chkLocalidad
	 */
	public void setChkLocalidad(boolean chkLocalidad) {
		this.chkLocalidad = chkLocalidad;
	}
	/**
	 * @return chkProvincia
	 */
	public boolean isChkProvincia() {
		return chkProvincia;
	}
	/**
	 * @param chkProvincia
	 */
	public void setChkProvincia(boolean chkProvincia) {
		this.chkProvincia = chkProvincia;
	}
	/**
	 * @return chkPais
	 */
	public boolean isChkPais() {
		return chkPais;
	}
	/**
	 * @param chkPais
	 */
	public void setChkPais(boolean chkPais) {
		this.chkPais = chkPais;
	}
	/**
	 * @return chkTecnologia
	 */
	public boolean isChkTecnologia() {
		return chkTecnologia;
	}
	/**
	 * @param chkTecnologia
	 */
	public void setChkTecnologia(boolean chkTecnologia) {
		this.chkTecnologia = chkTecnologia;
	}
	/**
	 * @return chkTitulacion
	 */
	public boolean isChkTitulacion() {
		return chkTitulacion;
	}
	/**
	 * @param chkTitulacion
	 */
	public void setChkTitulacion(boolean chkTitulacion) {
		this.chkTitulacion = chkTitulacion;
	}
	/**
	 * @return chkExperiencia
	 */
	public boolean isChkExperiencia() {
		return chkExperiencia;
	}
	/**
	 * @param chkExperiencia
	 */
	public void setChkExperiencia(boolean chkExperiencia) {
		this.chkExperiencia = chkExperiencia;
	}
	/**
	 * Valida los campos del formulario de consulta de la base de datos consultaPage.jsp.
	 * 
	 * @param mapping
	 * @param request
	 * @return errors identificación del error
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(!this.isChkPais() && !this.isChkLocalidad() && !this.isChkProvincia() && !this.isChkTecnologia() && !this.isChkTitulacion() && !this.isChkExperiencia() ){
			errors.add("consulta", new ActionMessage("error.consulta.seleccion"));
		}
		if(!this.a_Experiencia.isEmpty() && this.a_Experiencia!=""){
			try{
				a_Experiencia= a_Experiencia.trim();
				Integer.parseInt(a_Experiencia.trim());
			}catch(Exception e){
				errors.add("a_Experiencia",new ActionMessage("error.numeroNoValido"));
			}
		}
		return errors;
	}
	

}
