package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con un atributo de tipo array
 * de Strings, que almacena los perfiles que el usuario desea eliminar, y que ha elegido en el
 * formulario de checkbox eliminarPage.jsp.</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class EliminarPerfilesBean extends ValidatorForm implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Array de Strings que almacena los perfiles a eliminar.
	 */
	protected String[] profileIds;
	
	/**
	 * Constructor con la llamada super() al constructor de la clase ValidatorForm
	 */
	public EliminarPerfilesBean(){
		super();
	}
	
	/**
	 * @return profileIds
	 */
	public String[] getProfileIds() {
		return profileIds;
	}

	/**
	 * @param profileIds
	 */
	public void setProfileIds(String[] profileIds) {
		this.profileIds = profileIds;
	}

	/**
	 * Valida el formulario de checkbox eliminarPage.jsp, para que se elija al menos uno de los
	 * perfiles a eliminar.
	 * 
	 * @param mapping
	 * @param request
	 * @return errors identificación del error
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(profileIds==null){
			errors.add("profileIds", new ActionMessage("error.profileIds"));
		}		
		return errors;
	}	
}
