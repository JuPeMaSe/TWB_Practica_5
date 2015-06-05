package com.mistrutswebapp.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

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

import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

public class MostrarBDAction extends Action {
	 private static Log log = LogFactory.getLog(LoginAction.class);
	
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
//		  if (log.isInfoEnabled())
//		  { 
//		   log.info("In MostrarBDAction");
//		  }
          //log.info("In MostrarBDAction --> finalizado");
          HttpSession sesion = request.getSession();
          	ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();;
  			listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("");
  			sesion.setAttribute("listaPerfiles", listaPerfiles);
  			
  			ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
  			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("");
  			sesion.setAttribute("listaUsuarios", listaUsuarios);
          
          return mapping.findForward("Ok");
          
	 }

}
