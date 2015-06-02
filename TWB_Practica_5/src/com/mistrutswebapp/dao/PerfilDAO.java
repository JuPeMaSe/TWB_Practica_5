package com.mistrutswebapp.dao;

import java.sql.Blob;
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

import com.mistrutswebapp.model.Experiencia;
import com.mistrutswebapp.model.Perfil;

public class PerfilDAO {
	private Connection connection = null;
	private Statement statement = null;
	private Statement stTit =null;
	private Statement stTec=null;
	private Statement stExp = null;
	private ResultSet results = null;
	private ResultSet resTit= null;
	private ResultSet resTec= null;
	private ResultSet resExp= null;
	private PreparedStatement prepStatement = null;
	private String strQuery="";
	boolean bolPerfil=false;
	boolean bolTitulos=false;
	boolean bolTecnologias= false;
	boolean bolExperiencias=false;
	
	private static final String DATASOURCE_NAME = "java:comp/env/jdbc/ConexionHSQLDS";
	private static final String INSERT_STATEMENT_PERFIL = "INSERT INTO Perfil " +
			"(direccion, localidad, provincia, pais, user_ID, pdf,fotografia,cont_MeGusta,reference)"+ 
			" VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static final String INSERT_STATEMENT_PERFIL_TIT = "INSERT INTO Perfil_Tit " +
			"(titulacion_ID,profile_ID) VALUES (?,?)";
	
	private static final String INSERT_STATEMENT_PERFIL_TEC = "INSERT INTO Perfil_Tec " +
			"(tecnologia_ID, profile_ID) VALUES (?,?)";
	
	private static final String INSERT_STATEMENT_EXPERIENCIA = "INSERT INTO Experiencia " +
			"(empresa, cargo, a_Inicio, a_Fin, profile_ID) VALUES (?,?,?,?,?)";
	

