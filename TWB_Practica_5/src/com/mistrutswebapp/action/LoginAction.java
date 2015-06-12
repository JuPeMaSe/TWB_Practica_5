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

/**
 * Permite el acceso a la aplicación como usuario registrado o no.
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class LoginAction extends Action
{
	private static Log log = LogFactory.getLog(LoginAction.class);
	/**
	 * Ejecuta las acciones necesarias para comprobar si el usuario se encuentra registrado en la base de datos.
	 * Si está registrado, o se identifica como el administrador, se establece con alcance session:
	 * listaPerfiles, listaUsuarios y loginBean, que serán usados por el resto de la aplicación.
	 * @param mapping 
	 * @param form obtiene el javabean
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response	 
	 * @return <p>found (Si el usuario está registrado en la base de datos)</p>
	 * <p>notfound (Si el usuario no está registrado)</p>
	 */
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){ 
		 LoginBean loginBean = (LoginBean)form;
		 HttpSession session= request.getSession();
		 
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if(loginBean.getUser_ID().equals("admin") && loginBean.getPassword().equals("admin")){ //Si es el administrador...
			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("");	//Devuelve lista con todos los usuarios registrados
		}else{ //Si no es el administrador devuelve el usuario registrado o una lista vacía si no está registrado
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
