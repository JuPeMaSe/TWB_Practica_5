package com.mistrutswebapp.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Esta clase javabean tiene el único próposito de almacenar en el array String[] userIds,
 * los checkbox seleccionados en el formulario eliminarUsuarioPage.jsp y que se corresponden
 * con los usuarios que el administrador desea eliminar.
 */
public class EliminarUsuariosBean extends ActionForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String[] userIds = {};

	public EliminarUsuariosBean() {
		super();
	}
	
	
	/**
	 * @return the userIds
	 */
	public String[] getUserIds() {
		return userIds;
	}


	/**
	 * @param userIds the userIds to set
	 */
	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}


	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}
	
	

}
