package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ConsultaBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

public class ConsultaAction extends Action{
	 private static Log log = LogFactory.getLog(ConsultaAction.class);
	 private ConsultaBean cB;
	 private String cond = " WHERE ";
	 private String strPerfil = "";
	 private String strUser="";
	 private String strTecn="";
	 private String strTitu="";
	 private String strExpe="";
	 
	 
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		 HttpSession sesion = request.getSession();
	     ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
	     ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		 cond = " WHERE ";
		 strPerfil="";
		 strUser="";
		 strTitu="";
		 strTecn="";
		 strExpe="";
//		 if (log.isInfoEnabled()){
//	    	log.info("In ConsultaAction");
//	    }	
		 cB = (ConsultaBean)form;
		 if(cB.isChkPais()){
			 strPerfil+= cond + " Pais = '"+cB.getPais()+"' ";
			 cond = " AND ";
		 }
		 if(cB.isChkProvincia()){
			 strPerfil+=  cond + " provincia = '"+cB.getProvincia()+"' ";
			 cond = " AND ";
		 }
		 if (cB.isChkLocalidad()){
			 strPerfil+= cond + " localidad = '"+cB.getLocalidad()+"' ";
			 cond = " AND ";
		 }
		 if(cB.isChkTitulacion()){
			 strTitu=  " WHERE titulacion_ID = "+cB.getTitu_ID();
			 //cond = " AND ";
		 }
		 if(cB.isChkTecnologia()){
			 strTecn=  " WHERE tecnologia_ID = "+cB.getTecn_ID();
			// cond = " AND ";
		 }
		 if(cB.isChkExperiencia()){
			 strExpe= cB.getA_Experiencia();
			// cond = " AND ";
		 }
 		//listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles(strPerfil);
		 listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles(strPerfil, strTitu, strTecn, strExpe);
 		if(listaPerfiles==null || listaPerfiles.isEmpty()){
 			strUser="";
 			sesion.setAttribute("listaPerfiles", listaPerfiles);
 			//return mapping.findForward("notfound");
 		}else{
 			sesion.setAttribute("listaPerfiles", listaPerfiles);
 			strUser= " WHERE user_ID = '" +listaPerfiles.get(0).getUser_ID()+ "' ";
// 			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios(strUser);
// 			sesion.setAttribute("listaUsuarios", listaUsuarios);
 		//	return mapping.findForward("succes");
 		}
 		
 		return mapping.findForward("succes");
	 }
}
