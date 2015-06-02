package com.mistrutswebapp.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.EliminarUsuariosBean;
import com.mistrutswebapp.model.ModelFacade;

public class EliminarUsuariosAction extends Action{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		EliminarUsuariosBean eliminarUsuariosBean = (EliminarUsuariosBean)form;
		
		String[] listaUsuariosEliminar = eliminarUsuariosBean.getUserIds();
		int length = listaUsuariosEliminar.length;//Longitud del array listaUsuariosEliminar, con el numero de usuarios a eliminar
		
		ServletContext context = request.getServletContext();//ServletContext permite acceder a los atributos almacenados con alcance "application"		
				
		 try{
			 
	            for(int i = 0; i < length ; i++){               

//			 		System.out.println("Se quiere eliminar a :" + listaUsuariosEliminar[i].toString());
	            	String user_ID = new String(); 
	            	user_ID = (String)listaUsuariosEliminar[i];
	            	user_ID = user_ID.replaceAll("^\"|\"$", "");//Elimina las comillas "" al comienzo y final del String user_ID.  De otra forma, busca "agarrido" en lugar de agarrido
	          		
//	              	System.out.println("Usuario eliminado: " + user_ID);
	                //Eliminar los perfiles asociados al usuario que se da de baja de la BD
	              	ModelFacade.eliminarPerfilesUsuario(user_ID);
	                //Eliminar el usuario de la BD
	              	ModelFacade.eliminarUsuario(user_ID);
	              	
	              //El array listaUsuariosEliminar que obtenemos del formulario de checkboxs de eliminarUsuarioPage.jsp y de scope "request", lo guardamos en scope "application"
	        		//context.setAttribute("usuariosEliminados", listaUsuariosEliminar);
	              	
	            }

	        }catch(IndexOutOfBoundsException ignore){}
		 request.setAttribute("usuariosEliminados", listaUsuariosEliminar);
		 
	        return mapping.findForward("success");

	    }
		
		

	
	

	

}
