package com.mistrutswebapp.beans;

import org.apache.struts.action.ActionForm;
/**
 * <p>Extiende la clase ActionForm de Struts.  Representa un objeto javabean que almacena en forma de
 * atributos booleanos, las funcionalidades que el administrador de la aplicación ha decidido
 * deshabilitar, al completar el formulario de checkbox administrarPage.jsp.</p>
 * <p>El acceso a los atributos privados se hace a través de los métodos getters y setters.</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class AdministrarBean extends ActionForm{
	/**
	 * Funcionalidad para consultar la base de datos de usuarios
	 */
	private boolean adConsultar;
	/**
	 * Funcionalidad para dar de alta un usuario
	 */
	private boolean adAltaUsuario;
	/**
	 * Funcionalidad para dar de baja un usuario
	 */
	private boolean adBajaUsuario;
	/**
	 * Funcionalidad para crear un perfil de usuario
	 */
	private boolean adCrearPerfil;
	/**
	 * Funcionalidad para modificar el perfil de un usuario
	 */
	private boolean adModificarPerfil;
	/**
	 * Funcionalidad para eliminar un perfil de un usuario
	 */
	private boolean adEliminarPerfil;
	
	/**
	 * Constructor con la llamada super() al constructor de la clase Action
	 */
	public AdministrarBean() {
		super();
	}

	/**
	 * @return adConsultar
	 */
	public boolean getAdConsultar() {
		return adConsultar;
	}

	/**
	 * @param adConsultar 
	 */
	public void setAdConsultar(boolean adConsultar) {
		this.adConsultar = adConsultar;
	}

	/**
	 * @return adAltaUsuario
	 */
	public boolean getAdAltaUsuario() {
		return adAltaUsuario;
	}

	/**
	 * @param adAltaUsuario
	 */
	public void setAdAltaUsuario(boolean adAltaUsuario) {
		this.adAltaUsuario = adAltaUsuario;
	}

	/**
	 * @return adBajaUsuario
	 */
	public boolean getAdBajaUsuario() {
		return adBajaUsuario;
	}

	/**
	 * @param adBajaUsuario
	 */
	public void setAdBajaUsuario(boolean adBajaUsuario) {
		this.adBajaUsuario = adBajaUsuario;
	}

	/**
	 * @return adCrearPerfil
	 */
	public boolean getAdCrearPerfil() {
		return adCrearPerfil;
	}

	/**
	 * @param adCrearPerfil
	 */
	public void setAdCrearPerfil(boolean adCrearPerfil) {
		this.adCrearPerfil = adCrearPerfil;
	}

	/**
	 * @return adModificarPerfil
	 */
	public boolean getAdModificarPerfil() {
		return adModificarPerfil;
	}

	/**
	 * @param adModificarPerfil
	 */
	public void setAdModificarPerfil(boolean adModificarPerfil) {
		this.adModificarPerfil = adModificarPerfil;
	}

	/**
	 * @return adEliminarPerfil
	 */
	public boolean getAdEliminarPerfil() {
		return adEliminarPerfil;
	}

	/**
	 * @param adEliminarPerfil
	 */
	public void setAdEliminarPerfil(boolean adEliminarPerfil) {
		this.adEliminarPerfil = adEliminarPerfil;
	}

	
	
}
