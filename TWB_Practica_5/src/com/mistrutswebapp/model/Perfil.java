package com.mistrutswebapp.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

import org.apache.struts.upload.FormFile;

public class Perfil implements Serializable {
	private int profile_ID;
	private String pdf; //a cambiar el tipo para almacenar pdf
	private FormFile pdf_file;
	private String fotografia;//a cambiar el tipo para almacenar jpeg, bmp...	
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
	
	
	public Perfil(){
		super();
		listaTit=new ArrayList<Integer>();
		listaTec=new ArrayList<Integer>();
		listaExp=new ArrayList<Experiencia>();
	}
	

	/**
	 * @return the pdf_file
	 */
	public FormFile getPdf_file() {
		return pdf_file;
	}


	/**
	 * @param pdf_file the pdf_file to set
	 */
	public void setPdf_file(FormFile pdf_file) {
		this.pdf_file = pdf_file;
	}


	/**
	 * @return the fotografia_file
	 */
	public FormFile getFotografia_file() {
		return fotografia_file;
	}


	/**
	 * @param fotografia_file the fotografia_file to set
	 */
	public void setFotografia_file(FormFile fotografia_file) {
		this.fotografia_file = fotografia_file;
	}


	/**
	 * @return the pdf
	 */
	public String getPdf() {
		return pdf;
	}

	/**
	 * @param pdf the pdf to set
	 */
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	/**
	 * @return the fotografia
	 */
	public String getFotografia() {
		return fotografia;
	}

	/**
	 * @param fotografia the fotografia to set
	 */
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	
	

	public int getProfile_ID() {
		return profile_ID;
	}


	public void setProfile_ID(int profile_ID) {
		this.profile_ID = profile_ID;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getCont_MeGusta() {
		return cont_MeGusta;
	}

	public void setCont_MeGusta(int cont_MeGusta) {
		this.cont_MeGusta = cont_MeGusta;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}


	/**
	 * @return the listaTit
	 */
	public ArrayList<Integer> getListaTit() {
		return listaTit;
	}


	/**
	 * @param listaTit the listaTit to set
	 */
	public void setListaTit(ArrayList<Integer> listaTit) {
		this.listaTit = listaTit;
	}


	/**
	 * @return the listaExp
	 */
	public ArrayList<Experiencia> getListaExp() {
		return listaExp;
	}


	/**
	 * @param listaExp the listaExp to set
	 */
	public void setListaExp(ArrayList<Experiencia> listaExp) {
		this.listaExp = listaExp;
	}


	/**
	 * @return the listaTec
	 */
	public ArrayList<Integer> getListaTec() {
		return listaTec;
	}


	/**
	 * @param listaTec the listaTec to set
	 */
	public void setListaTec(ArrayList<Integer> listaTec) {
		this.listaTec = listaTec;
	}


	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}


	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	
	
}
