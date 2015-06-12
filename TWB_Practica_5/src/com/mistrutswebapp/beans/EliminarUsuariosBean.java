package com.mistrutswebapp.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * <p>Extiende la clase ActionForm de Struts.  Representa un objeto javabean, con el único 
 * próposito de almacenar en el atributo de tipo array String[] userIds, los checkbox seleccionados
 * en el formulario eliminarUsuarioPage.jsp y que se corresponden con los usuarios que el administrador
 * desea eliminar.</p>
 */
public class EliminarUsuariosBean extends ActionForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Array de Strings que almacena los usuarios a eliminar.
	 */
	protected String[] userIds = {};
		
	/**
	 * Constructor con la llamada super() al constructor de la clase ActionForm
	 */
	public EliminarUsuariosBean() {
		super();
	}
	
	
	/**
	 * @return userIds
	 */
	public String[] getUserIds() {
		return userIds;
	}


	/**
	 * @param userIds
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
