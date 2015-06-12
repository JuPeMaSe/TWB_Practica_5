package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
/**
 * Muestra los datos finales del perfil que se está creando o modificando y que serán guardados en la base de datos.
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 *
 */
public class MostrarPerfilCreadoAction extends Action {
	/**
	 * Obtiene los datos del perfilBean y los envia a ModelFacade.
	 * Según se trate de modificación o creación de nuevo perfil, selecciona un método diferente en ModelFacade.
	 * Una vez terminado pone listaPerfiles con visibilidad session y elimina de la session perfilBean.
	 * @param mapping
	 * @param form obtiene el javabean EliminarUsuariosBean
	 * @param request se refiere al alcance request
	 * @param response se refiere al alcance response	
	 * @return succes 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sesion = request.getSession();
		PerfilBean perfilBean;
		perfilBean = (PerfilBean) sesion.getAttribute("perfilBean");		
		//System.out.println("En MostrarPerfilCreado: perfilBean.user_ID--> "+perfilBean.getUser_ID());		
		ArrayList<Integer> listaTit= new ArrayList<Integer>();		
		listaTit= perfilBean.getListaTit();
//		int t= listaTit.size();
//		for(int i=0; i<t; i++){			
//			System.out.println("En MostrarPerfilCreado: perfilBean.listaTitulacion.item --> "+listaTit.get(i));		
//		}
		ArrayList<Integer> listaTec = new ArrayList<Integer>();
		listaTec=perfilBean.getListaTec();
//		int z = listaTec.size();
//		for(int i=0;i<z;i++){
//			System.out.println("En MostrarPerfilCreado: perfilBean.listaTecnologia.item --> "+listaTec.get(i));
//		}					
		if(sesion.getAttribute("opcionSelec").equals("crear")||sesion.getAttribute("opcionSelec").equals("alta")){
			//System.out.println("En MostrarPerfilCreadoAction seleccionado --> " +sesion.getAttribute("opcionSelec"));
			ModelFacade.crearPerfil(perfilBean);
		}else if(sesion.getAttribute("opcionSelec").equals("modificar")){
			//System.out.println("En MostrarPerfilCreadoAction seleccionado --> " +sesion.getAttribute("opcionSelec"));
			ModelFacade.modificarPerfil(perfilBean);
		}
		ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();;
		listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("WHERE user_ID = '"+perfilBean.getUser_ID() + "'");
		sesion.setAttribute("listaPerfiles", listaPerfiles);
		sesion.removeAttribute("perfilBean");
		
		return mapping.findForward("succes");
	}
}
