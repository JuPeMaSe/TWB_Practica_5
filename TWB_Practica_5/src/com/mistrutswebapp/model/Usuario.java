package com.mistrutswebapp.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Guarda los atributos de un usuario
 * Atributos: user_ID, password, nombre, apellidos, tfno, email, userType, perfiles
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
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
	/**
	 * Constructor. 
	 */
	public Usuario(){
		super();
		perfiles=new ArrayList<Perfil>();
	}

	/**
	 * @return user_ID
	 */
	public String getUser_ID() {
		return user_ID;
	}

	/**
	 * Establece el valor de user_ID con el valor del parametro 
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
	 * Establece el valor de password con el valor del parametro 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el valor de nombre con el valor del parametro 
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
	 * Establece el valor de apellidos con el valor del parametro 
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
	 * Establece el valor de tfno con el valor del parametro 
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
	 * Establece el valor de email con el valor del parametro 
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
	 * Establece el valor de userType con el valor del parametro 
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return perfiles
	 */
	public Collection<Perfil> getPerfiles() {
		return perfiles;
	}

	/**
	 * Establece el valor de perfiles con el valor del parametro 
	 * @param perfiles
	 */
	public void setPerfiles(Collection<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

}

