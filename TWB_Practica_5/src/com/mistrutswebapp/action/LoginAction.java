package com.mistrutswebapp.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


public class LoginAction extends Action
{
	private static Log log = LogFactory.getLog(LoginAction.class);

	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
//		  if (log.isInfoEnabled())
//		  { 
//		   log.info("In LoginAction");
//		  } 
		 LoginBean loginBean = (LoginBean)form;
		 HttpSession session= request.getSession();
		 
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if(loginBean.getUser_ID().equals("admin") && loginBean.getPassword().equals("admin")){
			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("");
		}else{
			//System.out.println("En loginAcvtion 1er else");
			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("WHERE user_ID = '"+loginBean.getUser_ID()+"' AND password = '"+loginBean.getPassword()+"' ");
		}
		if(!listaUsuarios.isEmpty()){
			session.setAttribute("ListaUsuarios",  listaUsuarios);
			ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
			if(loginBean.getUser_ID().equals("admin")){
				listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("");
			}else{
				listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("WHERE user_ID = '"+loginBean.getUser_ID() + "'");
				//System.out.println("En loginAcvtion 2º else");
			}			
			session.setAttribute("listaPerfiles", listaPerfiles);
			session.setAttribute("loginBean", loginBean);	
			 return mapping.findForward("found");
		}else{ 
			//log.info("In LoginAction --> usuario NO encontrado en BD");
			return mapping.findForward("notfound");	
		}	     
	 }
}
