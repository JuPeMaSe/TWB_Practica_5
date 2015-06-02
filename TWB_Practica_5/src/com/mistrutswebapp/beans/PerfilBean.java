package com.mistrutswebapp.beans;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.mistrutswebapp.model.Experiencia;

public class PerfilBean extends ValidatorForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
	private ArrayList<Integer> listaTit;
	private ArrayList<Integer> listaTec;
	private ArrayList<Experiencia> listaExp;
	
	
	private int titulacion_ID;
	private String nombre_Tit;
	private String titulacion_var[];
	
	private int tecnologia_ID;
	private String nombre_Tec;
	private String tecnologia_var[];
	
	private String empresa;
	private String cargo;
	int a_Inicio;
	int a_Fin;
	
	private String accion;
	
	
	public PerfilBean(){
		super();
		listaTit=new ArrayList<Integer>();
		listaTec=new ArrayList<Integer>();
		listaExp=new ArrayList<Experiencia>();
	}
	
	

	/**
	 * @return the profile_ID
	 */
	public int getProfile_ID() {
		return profile_ID;
	}



	/**
	 * @param profile_ID the profile_ID to set
	 */
	public void setProfile_ID(int profile_ID) {
		this.profile_ID = profile_ID;
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
//		if(pdf_file!=null){
//			this.setPdf(pdf_file.getFileName());
//		}
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
//		if(fotografia_file!=null){
//			this.setFotografia(fotografia_file.getFileName());
//		}
	}



	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}



	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}



	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}



	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}



	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}



	/**
	 * @return the cont_MeGusta
	 */
	public int getCont_MeGusta() {
		return cont_MeGusta;
	}



	/**
	 * @param cont_MeGusta the cont_MeGusta to set
	 */
	public void setCont_MeGusta(int cont_MeGusta) {
		this.cont_MeGusta = cont_MeGusta;
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
	 * 
	 * @param Tit
	 */
	public void addTit(int Tit){
		listaTit.add(Tit);
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
	 * 
	 * @param Tec
	 */
	public void addTec(int Tec){
		listaTec.add(Tec);
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
	 * @return the titulacion_ID
	 */
	public int getTitulacion_ID() {
		return titulacion_ID;
	}



	/**
	 * @param titulacion_ID the titulacion_ID to set
	 */
	public void setTitulacion_ID(int titulacion_ID) {
		this.titulacion_ID = titulacion_ID;
	}



	/**
	 * @return the nombre_Tit
	 */
	public String getNombre_Tit() {
		return nombre_Tit;
	}



	/**
	 * @param nombre_Tit the nombre_Tit to set
	 */
	public void setNombre_Tit(String nombre_Tit) {
		this.nombre_Tit = nombre_Tit;
	}



	/**
	 * @return the titulacion_var
	 */
	public String[] getTitulacion_var() {
		return titulacion_var;
	}



	/**
	 * @param titulacion_var the titulacion_var to set
	 */
	public void setTitulacion_var(String[] titulacion_var) {
		this.titulacion_var = titulacion_var;
	}



	/**
	 * @return the tecnologia_ID
	 */
	public int getTecnologia_ID() {
		return tecnologia_ID;
	}



	/**
	 * @param tecnologia_ID the tecnologia_ID to set
	 */
	public void setTecnologia_ID(int tecnologia_ID) {
		this.tecnologia_ID = tecnologia_ID;
	}



	/**
	 * @return the nombre_Tec
	 */
	public String getNombre_Tec() {
		return nombre_Tec;
	}



	/**
	 * @param nombre_Tec the nombre_Tec to set
	 */
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
	}



	/**
	 * @return the tecnologia_var
	 */
	public String[] getTecnologia_var() {
		return tecnologia_var;
	}



	/**
	 * @param tecnologia_var the tecnologia_var to set
	 */
	public void setTecnologia_var(String[] tecnologia_var) {
		this.tecnologia_var = tecnologia_var;
	}



	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}



	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}



	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	/**
	 * @return the a_Inicio
	 */
	public int getA_Inicio() {
		return a_Inicio;
	}



	/**
	 * @param a_Inicio the a_Inicio to set
	 */
	public void setA_Inicio(int a_Inicio) {
		this.a_Inicio = a_Inicio;
	}



	/**
	 * @return the a_Fin
	 */
	public int getA_Fin() {
		return a_Fin;
	}



	/**
	 * @param a_Fin the a_Fin to set
	 */
	public void setA_Fin(int a_Fin) {
		this.a_Fin = a_Fin;
	}



	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}



	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}



	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(!empresa.isEmpty()){
			if ((a_Inicio==0)|| (a_Inicio<1900) ||(a_Inicio>2016)){
				errors.add("a_Inicio", new ActionMessage("error.a_Inicio"));				
			}else if((a_Fin ==0)|| (a_Fin<1900) ||(a_Fin>2016)){
				errors.add("a_Fin", new ActionMessage("error.a_Fin"));
			}else if((a_Fin-a_Inicio) < 0){
				errors.add("a_Fin", new ActionMessage("error.a_Fin.menor"));
			}
		}
		
		return errors;
	}


}
