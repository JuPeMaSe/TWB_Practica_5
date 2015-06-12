package com.mistrutswebapp.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.beans.UsuarioBean;
import com.mistrutswebapp.dao.UsuarioDAO;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Usuario;

/**
 * Crea un nuevo usuario y establece el loginBean de este usuario con alcance session.
 * @author Grupo 7 Prácticas Tecnologías Web 2014-2015
 * 
 */
public class AltaAction extends Action {
	 private static Log log = LogFactory.getLog(AltaAction.class);
	 private UsuarioBean usuarioBean;
	  /**
	   * Ejecuta las acciones necesarias para crear un usuario a través de la clase ModelFacade.
	   * Utiliza usuarioBean: es el bean que tiene los datos del usuario provenientes del formulario.
	   * Establece loginBean con los datos de este nuevo usuario y con scope=session
	   * @param mapping 
	   * @param form obtiene el javabean
	   * @param request se refiere al alcance request
	   * @param response se refiere al alcance response
	   * @return succes
	   */
	  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	  {
	    if (log.isInfoEnabled())
	    { 
	      log.info("In AltaAction");	
	    }

	    usuarioBean = (UsuarioBean)form;
		 HttpSession session= request.getSession();
		 session.setAttribute("usuarioBean",usuarioBean);
			ModelFacade.crearUsuario(usuarioBean);
			//compruebaAltaBD(); //método a eliminar en el definitivo. Sólo muestra por log el alta realizada
			log.info("In AltaAction: nuevo usuario registrado: "+usuarioBean.getUser_ID());
			//pasamos la información al loginBean
			LoginBean loginBean = (LoginBean)session.getAttribute("loginBean");
			loginBean.setUser_ID(usuarioBean.getUser_ID());
			loginBean.setPassword(usuarioBean.getPassword());
			return mapping.findForward("succes");
//		}
		  
	  }

//	  //método a eliminar. Lo uso como prueba para comprobar el alta en la BD
//	 private void compruebaAltaBD() {
//		 try{
//             // hago el lookup del pool de conexiones
//             Context ctx=new InitialContext();
//             DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
//                
//             // pido una conexion
//             Connection con=ds.getConnection();
//			 // log.info("In AltaAction despues de connection--> cerrada? =="+con.isClosed());
//	         Statement st  = con.createStatement(); 
//	         //log.info("In AltaAction despues de statement--> st cerrado? =="+st.isClosed());
//			// Mostramos por pantalla todos los usuarios de la tabla  
//	         ResultSet rst1 = st.executeQuery("SELECT * FROM Usuario");
//	        // log.info("In AltaAction despues de ResultSet");
//	         while (rst1.next()){  
//	             log.info("In AltaAction --> "+ rst1.getString("user_ID") + " " + rst1.getString("password") + " " + rst1.getString("nombre") );  
//	         }  
//	         st.close();  
//	         con.close();  
//	     } catch (Exception ex){  
//	         log.error("BD no creada por --> "+ ex.getMessage());
//	     }
//	}
//
}
