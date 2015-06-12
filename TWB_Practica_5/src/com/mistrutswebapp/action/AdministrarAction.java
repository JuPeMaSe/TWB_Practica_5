package com.mistrutswebapp.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.AdministrarBean;

/**
 * <p>Extiende la clase Action de Struts.  Recupera el objeto javabean AdministrarBean que se
 * obtiene del formulario de checkbox de administarPage.jsp y redirige el flujo de la aplicación
 * a la página de inicio.</p>
 * 
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 * 
 */
public class AdministrarAction extends Action{
	
	/**
	 * Constructor con la llamada super() al constructor de la clase Action
	 */
	public AdministrarAction(){
		super();
	}

	/**
	 * <p>Sobreescribe el método execute de la clase Action, para modificar el alcance o scope
	 * del objeto javabean AdministrarBean, del alcance request a application, y hacer que el javabean
	 * esté disponible para todos los usuarios de la aplicación, y durante todo el tiempo.</p>
	 * <p>Además, redirige el flujo de la aplicación a la página de inicio, una vez completado el 
	 * formulario administrarPage.jsp.</p>
	 * 
	 * @param mapping 
	 * @param form obtiene el javabean AdministrarBean
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response	 
	 * @return mapping redirige el flujo de la aplicación a la página de inicio.
	 * @throws Exception
	 * 
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AdministrarBean adminBeanSession = (AdministrarBean) form;		
		ServletContext context = request.getServletContext();//ServletContext permite acceder a los atributos almacenados con alcance "application"
		
		//El objeto javabean AdministrarBean que obtenemos del formulario de checkboxs de administrarPage.jsp y de scope "request", lo guardamos en scope "application"
		
		context.setAttribute("administrarBean", adminBeanSession);		
		
		return mapping.findForward("home");
	}

	

}

