package com.mistrutswebapp.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Usuario;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


public class LoginAction extends Action
{
	private static Log log = LogFactory.getLog(LoginAction.class);

	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
		  if (log.isInfoEnabled())
		  { 
		   log.info("In LoginAction");
		  } 
		 LoginBean loginBean = (LoginBean)form;
		 HttpSession session= request.getSession();
		 
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if(loginBean.getUser_ID().equals("admin") && loginBean.getPassword().equals("admin")){
			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("");
		}else{
			System.out.println("En loginAcvtion 1er else");
			listaUsuarios = (ArrayList<Usuario>)ModelFacade.getUsuarios("WHERE user_ID = '"+loginBean.getUser_ID()+"' AND password = '"+loginBean.getPassword()+"' ");
		}
		if(!listaUsuarios.isEmpty()){
			session.setAttribute("ListaUsuarios",  listaUsuarios);
			ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
			if(loginBean.getUser_ID().equals("admin")){
				listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("");
			}else{
				listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("WHERE user_ID = '"+loginBean.getUser_ID() + "'");
				System.out.println("En loginAcvtion 2º else");
			}			
			session.setAttribute("listaPerfiles", listaPerfiles);
			session.setAttribute("loginBean", loginBean);	
			 return mapping.findForward("found");
		}else{ 
			log.info("In LoginAction --> usuario NO encontrado en BD");
			return mapping.findForward("notfound");	
		}
		
		
		 
		 
//		 Connection con=null;
//		 Statement  st   = null;  
//	     String     sql  = null;  
//	     ResultSet  rst1 = null;  
//	     String id = loginBean.getUser_ID();
//	     String contras = loginBean.getPassword();
//	     try{
//	       // hago el lookup del pool de conexiones
//	    	 Context ctx=new InitialContext();
//	    	 //log.info("In LoginAction --> context ctx");
//	         DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
//	         //log.info("In LoginAction --> DataSource ds");
//	         // pido una conexion
//	         con=ds.getConnection();
//	         st= con.createStatement();
//	         //log.info("In LoginAction --> st createstatemen");
//	         sql = "SELECT * from Usuario";
//	         rst1 = st.executeQuery(sql);
//	         while (rst1.next()){
//	        	 log.info("In LoginAction retocado --> "+ rst1.getString("User_ID") + " " + rst1.getString("Password") + " " + rst1.getString("Nombre") );
//	        	 if((rst1.getString("User_ID")).equals(id) && rst1.getString("Password").equals(contras))
//	        	 {
//	        		 log.info("In LoginAction --> usuario encontrado en BD");
//	        		 ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
//	        		 listaUsuarios =(ArrayList<Usuario>) ModelFacade.getUsuarios("WHERE user_ID = '"+id+"'");
//	        		 ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
//	       			listaPerfiles = (ArrayList<Perfil>)ModelFacade.getPerfiles("WHERE user_ID = '"+id + "'");
//	       			session.setAttribute("listaPerfiles", listaPerfiles);
//	        		 session.setAttribute("loginBean", loginBean);
//	        		 return mapping.findForward("found");
//	        	 }
//	         }
//	         // la uso
//	         //System.out.println(con);
//	         //log.info("In LoginAction despues de connection");
//	         // la devuelvo en el finally (OJO!)
//	         //return mapping.findForward("ok");
//	     } catch (SQLException ex) {
//	      	 log.error("Error SQL (" + ex.getErrorCode() + "): " + ex.getMessage());
//	     } catch (NamingException ex) {
//	       	 log.error("Error al intentar obtener el DataSource: " + ex.getMessage());
//	     }catch(Exception ex){
//	    	 ex.printStackTrace();
//	    	 //throw new RuntimeException(ex);
//	     }finally{
//	    	 try{
//	    		 if( con!=null ){
//	    			 // devuelvo la conexion al pool
//	    			 con.close();
//	    			 log.info("Conexion cerrada = " + con.isClosed());
//	    		 }
//	    	 }catch(Exception ex){
//	    		 ex.printStackTrace();
//	    		 throw new RuntimeException(ex);
//	    	}
//	    }
//	    log.info("In LoginAction --> usuario NO encontrado en BD");
//	    return mapping.findForward("notfound");
	     
	 }
}
