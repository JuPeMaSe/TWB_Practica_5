package com.mistrutswebapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mistrutswebapp.action.PageHomeAction;
import com.mistrutswebapp.model.Usuario;

public class UsuarioDAO {
	 private static Log log = LogFactory.getLog(PageHomeAction.class);
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private ResultSet results = null;
	private static final String DATASOURCE_NAME = "java:comp/env/jdbc/ConexionHSQLDS";
	private static final String INSERT_STATEMENT = "INSERT INTO Usuario " +
			"(user_ID,password,nombre,apellidos, tfno,email, userType)" +
			" VALUES (?,?,?,?,?,?,?)";
	
	public void crearUsuario(Usuario usuario){
		//log.info("In UsuarioDAO -->crearUsuario(usuario)");
		try{
			getConnection();
			prepStatement= connection.prepareStatement(INSERT_STATEMENT);
			prepStatement.setString(1, usuario.getUser_ID());
			prepStatement.setString(2, usuario.getPassword());
			prepStatement.setString(3, usuario.getNombre());
			prepStatement.setString(4, usuario.getApellidos());
			prepStatement.setString(5,usuario.getTfno());
			prepStatement.setString(6, usuario.getEmail());
			prepStatement.setString(7, usuario.getUserType());
			//log.info("In UsuarioDAO -->crearUsuario(usuario)-->try");
			prepStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cleanUp();
		}
	}
	
	public Collection<Usuario> leerUsuarios(String whereClause){
		//log.info("In UsuarioDAO -->leerUsuarios(clause)");
		Collection<Usuario> usuarios = new ArrayList<Usuario>();
		try{
			getConnection();
			Statement st = connection.createStatement();
			//log.info("In UsuarioDAO -->leerUsuarios(clause)-->try --> st = "+st.getFetchSize());
			ResultSet results = st.executeQuery("SELECT * FROM Usuario " + whereClause);
			String strUser_ID = null;
			String strPassword= null;
			String strNombre= null;
			String strApellidos= null;
			String strTfno= null;
			String strEmail= null;
			String strUserType= null;
			PerfilDAO perfilDAO = new PerfilDAO();
			Usuario usuario = null;
			//log.info("In UsuarioDAO -->leerUsuarios(clause)-->try --> results = "+results.getFetchSize());			
			while (results.next()){
				//log.info("In UsuarioDAO -->leerUsuarios(clause)-->try-->dentro while");
				strUser_ID = results.getString("user_ID");
				strPassword = results.getString("password");
				strNombre= results.getString("nombre");
				strApellidos = results.getString("apellidos");
				strTfno=results.getString("tfno");
				strEmail=results.getString("email");
				strUserType = results.getString("userType");
				usuario = new Usuario();
				usuario.setUser_ID(strUser_ID);
				usuario.setPassword(strPassword);
				usuario.setNombre(strNombre);
				usuario.setApellidos(strApellidos);
				usuario.setTfno(strTfno);
				usuario.setEmail(strEmail);
				usuario.setUserType(strUserType);
				if(!strUserType.equals("adm")){
					usuario.setPerfiles(perfilDAO.leerPerfiles("where user_ID = '"+strUser_ID+"'"));	
				}				
				usuarios.add(usuario);
				System.out.println("leido usuario -->"+strUser_ID);
			}//while
		}catch(SQLException e){
			log.error("error --> "+e.getMessage());
		}finally{
		   cleanUp();
		}
		return usuarios;
	}
	
	public void eliminarUsuario(String usuario_ID){
		try{
			getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Usuario WHERE user_ID ='" + usuario_ID + "'" );			
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			cleanUp();			
		}
	}

	
	
	
	private void getConnection(){
		//log.info("In UsuarioDAO -->getConnection()");
		if(connection == null){
			try{
				Context initialContext = new InitialContext();
			    DataSource ds = (DataSource)initialContext.lookup(DATASOURCE_NAME);
			    connection = ds.getConnection();
			}catch(NamingException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	 }
	
	
	private void cleanUp(){
		 // nos aseguramos de cerrar results, statements , connections....
		 if(results != null){
			try{
				results.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 results = null;
		 }
		 if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 statement = null;
		 }
		 if(prepStatement != null){
			try{
				prepStatement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			prepStatement = null;
		 }
		 if(connection != null){
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			connection = null;
		 }
	}
}
