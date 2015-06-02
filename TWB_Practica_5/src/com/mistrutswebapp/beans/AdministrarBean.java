package com.mistrutswebapp.beans;

import org.apache.struts.action.ActionForm;

public class AdministrarBean extends ActionForm{
	
	private boolean adConsultar;
	private boolean adAltaUsuario;
	private boolean adBajaUsuario;
	private boolean adCrearPerfil;
	private boolean adModificarPerfil;
	private boolean adEliminarPerfil;

	public AdministrarBean() {
		super();
	}

	/**
	 * @return the adConsultar
	 */
	public boolean getAdConsultar() {
		return adConsultar;
	}

	/**
	 * @param adConsultar the adConsultar to set
	 */
	public void setAdConsultar(boolean adConsultar) {
		this.adConsultar = adConsultar;
	}

	/**
	 * @return the adAltaUsuario
	 */
	public boolean getAdAltaUsuario() {
		return adAltaUsuario;
	}

	/**
	 * @param adAltaUsuario the adAltaUsuario to set
	 */
	public void setAdAltaUsuario(boolean adAltaUsuario) {
		this.adAltaUsuario = adAltaUsuario;
	}

	/**
	 * @return the adBajaUsuario
	 */
	public boolean getAdBajaUsuario() {
		return adBajaUsuario;
	}

	/**
	 * @param adBajaUsuario the adBajaUsuario to set
	 */
	public void setAdBajaUsuario(boolean adBajaUsuario) {
		this.adBajaUsuario = adBajaUsuario;
	}

	/**
	 * @return the adCrearPerfil
	 */
	public boolean getAdCrearPerfil() {
		return adCrearPerfil;
	}

	/**
	 * @param adCrearPerfil the adCrearPerfil to set
	 */
	public void setAdCrearPerfil(boolean adCrearPerfil) {
		this.adCrearPerfil = adCrearPerfil;
	}

	/**
	 * @return the adModificarPerfil
	 */
	public boolean getAdModificarPerfil() {
		return adModificarPerfil;
	}

	/**
	 * @param adModificarPerfil the adModificarPerfil to set
	 */
	public void setAdModificarPerfil(boolean adModificarPerfil) {
		this.adModificarPerfil = adModificarPerfil;
	}

	/**
	 * @return the adEliminarPerfil
	 */
	public boolean getAdEliminarPerfil() {
		return adEliminarPerfil;
	}

	/**
	 * @param adEliminarPerfil the adEliminarPerfil to set
	 */
	public void setAdEliminarPerfil(boolean adEliminarPerfil) {
		this.adEliminarPerfil = adEliminarPerfil;
	}
	
	
	
}
