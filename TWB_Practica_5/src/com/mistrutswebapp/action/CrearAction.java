package com.mistrutswebapp.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.model.Experiencia;

/**
 * Crea un perfil añadiendo los datos introducidos en el formulario.
 * Utiliza perfilBean para guardar dichos datos 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class CrearAction extends Action {
	private static Log log = LogFactory.getLog(CrearAction.class);
	private PerfilBean perfilBean;
	private LoginBean loginBean;


	/**
	 * Ejecuta las acciones adecuadas para almacenar en perfilBean los datos introducidos en el formulario 
	 * @param mapping 
	 * @param form obtiene el javabean
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response
	 * @return <p>refresh (Refresca la página con las titulaciones, tecnologías, experiencias, ficheros pdf o fotografías introducidas)</p>
	 * <p>succes (Envía a la página de confirmación de los datos introducidos en el formulario)</p>
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		perfilBean = (PerfilBean)form;
		HttpSession sesion = request.getSession();
		loginBean = (LoginBean)sesion.getAttribute("loginBean");
		String accion = perfilBean.getAccion();
		//Elimina una titulación del perfil y refresca la página
		if(accion.substring(0,13).equals("Eliminar Titu")){
			int intClave = Integer.parseInt(accion.substring(20));
			ArrayList<Integer>listaProv = new ArrayList<Integer>();
			listaProv=perfilBean.getListaTit();				 
			for (int i=0;i<listaProv.size();i++){
				if(listaProv.get(i)==intClave){						
					listaProv.remove(i);
				}
			}
			perfilBean.setListaTit(listaProv);
			return mapping.findForward("refresh");				 
		}
		
		//Añade una titulación al perfil y refresca la página
		if(accion.substring(0,13).equals("Nueva Titulac")){
			int Titu = perfilBean.getTitulacion_ID();
			if (Titu!=0){
				perfilBean.addTit(Titu);
			}
//			System.out.println("pulsado Nueva Titu--> " +perfilBean.getTitulacion_ID());
			return mapping.findForward("refresh");
		}
		//Elimina una tecnología del perfil y refresca la página
		if(accion.substring(0,13).equals("Eliminar Tecn")){			 
			 int intClave = Integer.parseInt(accion.substring(20));
			 ArrayList<Integer>listaProv = new ArrayList<Integer>();
			 listaProv=perfilBean.getListaTec();
			 for (int i=0;i<perfilBean.getListaTec().size();i++){
				// System.out.println("eliminar Tecnologia for " + i);
				 if(perfilBean.getListaTec().get(i)==intClave){
					 listaProv.remove(i);
				 }
			 }
			 perfilBean.setListaTec(listaProv);
			 return mapping.findForward("refresh");
		 }
		//Añade una tecnología al perfil y refresca la página
		if(accion.substring(0,13).equals("Nueva Tecnolo")){
			 int Tecn = perfilBean.getTecnologia_ID();
			 if(Tecn!=0){
				 perfilBean.addTec(Tecn);
			 }
//			 System.out.println("pulsado Nueva Titu--> " +perfilBean.getTitulacion_ID());
			 return mapping.findForward("refresh");
		}
		//Elimina una experiencia del perfil y refresca la página
		if(accion.substring(0,13).equals("Eliminar Expe")){
			int intClave = Integer.parseInt(accion.substring(20));
			 ArrayList<Experiencia>listaProv = new ArrayList<Experiencia>();
			 listaProv=perfilBean.getListaExp();
			 //System.out.println("eliminar experiencia --> litaProv.size = "+perfilBean.getListaExp().size());
			 for (int i=0;i<perfilBean.getListaExp().size();i++){
				 if(perfilBean.getListaExp().get(i).getExp_ID()==intClave){
					 listaProv.remove(i);
				 }
			 }			 
			 perfilBean.setListaExp(listaProv);
			 return mapping.findForward("refresh");
		 }
		//Añade una experiencia al perfil y refresca la página 
		if(accion.substring(0,13).equals("Nueva Experie")){
			if(!perfilBean.getEmpresa().isEmpty()){
				 String empresa = perfilBean.getEmpresa();
				 String cargo = perfilBean.getCargo();
				 int a_Inicio = perfilBean.getA_Inicio();
				 int a_Fin = perfilBean.getA_Fin();
				 Experiencia expe = new Experiencia();
				 expe.setEmpresa(empresa);
				 expe.setCargo(cargo);
				 expe.setA_Inicio(a_Inicio);
				 expe.setA_Fin(a_Fin);
				 expe.setProfile_ID(perfilBean.getProfile_ID());
				 expe.setExp_ID(perfilBean.getListaExp().size()+1);
				 perfilBean.getListaExp().add(expe);
				// System.out.println("pulsado Nueva Exp size()--> "+ perfilBean.getListaExp().size());	
				 //perfilBean.resetExper();
			}			 
			 return mapping.findForward("refresh");
		}
		//Elimina una foto del perfil y refresca la página
		if(accion.substring(0,13).equals("Eliminar Foto")){			
			perfilBean.setFotografia("");
			 return mapping.findForward("refresh");
		 }
		
		//Añade una foto al perfil y refresca la página
		if(accion.substring(0,13).equals("Nueva Fotogra")){
			//Me guarda el archivo en la dirección que el servlet tiene definida en su contexto
			 FileOutputStream outputStream = null;
			 FormFile formFileFoto = null;
			 String path="";
			 formFileFoto = perfilBean.getFotografia_file();
			 if(formFileFoto != null && !formFileFoto.getFileName().equals("")) {  
				  try { 
				     path = getRepositoryPath() +  formFileFoto.getFileName();
					 // System.out.println("File will be uploaded to this path: " + path);
					  perfilBean.setFotografia(formFileFoto.getFileName());
					  outputStream = new FileOutputStream(new File(path));
					  outputStream.write(formFileFoto.getFileData());				  
				  } catch(Exception exception) {
					  System.out.println("En CrearAction - error --> " + exception.getMessage());
				  }finally {
				      if (outputStream != null) {
				          try {
							outputStream.close();
				          } catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
				          }
				      }
				  }
				 // System.out.println("The file " + formFileFoto.getFileName() + " was uploaded successfully.");
			 }
			 return mapping.findForward("refresh");
		}
		//Elimina un archivo pdf del perfil y refresca la página
		if(accion.substring(0,13).equals("Eliminar Arch")){			
			perfilBean.setPdf("");
			 return mapping.findForward("refresh");
		 }
		//Añade un archivo pdf y refresca la página
		if(accion.substring(0,13).equals("Nuevo Archivo")){
			//Me guarda el archivo en la dirección que el servlet tiene definida en su contexto
			 FileOutputStream outputStream = null;
			 FormFile formFilePdf = null;
			 String path="";
			 formFilePdf = perfilBean.getPdf_file();
			 if(formFilePdf != null && !formFilePdf.getFileName().equals("")) {  
				  try { 
				     path = getRepositoryPath() +  formFilePdf.getFileName();
					 // System.out.println("File will be uploaded to this path: " + path);
					  perfilBean.setPdf(formFilePdf.getFileName());
				     outputStream = new FileOutputStream(new File(path));
				     outputStream.write(formFilePdf.getFileData());
				  
				  } catch(Exception exception) {
				   System.out.println("En CrearAction - error --> "+ exception.getMessage());
				  }finally {
				      if (outputStream != null) {
				          try {
							outputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				      }
				  }
				  //System.out.println("The file " + formFilePdf.getFileName() + " was uploaded successfully.");
			 }	
			 return mapping.findForward("refresh");
		}
		
		//Asignaciones a perfilBean de determinados valores
		if(perfilBean.getFotografia()==null){
			perfilBean.setFotografia("");
		}
		if(perfilBean.getPdf()==null){
			perfilBean.setPdf("");
		}
		 perfilBean.setUser_ID(loginBean.getUser_ID());
		 //Asigna este perfilBean a la session
		 sesion.setAttribute("perfilBean", perfilBean);
		return mapping.findForward("succes");
	}
	/**
	 * Devuelve la ruta del contexto actual de la página
	 * @return contextoActual
	 */
	private String getRepositoryPath(){
			return getServlet().getServletContext().getRealPath("")+"/";
	}
//		
}
