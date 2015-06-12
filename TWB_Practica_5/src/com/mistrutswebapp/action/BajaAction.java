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
/**
 * <p>Extiende la clase Action de Struts. Recupera el objeto javabean LoginBean del alcance
 * scope, para identificar al usuario que ha iniciado el proceso de baja, y eliminarlo de la
 * base de datos del sitema, y terminar su sesión.</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */

public class BajaAction extends Action{

	/**
	 * <p>Sobreescribe el método execute de la clase Action, para acceder al objeto javabean
	 * LoginBean almacenado con alcance session, e indentificar al usuario que desea darse de baja.</p>
	 * <p>Además redirige el flujo de la aplicación a la página bajaConfirmada.jsp.</p>
	 * 
	 * @param mapping
	 * @param form 
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response	 
	 * @return mapping redirige el flujo de la aplicación a la página bajaConfirmada.jsp.
	 * @throws Exception
	 * 
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
