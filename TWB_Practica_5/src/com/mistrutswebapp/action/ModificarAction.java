package com.mistrutswebapp.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ModificarBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

public class ModificarAction extends Action {
	
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	  {
		 int intFinalProfile_ID = 0;
		 ModificarBean modificarBean = (ModificarBean)form;
		 HttpSession sesion = request.getSession();
		 sesion.removeAttribute("perfilBean");
		 PerfilBean perfilBean = new PerfilBean();//(PerfilBean) request.getSession().getAttribute("perfilBean") ;
		// PerfilBean perfilBean=(PerfilBean) request.getSession().getAttribute("perfilBean") ;
		String strClave = modificarBean.getAccion();
		if(strClave.equals("Salir")){
			return mapping.findForward("exit");
			
		}else{
			 intFinalProfile_ID= Integer.parseInt(strClave.substring(18));
//				System.out.println("perfil ID = "+intFinalProfile_ID);
			 ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
			 listaPerfiles = (ArrayList<Perfil>) ModelFacade.getPerfiles(" WHERE profile_ID = " + intFinalProfile_ID);
			 sesion.setAttribute("listaPerfiles",listaPerfiles);
			 
			 //pasamos las propiedades del Perfil al PerfilBean
			try {
				PropertyUtils.copyProperties(perfilBean,  listaPerfiles.get(0));
				sesion.setAttribute("perfilBean", perfilBean);
			
//				 System.out.print("ModificarAction.PerfilBean --> "+ perfilBean.getProfile_ID());
//				 System.out.print(" \\ "+ perfilBean.getPais());
//				 System.out.print(" \\ "+ perfilBean.getProvincia());
//				 System.out.print(" \\ "+ perfilBean.getLocalidad());
//				 System.out.print(" \\ "+ perfilBean.getDireccion());
//				 System.out.print(" \\ "+ perfilBean.getPdf());
//				 System.out.print(" \\ "+ perfilBean.getFotografia());
//				// System.out.print(" \\ "+ perfilBean.getListaTit().toString());
//				 System.out.println(" \\ "+ perfilBean.getUser_ID());
				
				
			} catch (IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				// TODO Auto-generated catch block
				System.out.println("ModificarAction - Error al pasar las propiedades --> " +e.getMessage());
				e.printStackTrace();
			}
			ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
			listaUsuarios= (ArrayList<Usuario>)ModelFacade.getUsuarios(" WHERE user_ID = '"+listaPerfiles.get(0).getUser_ID()+"' ");
			sesion.setAttribute("listaUsuarios",listaUsuarios);
		 }
		 
		 return mapping.findForward("success");
	  }
}
