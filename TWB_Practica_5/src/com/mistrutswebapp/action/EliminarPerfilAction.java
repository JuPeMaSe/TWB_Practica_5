package com.mistrutswebapp.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.EliminarPerfilesBean;
import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;
/**
 * Elimina el/los perfiles seleccionados del usuario registrado en el sistema. En caso del administrador puede eliminar los que desee.
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class EliminarPerfilAction extends Action {

	private static Log log = LogFactory.getLog(LoginAction.class);
	/**
	 * Ejecuta las acciones necesarias para eliminar los perfiles seleccionados.
	 * Comprueba además si el usuario tiene al menos un perfil. En caso de no ser así elimina el usuario de la base de datos
	 * @param mapping 
	 * @param form obtiene el javabean
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response
	 * @return Ok
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession();
		LoginBean loginBean = (LoginBean) sesion.getAttribute("loginBean");
		EliminarPerfilesBean  ePB = (EliminarPerfilesBean)form;
		int tamanio=0;
		//Obtiene el número de perfiles seleccionados para eliminar
		if(ePB.getProfileIds()!=null){
			tamanio= ePB.getProfileIds().length;	
		}		
		if(tamanio==0){	//Si no se ha seleccionado ninguno sale sin hacer nada
			return mapping.findForward("Ok");	
		}else{	//Si se ha seleccionado alguno para eliminar
			String perfiles[] = request.getParameterValues("profileIds");
			for (int i =0; i< perfiles.length;i ++){
				int perfil_ID= Integer.parseInt(perfiles[i]);
				//System.out.println("SI hay eliminarPerfilesBean.profilesIDs --> "+ perfil_ID);	
				ModelFacade.eliminarPerfil(perfil_ID);
				if(loginBean.getUser_ID().equals("admin")){
					ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
					listaPerfiles = (ArrayList<Perfil>) ModelFacade.getPerfiles("WHERE user_ID = '"+ loginBean.getUser_ID()+ "' ");
					//System.out.println("Usuario_ID = "+ loginBean.getUser_ID());
					if(listaPerfiles.size()==0){
						//System.out.println("ListaPerfiles.size == "+ listaPerfiles.size() );
						ModelFacade.eliminarUsuario(loginBean.getUser_ID());
					}
				}
			}			
		}
		//System.out.println("In EliminarrPerfilAction --> finalizado");
		if(!loginBean.getUser_ID().equals("admin")){	//Si usuario no es administrador comprueba si tiene más perfiles
			ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
			listaPerfiles = (ArrayList<Perfil>) ModelFacade.getPerfiles("WHERE user_ID = '"+ loginBean.getUser_ID()+ "' ");
			//System.out.println("Usuario_ID = "+ loginBean.getUser_ID());
			if(listaPerfiles.size()==0){ //Si no hay más perfiles, se elimina el usuario de la base de datos y de la session
				//System.out.println("ListaPerfiles.size == "+ listaPerfiles.size() );
				ModelFacade.eliminarUsuario(loginBean.getUser_ID());
				sesion.removeAttribute("perfilBean"); 
		  		sesion.removeAttribute("loginBean");
		  		sesion.removeAttribute("listaPerfiles");
			}
			sesion.setAttribute("listaPerfiles", listaPerfiles);			
		}
		//log.info("In EliminarrPerfilAction --> finalizado");
		return mapping.findForward("Ok");

	}

}