	private void getConnection(){
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
	  
	 public void crearPerfil(Perfil perfil){
		 try{
			getConnection();
		    prepStatement = connection.prepareStatement(INSERT_STATEMENT_PERFIL);
		    prepStatement.setString(1, perfil.getDireccion());
		    prepStatement.setString(2, perfil.getLocalidad());
		    prepStatement.setString(3, perfil.getProvincia());
		    prepStatement.setString(4, perfil.getPais());
		    prepStatement.setString(5, perfil.getUser_ID());
		    prepStatement.setString(6, perfil.getPdf());
		    prepStatement.setString(7, perfil.getFotografia());		   
		    prepStatement.setInt(8, perfil.getCont_MeGusta());
		    prepStatement.setString(9, perfil.getReference());		    
		    prepStatement.executeUpdate();
		    prepStatement.close();
		    prepStatement = null;
		    connection.close();
		    connection = null;

		 }catch(SQLException e){
			 System.out.println("error crearPerfil:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		 }finally{
			cleanUp();
		 }
	}
	 
	 public int getProfile_ID(Perfil perfil){
		 int intProfile_ID=0;
		 getConnection();
		    try {
				statement = connection.createStatement();			
			    results= statement.executeQuery("Select * FROM Perfil WHERE reference = '"+perfil.getReference()+"'");
//			    System.out.println("QUERY =Select * from PERFIL where reference='"+perfil.getReference()+"'" );
//			    System.out.println("results tamaño= "+results.getFetchSize());			   
			    while(results.next()){
				    if(results.getString("reference")!= null){
				    	intProfile_ID = results.getInt("profile_ID");				    	
				    }
			    }
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 return intProfile_ID;
	 }
	 
	 public void addTitulacion(int profile_ID, Perfil perfil){
		 ArrayList<Integer> listaTit = perfil.getListaTit();
		// System.out.println("En perfilDAO: addTitulacion --> listaTit.size == " + listaTit.size());
		 try {
			 getConnection();
			prepStatement= connection.prepareStatement(INSERT_STATEMENT_PERFIL_TIT);
			for (int i=0; i<listaTit.size();i++){
				prepStatement.setInt(1, listaTit.get(i));
				prepStatement.setInt(2,profile_ID);
				prepStatement.executeUpdate();
			}
			prepStatement.close();
			prepStatement=null;
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			 System.out.println("error addTitulacion:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		}finally{
			cleanUp();
		}	 
	 }
	 
	 public void addTecnologia(int profile_ID, Perfil perfil){
		 ArrayList<Integer> listaTec = perfil.getListaTec();
		 try {
			 getConnection();
			prepStatement= connection.prepareStatement(INSERT_STATEMENT_PERFIL_TEC);
			for (int i=0; i<listaTec.size();i++){
				prepStatement.setInt(1, listaTec.get(i));
				prepStatement.setInt(2,profile_ID);
				prepStatement.executeUpdate();
			}
			prepStatement.close();
			prepStatement=null;
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			 System.out.println("error addTitulacion:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		}finally{
			cleanUp();
		}	 
	 }
	 
	 public void addExperiencia(int profile_ID, Experiencia experiencia){
		try {
			getConnection();
			prepStatement = connection.prepareStatement(INSERT_STATEMENT_EXPERIENCIA);
			prepStatement.setString(1,experiencia.getEmpresa());
			prepStatement.setString(2,experiencia.getCargo());
			prepStatement.setInt(3, experiencia.getA_Inicio());
			prepStatement.setInt(4,experiencia.getA_Fin());
			prepStatement.setInt(5,profile_ID);
			prepStatement.executeUpdate();
			prepStatement.close();
			prepStatement=null;
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cleanUp();
		}
		 
		 
	 }


	 public Collection<Perfil> leerPerfiles(String whereClause){
		   Collection<Perfil> perfiles = new ArrayList<Perfil>();
		   try{
			   getConnection();
			   stTit = connection.createStatement();//Se podría eliminar sin afectar al funcionamiento ????? Parece que no
			   stTec = connection.createStatement();//Idem
			   stExp = connection.createStatement();//Idem
			   statement = connection.createStatement();
			   results = statement.executeQuery("SELECT * FROM Perfil " + whereClause);
//			   System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil " + whereClause);
			   int profile_ID;
			   String pdf;
			   String fotografia;
			   String direccion;
			   String localidad;
			   String provincia;
			   String pais;
			   int cont_MeGusta;
			   String user_ID;
			   String reference;
			   ArrayList<Integer> listaTit;
			   ArrayList<Integer> listaTec;
			   ArrayList<Experiencia> listaExp;
			   
			   Perfil perfil = null;
			   while(results.next()){
				  	 profile_ID = results.getInt("profile_ID"); 
				   	 pdf= results.getString("pdf");
				   	 fotografia=results.getString("fotografia");
				   	 direccion=results.getString("direccion");
				   	 localidad=results.getString("localidad");
				   	 provincia=results.getString("provincia");
				   	 pais=results.getString("pais");
				   	 cont_MeGusta = results.getInt("cont_MeGusta");
				   	 user_ID=results.getString("user_ID");
				   	 reference=results.getString("reference");
				   	 listaTit= new ArrayList<Integer>();			   	 
					 resTit = stTit.executeQuery("SELECT * FROM Perfil_Tit where profile_ID ='" +profile_ID+"'");
				   	 while (resTit.next()){
						 listaTit.add(resTit.getInt("titulacion_ID"));
					 }
					 listaTec= new ArrayList<Integer>();
					 resTec = stTec.executeQuery("SELECT * FROM Perfil_Tec where profile_ID ='" +profile_ID+"'");
					 while (resTec.next()){
						 listaTec.add(resTec.getInt("tecnologia_ID"));
					 }
					 listaExp= new ArrayList<Experiencia>();			   	 
					 resExp = stExp.executeQuery("SELECT * FROM Experiencia where profile_ID ='" +profile_ID+"'");
					 while (resExp.next()){
						 Experiencia exp = new Experiencia();
						 exp.setEmpresa(resExp.getString("empresa"));
						 exp.setCargo(resExp.getString("cargo"));
						 exp.setA_Fin(resExp.getInt("a_Fin"));
						 exp.setA_Inicio(resExp.getInt("a_Inicio"));
						 exp.setExp_ID(resExp.getInt("exp_ID"));
						 exp.setProfile_ID(resExp.getInt("profile_ID"));
						 listaExp.add(exp);
					 }					 
				   	 perfil=new Perfil();
				   	 perfil.setProfile_ID(profile_ID);
				   	 perfil.setPdf(pdf);
				   	 perfil.setFotografia(fotografia);
				   	 perfil.setDireccion(direccion);
				   	 perfil.setLocalidad(localidad);
				   	 perfil.setProvincia(provincia);
				   	 perfil.setPais(pais);
				   	 perfil.setCont_MeGusta(cont_MeGusta);
				   	 perfil.setUser_ID(user_ID);
				   	 perfil.setReference(reference);
				   	 perfil.setListaTit(listaTit);
				   	 perfil.setListaTec(listaTec);
				   	 perfil.setListaExp(listaExp);			   	 
				   	 
				   	 perfiles.add(perfil);
//				   	System.out.println("leido perfil -->"+profile_ID);
			 }
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }finally{
	    	cleanUp();
	    }
	    return perfiles;
	 }
	 
	 
	 /**
	  * Modificación método de obtener todos los perfiles que cumplen alguna condición
	  * para Titulación, Tecnología y Experiencia
	  */
	 
	 public Collection<Perfil> leerPerfiles(String strPerfil, String strTitu, String strTecn, String strExpe){
		   Collection<Perfil> perfiles = new ArrayList<Perfil>();
		   int profile_ID;
		   String pdf;
		   String fotografia;
		   String direccion;
		   String localidad;
		   String provincia;
		   String pais;
		   int cont_MeGusta;
		   String user_ID;
		   String reference;
		   ArrayList<Integer> listaTit;
		   ArrayList<Integer> listaTec;
		   ArrayList<Experiencia> listaExp;
		  ArrayList<Integer> listaPerfiles=new ArrayList<Integer>();
		  ArrayList<Integer> listaAux=new ArrayList<Integer>();		   
		   Perfil perfil = null;
		   try{
			   getConnection();
			   strQuery="";
			   stTit = connection.createStatement();//Se podría eliminar sin afectar al funcionamiento ????? Parece que no
			   stTec = connection.createStatement();//Idem
			   stExp = connection.createStatement();//Idem
			   statement = connection.createStatement();
			  // results = statement.executeQuery("SELECT * FROM Perfil " + strPerfil);
			   //System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil " + strPerfil);			  
			   if(strPerfil.equals("") && strTitu.equals("") && strTecn.equals("") && strExpe.equals("")){
				   return null;
			   }
			   if(!strTitu.isEmpty()){
				   resTit = stTit.executeQuery("SELECT * FROM Perfil_Tit "+strTitu);
//					 System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil_Tit " +strTitu);
					 while (resTit.next()){
						 listaPerfiles.add(resTit.getInt("profile_ID"));
					 }				   
			   }
			   if(!strTecn.isEmpty()){
				   if(listaPerfiles.size()==0 && !strTitu.isEmpty()){
						 return null;
					 }
				   
				   resTec = stTec.executeQuery("SELECT * FROM Perfil_Tec "+ strTecn);
//					 System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil_Tec " +strTecn);
					
					 if(listaPerfiles.size()==0){
						 while(resTec.next()){
							 listaPerfiles.add(resTec.getInt("profile_ID"));
						 }
					 }else{
						 boolean encontrado = false;
						while(resTec.next()){
							 listaAux.add(resTec.getInt("profile_ID"));
						 }
						for(int j=0; j<listaPerfiles.size();j++){
							 encontrado = false;
							 for (int i=0;i<listaAux.size();i++){
								 if(listaPerfiles.get(j)==listaAux.get(i)){
									 encontrado =true;
								 }
							 }
							 if(encontrado==false){
								 listaPerfiles.remove(j);
							 }
						 }
					 }
			   }
				  

			   
			   
			   if(!strExpe.isEmpty()){
				   if(listaPerfiles.size()==0 && (!strTitu.isEmpty() || !strTecn.isEmpty())){
					   return null;
				   }
				   resExp = stExp.executeQuery("SELECT * FROM Experiencia ");// WHERE diferencia >= "+ strTecn);
//					 System.out.println("SELECT * FROM Experiencia ");
					 
					 if(listaPerfiles.size()==0){
						 while(resExp.next()){
							 if(resExp.getInt("a_Fin")-resExp.getInt("a_Inicio")>= Integer.parseInt(strExpe)){
								 listaPerfiles.add(resExp.getInt("profile_ID"));
							 }
							 
						 }
					 }else{
						 boolean encontrado = false;
						while(resExp.next()){
							if((resExp.getInt("a_Fin")-resExp.getInt("a_Inicio"))>= Integer.parseInt(strExpe)){
								listaAux.add(resExp.getInt("profile_ID"));
							}
						 }
						for(int j=0; j<listaPerfiles.size();j++){
							 encontrado = false;
							 for (int i=0;i<listaAux.size();i++){
								 if(listaPerfiles.get(j)==listaAux.get(i)){
									 encontrado =true;
								 }
							 }
							 if(encontrado==false){
								 listaPerfiles.remove(j);
							 }
						 }
					 }				   
			   }
			   
			   
			   if(!strPerfil.equals("") && (!strTitu.isEmpty()||!strTecn.isEmpty()||!strExpe.isEmpty())){
				   	if(listaPerfiles.size()==0){
					   return null;
					 }else{
						 results = statement.executeQuery("SELECT * FROM Perfil " + strPerfil);
//						   System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil " + strPerfil);
						 boolean encontrado = false;
						 listaAux= new ArrayList<Integer>();
						 while(results.next()){
							 listaAux.add(results.getInt("profile_ID"));
						 }
						 for(int j=0; j<listaPerfiles.size();j++){
							 encontrado = false;
							 for (int i=0;i<listaAux.size();i++){
								 if(listaPerfiles.get(j)==listaAux.get(i)){
									 encontrado =true;
								 }
							 }
							 if(encontrado==false){
								 listaPerfiles.remove(j);
							 }
							 bolPerfil=true;
						 } //for
					 }//else		   
			   }else if(!strPerfil.equals("") && strTitu.isEmpty() && strTecn.isEmpty() && strExpe.isEmpty()){
				   results = statement.executeQuery("SELECT * FROM Perfil " + strPerfil);
//				   System.out.println("En PerfilDAO.leerPerfiles. Claúsula --> "+ "SELECT * FROM Perfil " + strPerfil);
				    while(results.next()){
				    	listaPerfiles.add(results.getInt("profile_ID"));
					}
				   
			   }
			
			   
			  
			   if(listaPerfiles.size()==0){
				   return null;
			   }else{
				   for(int i=0;i<listaPerfiles.size();i++){
//					   System.out.println("listaPerfiles --> "+listaPerfiles.get(i));
					   results= statement.executeQuery("SELECT * FROM Perfil where profile_ID = "+listaPerfiles.get(i));
			   
					   while(results.next()){						 
						  	 profile_ID = results.getInt("profile_ID"); 
						   	 pdf= results.getString("pdf");
						   	 fotografia=results.getString("fotografia");						   	
						   	 direccion=results.getString("direccion");
						   	 localidad=results.getString("localidad");
						   	 provincia=results.getString("provincia");
						   	 pais=results.getString("pais");
						   	 cont_MeGusta = results.getInt("cont_MeGusta");
						   	 user_ID=results.getString("user_ID");
						   	 reference=results.getString("reference");						   	 				   	 
						   	 listaTit= new ArrayList<Integer>();			   	 
							 resTit = stTit.executeQuery("SELECT * FROM Perfil_Tit where profile_ID ='" +profile_ID+"'");
						   	 while (resTit.next()){
								 listaTit.add(resTit.getInt("titulacion_ID"));
							 }
						   	listaTec= new ArrayList<Integer>();			   	 
							 resTec = stTec.executeQuery("SELECT * FROM Perfil_Tec where profile_ID ='" +profile_ID+"'");
						   	 while (resTec.next()){
								 listaTec.add(resTec.getInt("tecnologia_ID"));
							 }
						   	listaExp= new ArrayList<Experiencia>();			   	 
							resExp = stExp.executeQuery("SELECT * FROM Experiencia where profile_ID ='" +profile_ID+"'");
							while (resExp.next()){
								 Experiencia exp = new Experiencia();
								 exp.setEmpresa(resExp.getString("empresa"));
								 exp.setCargo(resExp.getString("cargo"));
								 exp.setA_Fin(resExp.getInt("a_Fin"));
								 exp.setA_Inicio(resExp.getInt("a_Inicio"));
								 exp.setExp_ID(resExp.getInt("exp_ID"));
								 exp.setProfile_ID(resExp.getInt("profile_ID"));
								 listaExp.add(exp);
							 }
						   	 perfil=new Perfil();
						   	 perfil.setProfile_ID(profile_ID);
						   	 perfil.setPdf(pdf);
						   	 perfil.setFotografia(fotografia);
						   	 perfil.setDireccion(direccion);
						   	 perfil.setLocalidad(localidad);
						   	 perfil.setProvincia(provincia);
						   	 perfil.setPais(pais);
						   	 perfil.setCont_MeGusta(cont_MeGusta);
						   	 perfil.setUser_ID(user_ID);
						   	 perfil.setReference(reference);
						   	 perfil.setListaTit(listaTit);
						   	 perfil.setListaTec(listaTec);
						   	 perfil.setListaExp(listaExp);
						   	 perfiles.add(perfil);
//						   	System.out.println("leido perfil -->"+profile_ID);
					   	}//while
				   }//for				   
			 }//if
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }finally{
	    	cleanUp();
	    }
	    return perfiles;
	 }
	 
	 
	 public void eliminarPerfilesUsuario(String usuario_ID){		 
		 try{
			 getConnection();
			 statement=connection.createStatement();
			 results=statement.executeQuery("SELECT * FROM Perfil WHERE user_ID = '"+usuario_ID+"'");
//			 System.out.println("Query eliminarPerfiles --> SELECT * FROM Perfil WHERE user_ID = '"+usuario_ID+"'");
			 statement.executeUpdate("DELETE FROM Perfil WHERE user_ID='" + usuario_ID + "'");
//			 while(results.next()){
//				 int intPerfil = results.getInt("profile_ID");
//				 System.out.println("profile_ID = "+intPerfil);
//				 eliminarPerfil_Tit(intPerfil);
//				 eliminarPerfil_Tec(intPerfil);
//				 eliminarExperiencia(intPerfil);
//			 }
			 //eliminarPerfil(results.getInt("profile_ID"));
			 
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{
			 cleanUp();
		 }
	 }

	 
	 
	 public void eliminarPerfil(int profile_ID){
		 
		 try{
			getConnection();
		    prepStatement = connection.prepareStatement("DELETE FROM Perfil WHERE profile_ID = "+ profile_ID);
		    prepStatement.executeUpdate();
		 }catch(SQLException e){
			 System.out.println("error eliminarPerfil:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		 }finally{
			cleanUp();
		 }
	}

	 public void eliminarPerfil_Tit(int profile_ID){
		 try{
			getConnection();
			prepStatement = connection.prepareStatement("DELETE FROM Perfil_Tit WHERE profile_ID = "+ profile_ID);
		     prepStatement.executeUpdate();
		 }catch(SQLException e){
			 System.out.println("error eliminarPerfil_Tit:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		 }finally{
			//cleanUp();
		 }
	}
	 public void eliminarPerfil_Tec(int profile_ID){
		 try{
			getConnection();			
			prepStatement = connection.prepareStatement("DELETE FROM Perfil_Tec WHERE profile_ID = "+ profile_ID);
		    prepStatement.executeUpdate();
		 }catch(SQLException e){
			 System.out.println("error eliminarPerfil_Tec:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		 }finally{
			//cleanUp();
		 }
	}
	 public void eliminarExperiencia(int profile_ID){
		 try{
			getConnection();
			prepStatement = connection.prepareStatement("DELETE FROM Experiencia WHERE profile_ID = "+ profile_ID);
		     prepStatement.executeUpdate();
		 }catch(SQLException e){
			 System.out.println("error eliminarExperiencia:SQL Exception -->"+e.getMessage());
			 e.printStackTrace();
		 }finally{
			cleanUp();
		 }
	}
	 
	 public void addMegusta(int intProfile_ID){
		 try{
			 getConnection();
			 statement=connection.createStatement();
			 ResultSet rs = statement.executeQuery("SELECT * from PERFIL WHERE profile_ID = " + intProfile_ID);
			 rs.next();
			 int contador=rs.getInt("cont_MeGusta");
			 contador+=1;
			 statement.executeUpdate("UPDATE Perfil SET cont_MeGusta = "+ contador +" WHERE profile_ID = " + intProfile_ID);
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{
			 cleanUp();
		 }
	 }
	 
	 
	 public void modificarPerfil(Perfil perfil){
		 getConnection();
		 try {
			statement = connection.createStatement();
			String strEdit="UPDATE Perfil SET ";
			strEdit+=" pais = '"+perfil.getPais()+"',";
			strEdit+=" provincia = '"+perfil.getProvincia()+"',";
			strEdit+=" localidad = '"+perfil.getLocalidad()+"',";
			strEdit+=" direccion = '"+perfil.getDireccion()+"',";
			strEdit+=" fotografia = '"+perfil.getFotografia()+"',";
			strEdit+=" pdf = '"+perfil.getPdf()+"'";
			strEdit+= " WHERE profile_ID ="+perfil.getProfile_ID();
//			System.out.println("Query para modificarPerfil--> "+strEdit);
			statement.executeUpdate(strEdit);
			statement.executeUpdate("DELETE FROM Perfil_Tit WHERE profile_ID="+perfil.getProfile_ID());
			if(perfil.getListaTit().isEmpty()){
				//statement.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
		        //   		  "VALUES(0,"+perfil.getProfile_ID()+")");
			}else{
				ArrayList<Integer> listaTitu = new ArrayList<Integer>();
				listaTitu= perfil.getListaTit();
				for (int i =0; i<listaTitu.size();i++){
					  statement.executeUpdate("INSERT INTO Perfil_Tit (titulacion_ID, profile_ID)"+
			           		  "VALUES("+listaTitu.get(i)+","+perfil.getProfile_ID()+")");
				}
			}
			statement.executeUpdate("DELETE FROM Perfil_Tec WHERE profile_ID="+perfil.getProfile_ID());
			if(perfil.getListaTec().isEmpty()){
				//statement.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
		        //   		  "VALUES(0,"+perfil.getProfile_ID()+")");
			}else{
				ArrayList<Integer> listaTecn = new ArrayList<Integer>();
				listaTecn= perfil.getListaTec();
				for (int i =0; i<listaTecn.size();i++){
					  statement.executeUpdate("INSERT INTO Perfil_Tec (tecnologia_ID, profile_ID)"+
			           		  "VALUES("+listaTecn.get(i)+","+perfil.getProfile_ID()+")");
				}
			}
			statement.executeUpdate("DELETE FROM Experiencia WHERE profile_ID="+perfil.getProfile_ID());
			if(perfil.getListaExp().isEmpty()){
				System.out.println("Modificar perfil listaExp. is Empty()");
			}else{
				ArrayList<Experiencia> listaExpe = new ArrayList<Experiencia>();
				listaExpe= perfil.getListaExp();
				if(listaExpe!=null){
					for (int i =0; i<listaExpe.size();i++){						
//						String strQuery ="UPDATE Experiencia SET  ";
//						strQuery += " empresa = '"+ listaExpe.get(i).getEmpresa()+"',";
//						strQuery += " cargo = '"+listaExpe.get(i).getCargo()+"',";
//						strQuery += " a_Inicio = "+listaExpe.get(i).getA_Inicio()+",";
//						strQuery += " a_Fin = "+listaExpe.get(i).getA_Fin() +",";
//						strQuery += " profile_ID = "+perfil.getProfile_ID();
//						strQuery += " WHERE exp_ID = "+listaExpe.get(i).getExp_ID();
//						System.out.println("En modificarPerfil.Expe StrQuery -->  "+ strQuery);
//						 statement.executeUpdate(strQuery);
						String strQuery ="INSERT INTO Experiencia (empresa, cargo, a_Inicio, a_Fin, profile_ID) "+
				           		 "VALUES('"+listaExpe.get(i).getEmpresa()+"','"+listaExpe.get(i).getCargo()+"',"+
								listaExpe.get(i).getA_Inicio()+","+
								listaExpe.get(i).getA_Fin()+ ","+
								perfil.getProfile_ID()+")";
						System.out.println("En modificarPerfil StrQuery -->  "+ strQuery);
						 statement.executeUpdate(strQuery);
					}	
				}
				
			}
		} catch (SQLException e) {
			System.out.println("Error SQL al modificar Perfil --> "+e.getMessage());
			e.printStackTrace();
		}
		 
		 
	 }
	 
	 public String getUser_ID(int profile_ID) {
		 String strUser_ID="";
		 getConnection();		 
			try {
				statement = connection.createStatement();
				results= statement.executeQuery("Select * FROM Perfil WHERE profile_ID = "+profile_ID);
				while(results.next()){
					strUser_ID=results.getString("user_ID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
			return strUser_ID;
		}

	 
	 private void cleanUp(){
		 // nos aseguramos de cerrar results, statements , connections...
		 if(results != null){
			try{
				results.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 results = null;
		 }
		 if(resTit != null){
				try{
					resTit.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 resTit = null;
			 }
		 if(resTec != null){
				try{
					resTec.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 resTec = null;
			 }
		 if(resExp != null){
				try{
					resExp.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 resExp = null;
			 }
		 if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			 statement = null;
		 }
		 if(stTit != null){
				try{
					stTit.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 stTit = null;
		}
		 if(stTec != null){
				try{
					stTec.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				 stTec = null;
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
