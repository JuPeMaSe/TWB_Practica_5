package com.mistrutswebapp.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

import org.apache.struts.upload.FormFile;
/**
 * Clase para almacenar el perfil de un usuario.
 * Atributos: profile_ID, pdf, pdf_file, fotografia, fotografia_file, direccion, localidad, 
 * provincia, pais, cont_MeGusta, user_ID, reference, listaTit, listaTec, listExp.
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class Perfil implements Serializable {	
	private int profile_ID;
	private String pdf; 
	private FormFile pdf_file;
	private String fotografia;	
	private FormFile fotografia_file;
	private String direccion;
	private String localidad;
	private String provincia;
	private String pais;
	private int cont_MeGusta;
	private String user_ID;
	private String reference;
	private ArrayList<Integer> listaTit;
	private ArrayList<Experiencia> listaExp;
	private ArrayList<Integer> listaTec;
	
	/**
	 * Constructor. Inicializa los ArrayList
	 */
	public Perfil(){
		super();
		listaTit=new ArrayList<Integer>();
		listaTec=new ArrayList<Integer>();
		listaExp=new ArrayList<Experiencia>();
	}

	/**
	 * @return profile_ID
	 */
	public int getProfile_ID() {
		return profile_ID;
	}

	/**
	 * Establece el valor de profile_ID con el valor del parametro 
	 * @param profile_ID
	 */
	public void setProfile_ID(int profile_ID) {
		this.profile_ID = profile_ID;
	}

	/**
	 * @return pdf
	 */
	public String getPdf() {
		return pdf;
	}

	/**
	 * Establece el valor de pdf con el valor del parametro 
	 * @param pdf
	 */
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	/**
	 * @return pdf_file
	 */
	public FormFile getPdf_file() {
		return pdf_file;
	}

	/**
	 * Establece el valor de pdf_file con el valor del parametro 
	 * @param pdf_file
	 */
	public void setPdf_file(FormFile pdf_file) {
		this.pdf_file = pdf_file;
	}

	/**
	 * @return fotografia
	 */
	public String getFotografia() {
		return fotografia;
	}

	/**
	 * Establece el valor de fotografia con el valor del parametro 
	 * @param fotografia
	 */
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	/**
	 * @return fotografia_file
	 */
	public FormFile getFotografia_file() {
		return fotografia_file;
	}

	/**
	 * Establece el valor de fotografia_file con el valor del parametro 
	 * @param fotografia_file
	 */
	public void setFotografia_file(FormFile fotografia_file) {
		this.fotografia_file = fotografia_file;
	}

	/**
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece el valor de direccion con el valor del parametro 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Establece el valor de localidad con el valor del parametro 
	 * @param localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Establece el valor de provincia con el valor del parametro 
	 * @param provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Establece el valor de pais con el valor del parametro 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return cont_MeGusta
	 */
	public int getCont_MeGusta() {
		return cont_MeGusta;
	}

	/**
	 * Establece el valor de cont_MeGusta con el valor del parametro 
	 * @param cont_MeGusta
	 */
	public void setCont_MeGusta(int cont_MeGusta) {
		this.cont_MeGusta = cont_MeGusta;
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
	 * @return reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Establece el valor de reference con el valor del parametro 
	 * @param reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return listaTit
	 */
	public ArrayList<Integer> getListaTit() {
		return listaTit;
	}

	/**
	 * Establece el valor de listaTit con el valor del parametro 
	 * @param listaTit
	 */
	public void setListaTit(ArrayList<Integer> listaTit) {
		this.listaTit = listaTit;
	}

	/**
	 * @return listaExp
	 */
	public ArrayList<Experiencia> getListaExp() {
		return listaExp;
	}

	/**
	 * Establece el valor de listaExp con el valor del parametro 
	 * @param listaExp
	 */
	public void setListaExp(ArrayList<Experiencia> listaExp) {
		this.listaExp = listaExp;
	}

	/**
	 * @return listaTec
	 */
	public ArrayList<Integer> getListaTec() {
		return listaTec;
	}

	/**
	 * Establece el valor de listaTec con el valor del parametro 
	 * @param listaTec
	 */
	public void setListaTec(ArrayList<Integer> listaTec) {
		this.listaTec = listaTec;
	}


}
