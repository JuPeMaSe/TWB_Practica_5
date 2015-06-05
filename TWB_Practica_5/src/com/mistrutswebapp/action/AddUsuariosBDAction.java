package com.mistrutswebapp.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.model.ModelFacade;
import com.mistrutswebapp.model.Perfil;
import com.mistrutswebapp.model.Tecnologia;
import com.mistrutswebapp.model.Titulacion;
import com.mistrutswebapp.model.Usuario;


/**
 * Clase que añade datos de Usuarios, perfiles, titulaciones, tecnologías y experiencia
 * de ejemplo para poder demostrar la funcionalidad de la aplicación
 * @author Tecnologias Web Grupo 7/2015
 * 
 *
 */
public class AddUsuariosBDAction extends Action {
	 private static Log log = LogFactory.getLog(AddUsuariosBDAction.class);
	HttpSession sesion =null;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		 sesion=request.getSession();
		  Connection con = null;  
         Statement  st   = null;  
         ResultSet  rst1 = null;  
         try{
             // hago el lookup del pool de conexiones
             Context ctx=new InitialContext();
             DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
                
             // pido una conexion
             con=ds.getConnection();
             st  = con.createStatement();  
             
             //Borramos los usuarios que existiesen en la tabla Usuario  
             st.executeUpdate("DELETE FROM Usuario"); 
             st.executeUpdate("DELETE FROM Perfil");
             st.executeUpdate("DELETE FROM Perfil_Tit");
             st.executeUpdate("DELETE FROM Perfil_Tec");
             st.executeUpdate("DELETE FROM Experiencia");
          // Varios usuarios de prueba con sus perfiles 
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
             		"VALUES ('admin', 'admin',  'JP', 'MS','', '','adm')");              
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
               		"VALUES ('jpms', '123',  'Juan Pedro', 'Martinez Sanchez','', '','usu')");
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
                     "VALUES ('lperez', '123',  'Luis', 'Perez Gomez','123456789', 'lperez@ejemplo.com','usu')");
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
                     "VALUES ('agarrido', '123',  'Ana', 'Garrido Almansa','234567890', 'agarrido@ejemplo.com','usu')");
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
                     "VALUES ('ecastedo', '123',  'Estela', 'Castedo Sanz','345678901', 'ecastedo@ejemplo.com','usu')");
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
                     "VALUES ('fsanchez', '123',  'Francisco', 'Sanchez Murrieta','456789012', 'fsanchez@ejemplo.com','usu')");
             st.executeUpdate("INSERT INTO Usuario (user_ID, password, nombre, apellidos, tfno, email, userType) " +
                     "VALUES ('mmanero', '123',  'Miguel', 'Manero Haro','567890123', 'mmanero@ejemplo.com','usu')");
             
             
             
             st.executeUpdate("INSERT INTO Perfil (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                     "VALUES (1,'',  '', 'Plaza de la Villa, 1','Ubeda', 'Jaen','ES', 'jpms', '')");
             st.executeUpdate("INSERT INTO Perfil  (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                     "VALUES (2,'',  '', 'Gran Via','Oviedo', 'Asturias','ES', 'lperez', '')");
             st.executeUpdate("INSERT INTO Perfil  (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                       "VALUES (3,'',  '', 'Avda. las acacias','Valencia', 'Valencia','ES', 'agarrido', '')");
             st.executeUpdate("INSERT INTO Perfil (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                     "VALUES (4,'',  '', 'Calle los lirios','Barcelona', 'Barcelona','ES', 'ecastedo', '')");
             st.executeUpdate("INSERT INTO Perfil (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                     "VALUES (5,'',  '', 'Calle Santander','Vigo', 'Galicia','ES', 'fsanchez', '')");
             st.executeUpdate("INSERT INTO Perfil (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                     "VALUES (6,'',  '', 'Avda. los pinos','Malaga', 'Andalucia','ES', 'mmanero', '')");
             st.executeUpdate("INSERT INTO Perfil (profile_ID, pdf, fotografia, direccion, localidad, provincia, pais, user_ID, reference) " +
                      "VALUES (7,'',  '', 'Calle Corregidor','Granada', 'Andalucia','ES', 'mmanero', '')");
             

             
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(2,1)");
             st.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
           		  "VALUES(3,1)");
             st.executeUpdate("INSERT INTO Experiencia (empresa, cargo, a_Inicio, a_Fin, profile_ID) "+
           		  "VALUES('Dragados','Jefe de obra',1995,2015,1)");       
             
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(3,2)");
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(1,2)");
             st.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
           		  "VALUES(1,2)");
             st.executeUpdate("INSERT INTO Experiencia (empresa, cargo, a_Inicio, a_Fin, profile_ID) "+
           		  "VALUES('AgroQuimica','Director RR.HH',1995,1998,2)");
             
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(2,3)");
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(1,3)");
             st.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
           		  "VALUES(4,3)");

             
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(3,4)");
             st.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
           		  "VALUES(1,4)");
             st.executeUpdate("INSERT INTO Experiencia (empresa, cargo, a_Inicio, a_Fin, profile_ID) "+
           		  "VALUES('UPSA','Jefe Proyecto',1990,2010,4)");
             
             
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(2,6)");
             st.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
           		  "VALUES(4,6)");
             st.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
           		  "VALUES(1,6)");
             st.executeUpdate("INSERT INTO Experiencia (empresa, cargo, a_Inicio, a_Fin, profile_ID) "+
           		  "VALUES('Bankia','Presidente',1960,1980,6)");

            
             ArrayList<Perfil> listaPerfiles= (ArrayList<Perfil>)ModelFacade.getPerfiles("");
             sesion.setAttribute("listaPerfiles",listaPerfiles);
             ArrayList<Usuario> listaUsuarios= (ArrayList<Usuario>)ModelFacade.getUsuarios("");
             sesion.setAttribute("listaUsuarios",listaUsuarios);
               // Liberamos recursos y cerramos la conexion  
              st.close();  
               con.close();  
             
         } catch (Exception ex){  
             log.error("BD no creada por --> "+ ex.getMessage());
             ex.printStackTrace();
         }
		return mapping.findForward("success");
	}

}
