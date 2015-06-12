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
/**
 * Redirecciona a la siguiente p�gina en funci�n de la selecci�n efectuada en la p�gina de resultados de la consulta
 * 
 * @author Grupo 7 Pr�cticas Tecnolog�as Web 2014-2015
 *
 */
public class ResultadoConsultaAction extends Action {
	/**
	 * Seg�n se haya seleecionado en la p�gina, ejecuta una acci�n diferente.
	 * Si se seleccion� Mostrar Perfil, pasa a la siguiente p�gina mostrando el perfil seleccionado.
	 * Si se seleccion� Me Gusta, incrementa el contador de Me gusta en uno y muestra el perfil.
	 * Para ambos casos actualiza listaPerfiles con el perfil seleccionado.
	 * @param mapping
	 * @param form obtiene el javabean EliminarUsuariosBean	
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response		
	 * @return success (Muestra el perfil)
	 */
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		 int intFinalProfile_ID=0;
		 ResultadoConsultaBean rcb = (ResultadoConsultaBean)form;
		 String strClave = "";
		strClave = rcb.getMostrar();
		 String strMeGusta ="";
		 strMeGusta = rcb.getAccion();
		 if(strClave!=null){
			 intFinalProfile_ID= Integer.parseInt(strClave.substring(16));						 
		 }else if(strMeGusta!=null){
			 intFinalProfile_ID= Integer.parseInt(strMeGusta.substring(10));
			 ModelFacade.addMegusta(intFinalProfile_ID);		 }
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
