package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

public class BajaAction extends Action{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession sesion = request.getSession();      	
      	LoginBean loginBean = (LoginBean)sesion.getAttribute("loginBean");
      	
      	String user_ID = loginBean.getUser_ID();
      	
      	//Eliminar los perfiles asociados al usuario que se da de baja de la BD
      	ModelFacade.eliminarPerfilesUsuario(user_ID);
      	//Eliminar el usuario de la BD
      	ModelFacade.eliminarUsuario(user_ID);
      	//Desloguear al usuario
      		sesion.removeAttribute("loginBean");     	
		
		return mapping.findForward("sucess");
	}

	

}
