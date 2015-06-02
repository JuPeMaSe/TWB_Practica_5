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

public class EliminarPerfilAction extends Action {

	private static Log log = LogFactory.getLog(LoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) {
		
		if (log.isInfoEnabled()) {
			log.info("In EliminarPerfilAction");
		}
		HttpSession sesion = request.getSession();
		PerfilBean perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
		LoginBean loginBean = (LoginBean) sesion.getAttribute("loginBean");
		EliminarPerfilesBean  ePB = (EliminarPerfilesBean)form;
		int tamanio=0;
		if(ePB.getProfileIds()!=null){
			tamanio= ePB.getProfileIds().length;	
		}
		
		if(tamanio==0){
			return mapping.findForward("Ok");	
		}else{
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
		if(!loginBean.getUser_ID().equals("admin")){
			ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
			listaPerfiles = (ArrayList<Perfil>) ModelFacade.getPerfiles("WHERE user_ID = '"+ loginBean.getUser_ID()+ "' ");
			//System.out.println("Usuario_ID = "+ loginBean.getUser_ID());
			if(listaPerfiles.size()==0){
				//System.out.println("ListaPerfiles.size == "+ listaPerfiles.size() );
				ModelFacade.eliminarUsuario(loginBean.getUser_ID());
				sesion.removeAttribute("perfilBean"); 
		  		sesion.removeAttribute("loginBean");
		  		sesion.removeAttribute("listaPerfiles");
			}
			sesion.setAttribute("listaPerfiles", listaPerfiles);

			
		}
		log.info("In EliminarrPerfilAction --> finalizado");
		return mapping.findForward("Ok");

	}

}
