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
/**
 * <p>Extiende la clase ValidatorForm. Representa un objeto javabean, con los atributos
 * correspondientes a todos los campos de un perfil de un usuario, que se completan en
 * el formulario crearPage.jsp</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class PerfilBean extends ValidatorForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Campo con el ID del perfil del usuario
	 */
	private int profile_ID;
	/**
	 * Identificador del currículum en pdf del perfil
	 */
	private String pdf; //a cambiar el tipo para almacenar pdf
	/**
	 * Currículum del perfil en pdf
	 */
	private FormFile pdf_file;
	/**
	 * Identificador de la fotografía del perfil
	 */
	private String fotografia;//a cambiar el tipo para almacenar jpeg, bmp...
	/**
	 * Fotografía del perfil
	 */
	private FormFile fotografia_file;
	/**
	 * Campo con la dirección del perfil del usuario
	 */
	private String direccion;
	/**
	 * Campo con la localidad del perfil del usuario
	 */
	private String localidad;
	/**
	 * Campo con la provincia del perfil del usuario
	 */
	private String provincia;
	/**
	 * Campo con el país del perfil del usuario
	 */
	private String pais;
	/**
	 * Variable contador con los MeGusta que recibe el perfil
	 */
	private int cont_MeGusta;
	/**
	 * Campo con el ID del usuario propietario del perfil
	 */
	private String user_ID;
	/**
	 * Lista de titulaciones incluidas en el perfil del usuario
	 */
	private ArrayList<Integer> listaTit;
	/**
	 * Lista de tecnologías incluidas en el perfil del usuario
	 */
	private ArrayList<Integer> listaTec;
	/**
	 * Lista de experiencias incluidas en el perfil del usuario
	 */
	private ArrayList<Experiencia> listaExp;
	/**
	 * Campo con el ID de la titulación 
	 */	
	private int titulacion_ID;
	/**
	 * Campo con el nombre de la titulación
	 */
	private String nombre_Tit;
	/**
	 * Lista con las titulaciones del perfil
	 */
	private String titulacion_var[];
	/**
	 * Campo con el ID de la tecnología
	 */
	private int tecnologia_ID;
	/**
	 * Campo con el nombre de la tecnología
	 */
	private String nombre_Tec;
	/**
	 * Lista con las tecnologías del perfil
	 */
	private String tecnologia_var[];
	/**
	 * Campo con el nombre de la empresa de la experiencia
	 */
	private String empresa;
	/**
	 * Campo con el cargo de la experiencia
	 */
	private String cargo;
	/**
	 * Campo con el año de inicio de la experiencia
	 */
	int a_Inicio;
	/**
	 * Campo con el año de finalización de la experiencia
	 */
	int a_Fin;
	/**
	 * Campo con la acción tomada por el usuario al crear su perfil
	 */
	private String accion;
	
	/**
	 * Constructor con el que se inicializan las listas de titulaciones, tecnologías y experiencias
	 */
	public PerfilBean(){
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
	 * @param pdf_file
	 */
	public void setPdf_file(FormFile pdf_file) {
		this.pdf_file = pdf_file;
//		if(pdf_file!=null){
//			this.setPdf(pdf_file.getFileName());
//		}
	}



	/**
	 * @return fotografia
	 */
	public String getFotografia() {
		return fotografia;
	}



	/**
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
	 * @param fotografia_file
	 */
	public void setFotografia_file(FormFile fotografia_file) {
		this.fotografia_file = fotografia_file;
//		if(fotografia_file!=null){
//			this.setFotografia(fotografia_file.getFileName());
//		}
	}



	/**
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}



	/**
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
	 * @param user_ID
	 */
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}



	/**
	 * @return listaTit
	 */
	public ArrayList<Integer> getListaTit() {
		return listaTit;
	}



	/**
	 * @param listaTit
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
	 * @return listaTec
	 */
	public ArrayList<Integer> getListaTec() {
		return listaTec;
	}



	/**
	 * @param listaTec
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
	 * @return listaExp
	 */
	public ArrayList<Experiencia> getListaExp() {
		return listaExp;
	}



	/**
	 * @param listaExp
	 */
	public void setListaExp(ArrayList<Experiencia> listaExp) {
		this.listaExp = listaExp;
	}



	/**
	 * @return titulacion_ID
	 */
	public int getTitulacion_ID() {
		return titulacion_ID;
	}



	/**
	 * @param titulacion_ID
	 */
	public void setTitulacion_ID(int titulacion_ID) {
		this.titulacion_ID = titulacion_ID;
	}



	/**
	 * @return nombre_Tit
	 */
	public String getNombre_Tit() {
		return nombre_Tit;
	}



	/**
	 * @param nombre_Tit
	 */
	public void setNombre_Tit(String nombre_Tit) {
		this.nombre_Tit = nombre_Tit;
	}



	/**
	 * @return titulacion_var
	 */
	public String[] getTitulacion_var() {
		return titulacion_var;
	}



	/**
	 * @param titulacion_var
	 */
	public void setTitulacion_var(String[] titulacion_var) {
		this.titulacion_var = titulacion_var;
	}



	/**
	 * @return tecnologia_ID
	 */
	public int getTecnologia_ID() {
		return tecnologia_ID;
	}



	/**
	 * @param tecnologia_ID
	 */
	public void setTecnologia_ID(int tecnologia_ID) {
		this.tecnologia_ID = tecnologia_ID;
	}



	/**
	 * @return nombre_Tec
	 */
	public String getNombre_Tec() {
		return nombre_Tec;
	}



	/**
	 * @param nombre_Tec
	 */
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
	}



	/**
	 * @return tecnologia_var
	 */
	public String[] getTecnologia_var() {
		return tecnologia_var;
	}



	/**
	 * @param tecnologia_var
	 */
	public void setTecnologia_var(String[] tecnologia_var) {
		this.tecnologia_var = tecnologia_var;
	}



	/**
	 * @return empresa
	 */
	public String getEmpresa() {
		return empresa;
	}



	/**
	 * @param empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	/**
	 * @return cargo
	 */
	public String getCargo() {
		return cargo;
	}



	/**
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	/**
	 * @return a_Inicio
	 */
	public int getA_Inicio() {
		return a_Inicio;
	}



	/**
	 * @param a_Inicio
	 */
	public void setA_Inicio(int a_Inicio) {
		this.a_Inicio = a_Inicio;
	}



	/**
	 * @return a_Fin
	 */
	public int getA_Fin() {
		return a_Fin;
	}



	/**
	 * @param a_Fin
	 */
	public void setA_Fin(int a_Fin) {
		this.a_Fin = a_Fin;
	}



	/**
	 * @return accion
	 */
	public String getAccion() {
		return accion;
	}



	/**
	 * @param accion
	 */
	public void setAccion(String accion) {
		this.accion = accion;
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
