package com.mistrutswebapp.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.AdministrarBean;

public class AdministrarAction extends Action{
	
	public AdministrarAction(){
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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
