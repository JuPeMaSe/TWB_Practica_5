package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ResultadoConsultaBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

public class ResultadoConsultaAction extends Action {
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	  {
		 int intFinalProfile_ID=0;
		 ResultadoConsultaBean rcb = (ResultadoConsultaBean)form;
		 String strClave = rcb.getMostrar();
		 String strMeGusta =rcb.getAccion();
		 if(strClave!=null){
			 intFinalProfile_ID= Integer.parseInt(strClave.substring(16));
		 }else if(strMeGusta!=null){
			 intFinalProfile_ID= Integer.parseInt(strMeGusta.substring(10));
			 ModelFacade.addMegusta(intFinalProfile_ID);
		 }
		 
		 HttpSession sesion = request.getSession();
		 ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
		 listaPerfiles = (ArrayList<Perfil>) ModelFacade.getPerfiles(" WHERE profile_ID = " + intFinalProfile_ID);
		 sesion.setAttribute("listaPerfiles",listaPerfiles);
		 ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		 listaUsuarios= (ArrayList<Usuario>)ModelFacade.getUsuarios(" WHERE user_ID = '"+listaPerfiles.get(0).getUser_ID()+"' ");
		 sesion.setAttribute("listaUsuarios",listaUsuarios);
		 
		 return mapping.findForward("success");
	  }
}
