package com.mistrutswebapp.beans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.validator.ValidatorForm;
import java.text.NumberFormat;
import java.io.Serializable;
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con los campos
 * correspondientes al formulario loginform.jsp con el que un usuario anónimo inicia
 * una sesión.</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class LoginBean extends ValidatorForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador del usuario user_ID
	 */
	private String user_ID;
	/**
	 * Contraseña del usuario
	 */
	 private String password;
	
	 /**
	  * Constructor con la llamada super() al constructor de la clase ValidatorForm
	  */
	 public LoginBean(){
		 super();
	 }
	 
	 /**
	  * @param user_ID
	  */
	
	 public void setUser_ID(String user_ID){
		 this.user_ID = user_ID;
	 }
	
	 /**
	  * @param password
	  */
	 public void setPassword(String password){
		 this.password = password;
	 }
	
	 /**
	  * @return user_ID
	  */
	 public String getUser_ID(){
		 return user_ID;
	 }
	
	 /**
	  * @return password
	  */
	 public String getPassword(){
		 return password;
	 }
	 
	 /**
	 * Valida los campos del formulario de inicio de sesión loginform.jsp
	 * 
	 * @param mapping
	 * @param request
	 * @return errors identificación del error
	 */
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