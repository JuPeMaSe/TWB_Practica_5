package com.mistrutswebapp.beans;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con los atributos
 * correspondientes a las acciones que un usuario decida tomar, una vez obtiene los
 * resultados de la consulta: mostrar un perfil o realizar otra consulta </p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class ResultadoConsultaBean extends ValidatorForm implements Serializable{
	/**
	 * Atributo: serialVersionUID tipo:long
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Recoge la acción del usuario una vez mostrados los resultados de la consulta
	 */
	private String accion;
	/**
	 * Recoge la acción del usuario con el perfil a modificar o si no desea modificar ninguno.
	 */
	private String mostrar;

	/**
	 * @return mostrar
	 */
	public String getMostrar() {
		return mostrar;
	}

	/**
	 * @param mostrar
	 */
	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	/**
	 * @return accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}


}
