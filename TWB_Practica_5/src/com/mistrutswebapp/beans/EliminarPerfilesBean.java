package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class EliminarPerfilesBean extends ValidatorForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String[] profileIds;
	
	
	public EliminarPerfilesBean(){
		super();
	}
	
	/**
	 * @return the profileIds
	 */
	public String[] getProfileIds() {
		return profileIds;
	}

	/**
	 * @param profileIds the profileIds to set
	 */
	public void setProfileIds(String[] profileIds) {
		this.profileIds = profileIds;
	}


	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(profileIds==null){
			errors.add("profileIds", new ActionMessage("error.profileIds"));
		}		
		return errors;
	}

	
}
