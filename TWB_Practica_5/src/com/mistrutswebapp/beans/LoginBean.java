package com.mistrutswebapp.beans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.validator.ValidatorForm;
import java.text.NumberFormat;
import java.io.Serializable;


public class LoginBean extends ValidatorForm implements Serializable{
	private static final long serialVersionUID = 1L;
	private String user_ID;
	 private String password;
	
	 public LoginBean(){
		 super();
	 }
	
	 public void setUser_ID(String user_ID){
		 this.user_ID = user_ID;
	 }
	
	 public void setPassword(String password){
		 this.password = password;
	 }
	
	 public String getUser_ID(){
		 return user_ID;
	 }
	
	 public String getPassword(){
		 return password;
	 }
	
	 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		  ActionErrors errors = new ActionErrors();
		  if(user_ID == null || user_ID.length()<=0)		  {
			  errors.add("user_ID", new ActionMessage("error.user_ID"));
		  }		 
		  if(password == null || password.length()<=0){
			  errors.add("password", new ActionMessage("error.password"));
		  }
		  mapping.getInputForward();
		  return errors;
	 }
}