package com.mistrutswebapp.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;



public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user_ID;
	private String password;
	private String nombre;
	private String apellidos;
	//private Date fe_Nac; //hay que revisar tipo
	private String tfno;
	private String email;
	private String userType; //Está limitado a 3 caracteres en la BD
	private Collection<Perfil> perfiles;
	
	public Usuario(){
		super();
		perfiles=new ArrayList<Perfil>();
	}
	
	/**
	 * @return the user_ID
	 */
	public String getUser_ID() {
		return user_ID;
	}

	/**
	 * @param user_ID the user_ID to set
	 */
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the tfno
	 */
	public String getTfno() {
		return tfno;
	}

	/**
	 * @param tfno the tfno to set
	 */
	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the perfiles
	 */
	public Collection<Perfil> getPerfiles() {
		return perfiles;
	}

	/**
	 * @param perfiles the perfiles to set
	 */
	public void setPerfiles(Collection<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
//
//	/**
//	 * 
//	 */
//	public void addPerfil(Perfil perfil){
//		perfiles.add(perfil);
//		perfil.setUser_ID(this.user_ID);
//	}
	
}

