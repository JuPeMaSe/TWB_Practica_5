package com.mistrutswebapp.beans;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con un �nico campo String
 * que recoge la acci�n del usuario que decide modificar uno de sus perfiles: o salir del 
 * formulario modificarPage.jsp de modificaci�n de perfiles, o elegir un perfil para modificarlo.</p>
 * 
 * @author Grupo 7 Pr�cticas Tecnolog�as Web 2014-2015
 *
 */
public class ModificarBean extends ValidatorForm implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Recoge la acci�n del usuario con el perfil a modificar o si no desea modificar ninguno.
	 */
	private String accion;
	
	/**
	 * Constructor con la llamada super() al constructor de la clase ValidatorForm
	 */
	public ModificarBean(){
		super();
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
