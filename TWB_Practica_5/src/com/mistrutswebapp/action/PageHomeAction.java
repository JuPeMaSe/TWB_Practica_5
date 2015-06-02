package com.mistrutswebapp.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts.action.* ;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.*;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

public class PageHomeAction extends Action
{
  private static Log log = LogFactory.getLog(PageHomeAction.class);
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    if (log.isInfoEnabled())
    { 
      log.info("In PageHomeAction");	
    }
    
	HttpSession sesion = request.getSession();
	LoginBean loginBean = (LoginBean)sesion.getAttribute("loginBean");
	String opcionSelec ="";
	String uriSelec="";
	uriSelec=request.getRequestURI();
	if(uriSelec.contains("fromhomealta")){
		opcionSelec="alta";
	}else if(uriSelec.contains("fromhomebaja")){
		opcionSelec="baja";
	}else if(uriSelec.contains("fromhomemodificar")){
		opcionSelec="modificar";
	}else if(uriSelec.contains("fromhomeconsulta")){
		opcionSelec="consulta";
	}else if(uriSelec.contains("fromhomeeliminar")){
		opcionSelec="eliminar";
	}else if(uriSelec.contains("fromhomecrear")){
		opcionSelec="crear";
		sesion.removeAttribute("perfilBean");
	}else if(uriSelec.contains("fromhomeadministrar")){
		opcionSelec="administrar";
	}else if(uriSelec.contains("mostrarBD")){
		opcionSelec="mostrarBD";
	}else if(uriSelec.contains("addUsuarios")){
		opcionSelec="addUsuarios";
	}else {
		opcionSelec="desconocido";
	}
	System.out.println("HomePage opcionSelec --> "+opcionSelec);
	sesion.setAttribute("opcionSelec", opcionSelec);

	if (loginBean.getUser_ID() == null){
		log.info("In PageHomeAction: usuario no registrado");
		//
		return mapping.findForward("noRegistrado");
	}else{
//		ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();;
//		listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("");
//		sesion.setAttribute("listaPerfiles", listaPerfiles);
		log.info("In PageHomeAction: usuario registrado: "+loginBean.getUser_ID());
		ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if(loginBean.getUser_ID().equals("admin")){
			listaUsuarios=(ArrayList<Usuario>) ModelFacade.getUsuarios("");
			listaPerfiles=(ArrayList<Perfil>) ModelFacade.getPerfiles("");
			sesion.setAttribute("listaPerfiles",listaPerfiles);
			sesion.setAttribute("listaUsuarios",listaUsuarios);
			return mapping.findForward("admin");
		}else{
			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("WHERE user_ID = '"+loginBean.getUser_ID()+ "'");
			listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("WHERE user_ID = '"+loginBean.getUser_ID()+ "'");
			sesion.setAttribute("listaPerfiles",listaPerfiles);
			sesion.setAttribute("listaUsuarios",listaUsuarios);
			return mapping.findForward("registrado");
		}		
	}	
  }
//  public ActionForward cancelled(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
//	return mapping.findForward("cancel");
//  }
  
}