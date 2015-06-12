package com.mistrutswebapp.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Usuario;
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con los atributos
 * correspondientes a todos los campos de un usuario, que se completan en
 * el formulario crearPage.jsp</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class UsuarioBean extends ValidatorForm implements Serializable{	
	/**
	 * Atributo: serialVersionUID tipo:long
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Campo con el ID del usuario
	 */
	private String user_ID;
	/**
	 * Campo con la contraseña del usuario
	 */
	private String password;
	/**
	 * Campo con la repetición de la contraseña del usuario
	 */
	private String password2;
	/**
	 * Campo con el nombre del usuario
	 */
	private String nombre;
	/**
	 * Campo con los apellidos del usuario
	 */
	private String apellidos;
	/**
	 * Campo con el teléfono del usuario
	 */
	private String tfno;
	/**
	 * Campo con el email del usuario
	 */
	private String email;
	/**
	 * Campo con el tipo de usuario dentro del sistema
	 */
	private String userType; //Está limitado a 3 caracteres en la BD
	
	/**
	 * Constructor con una llamada al constructor de la superclase ValidatorForm
	 */
	public UsuarioBean(){
		super();
	}

	/**
	 * @return user_ID
	 */
	public String getUser_ID() {
		return user_ID;
	}

	/**
	 * @param user_ID
	 */
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return tfno
	 */
	public String getTfno() {
		return tfno;
	}

	/**
	 * @param tfno
	 */
	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * Valida los campos del formulario de crearPage.jsp
	 * 
	 * @param mapping
	 * @param request
	 * @return errors identificación del error
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(user_ID == null || user_ID.equals("")){
			errors.add("user_ID", new ActionMessage("error.user_ID"));
		}
		if(password == null || password.equals("")){
			errors.add("password", new ActionMessage("error.password"));
		}
		if(password2 == null || password2.equals("")){
			errors.add("password2", new ActionMessage("error.password"));
		}
		if(!password.equals(password2)){
			errors.add("password", new ActionMessage("error.password.diferente"));
		}
		if(nombre == null || nombre.equals("")){
			errors.add("nombre", new ActionMessage("error.nombre"));
		}
		if(apellidos == null || apellidos.equals("")){
			errors.add("apellidos", new ActionMessage("error.apellidos"));
		}
		if(tfno != null && !tfno.equals("")){
			tfno = tfno.trim();
			boolean noValido=false;
			for(int i=0;i<tfno.length();i++){
				try{
					Integer.parseInt(tfno.substring(i,(i+1)));
				}catch (Exception e){
					noValido=true;
				}
			}
			if(noValido){
				errors.add("tfno", new ActionMessage("error.tfno"));	
			}			
		}
		if(email == null || email.equals("")){
			errors.add("email", new ActionMessage("error.email"));
		}else if (email!=null){
			if(!email.contains("@")){
				errors.add("email", new ActionMessage("error.email.noValido"));
			}
		}
		if(isValido(user_ID)==false){
			errors.add("user_ID", new ActionMessage("error.user_ID.noValido"));
		}
		return errors;
	 }

	/**
	 * Comprueba si el usuario introducido está ya dado de alta en la Base de DAtos
	 * @param user_ID
	 * @return boolean
	 */
	private boolean isValido(String user_ID) {
		boolean valido=true;
		Collection<Usuario> usuarioLista = ModelFacade.getUsuarios("");
		Iterator<Usuario> it = usuarioLista.iterator();
		Usuario usu= null;
		//Recorre la BD y si hay una coincidencia de user_ID pone valido a false
		while (it.hasNext()){
			usu= it.next();
			if(usu.getUser_ID().equals(user_ID)){
				valido= false;
			}
		}	
		return valido;
	}
}
