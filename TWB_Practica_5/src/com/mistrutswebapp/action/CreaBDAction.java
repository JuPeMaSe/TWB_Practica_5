package com.mistrutswebapp.action;

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

import java.sql.*;  
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Crea la estructura de la base de datos vac�a.
 * Es la primera acci�n que se realiza al lanzar la aplicaci�n
 * @author Grupo 7 Pr�cticas Tecnolog�as Web 2014-2015
 *
 */
public class CreaBDAction extends Action {
	 private static Log log = LogFactory.getLog(LoginAction.class);
	 HttpSession sesion =null;
	 
	 /**
	  *Ejecuta las acciones necesarias para crear las distintas tablas de la base de datos.
	  *Tambi�n inicializa listaPaises, listaTitulaciones, y listaTecnolog�as con unos valores predeterminados
	  *que ser�n posteriormente utilizados en la aplicaci�n
	  *@param mapping 
	  * @param form obtiene el javabean
	  * @param request se refiere al alcance request
	  * @param response se refiere al alcance response
	  * @return Ok
	  */
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
//		  if (log.isInfoEnabled())
//		  { 
//		   log.info("In CreaBDAction");
//		  }
		  sesion=request.getSession();
		  Connection con = null;  
          Statement  st   = null;  
          String     sql  = null;  
          ResultSet  rst1 = null;  
        
//          // Nos conectamos a la base de datos creandola en caso de que no exista   
//          conn = DriverManager.getConnection("jdbc:hsqldb:mem:memoriadb");  
//          // Creamos la tabla sobre la que trabajaremos  +
          try{
              // hago el lookup del pool de conexiones
              Context ctx=new InitialContext();
              DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
                 
              // pido una conexion
              con=ds.getConnection();
              st  = con.createStatement();  
              //Creamos la tabla Usuario
              sql = "CREATE TABLE Usuario(" +
              		"user_ID VARCHAR(30) NOT NULL PRIMARY KEY," +
              		"	password VARCHAR(30)," +
              		"	nombre VARCHAR(50)," +
              		"	apellidos VARCHAR(60)," +
              	//	"	fe_Nac DATE," +	//da problemas con el tipo de dato
              		"	tfno CHAR(9)," +
              		"	email VARCHAR(60)," +
              		"	userType VARCHAR(3));";
              st.executeUpdate(sql);
              //Creamos la tabla Perfil
              sql="CREATE TABLE Perfil(" +
              		//"	profile_ID INTEGER NOT NULL PRIMARY KEY," +
              		//"	profile_ID SMALLINT NOT NULL AUTO_INCREMENT," +
            		"   profile_ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1),"+
              		"	pdf VARCHAR(100)," +
            		" 	pdf_file BLOB,"+
              		"	fotografia VARCHAR(200)," +  
              		"	fotografia_file BLOB,"+
              		"	direccion VARCHAR(40)," +
              		"	localidad VARCHAR(40)," +
              		"	provincia VARCHAR(40)," +
              		"	pais VARCHAR(40)," +
              		"	cont_MeGusta INTEGER," +
              		"	user_ID VARCHAR(30)," +
              		"	reference VARCHAR(40)" +
              		//"   FOREIGN KEY (user_ID) REFERENCES Usuario(user_ID)"+
              		");";
              st.executeUpdate(sql);
             // Creamos la table Tecnologia
             sql = "CREATE TABLE Tecnologia(	" +
              		"tecnologia_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	nombre_Tec VARCHAR(50)" +
              		");";
              st.executeUpdate(sql);
              //Creamos la tabla Perfil-Tec
             sql= "CREATE TABLE Perfil_Tec(" +
              		"	tecnologia_ID INTEGER," +
              		"	profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //Creamos la tabla Titulacion
              sql="CREATE TABLE Titulacion(" +
              		"	titulacion_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	nombre_Tit VARCHAR(100)" +
              		");";
              st.executeUpdate(sql);
              //Creamos la tabla Perfil_Tit
              sql="CREATE TABLE Perfil_Tit(" +
              		"	titulacion_ID INTEGER," +
              		"	profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Perfil_Tit");
              //Creamos la tabla Experiencia
              sql="CREATE TABLE Experiencia(" +
              		"	exp_ID INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1)," +
              		"	empresa VARCHAR(60)," +
              		"	cargo VARCHAR(50)," +
              		"	a_Inicio INTEGER," +
              		"	a_Fin INTEGER," +
              		"	profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
           
              
              //Introducimos varias titulaciones
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (0,'Sin titulaci�n')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (1,'Grado en Administraci�n y Direcci�n de Empresas')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (2,'Grado en Arquitectura T�cnica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (3,'Grado en Bellas Artes')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (4,'Grado en Biotecnolog�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (5,'Grado en Ciencia y Tecnolog�a de los Alimentos')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (6,'Grado en Ciencias Ambientales')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (7,'Grado en Ciencias de la Actividad F�sica y del Deporte')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (8,'Grado en Derecho')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (9,'Grado en Econom�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (10,'Grado en Enfermer�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (11,'Grado en Estudios Cl�sicos')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (12,'Grado en Estudios en Arquitectura')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (13,'Grado en Estudios Ingleses')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (14,'Grado en Filolog�a Hisp�nica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (15,'Grado en Filosof�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (16,'Grado en Finanzas y Contabilidad')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (17,'Grado en F�sica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (18,'Grado en Fisioterapia')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (19,'Grado en Geograf�a y Ordenaci�n del Territorio')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (20,'Grado en Geolog�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (21,'Grado en Gesti�n y Administraci�n P�blica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (22,'Grado en Historia')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (23,'Grado en Historia del Arte')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (24,'Grado en Informaci�n y Documentaci�n')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (25,'Grado en Ingenier�a Agroalimentaria y del Medio Rural')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (26,'Grado en Ingenier�a Civil')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (27,'Grado en Ingenier�a de Organizaci�n Industrial')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (28,'Grado en Ingenier�a de Tecnolog�as Industriales')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (29,'Grado en Ingenier�a de Tecnolog�as y Servicios de Teleco')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (30,'Grado en Ingenier�a El�ctrica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (31,'Grado en Ingenier�a Electr�nica y Autom�tica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (32,'Grado en Ingenier�a en Dise�o Industrial y Desarrollo')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (33,'Grado en Ingenier�a Inform�tica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (34,'Grado en Ingenier�a Mec�nica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (35,'Grado en Ingenier�a Mecatr�nica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (36,'Grado en Ingenier�a Qu�mica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (37,'Grado en Lenguas Modernas')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (38,'Grado en Magisterio en Educaci�n Infantil')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (39,'Grado en Magisterio en Educaci�n Primaria')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (40,'Grado en Marketing e Investigaci�n de Mercados')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (41,'Grado en Matem�ticas')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (42,'Grado en Medicina')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (43,'Grado en Nutrici�n Humana y Diet�tica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (44,'Grado en Odontolog�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (45,'Grado en Optica y Optometr�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (46,'Grado en PCEO Grado en Derecho - Grado en Administraci�n')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (47,'Grado en Periodismo')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (48,'Grado en Psicolog�a')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (49,'Grado en Qu�mica')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (50,'Grado en Relaciones Laborales y Recursos Humanos')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (51,'Grado en Terapia Ocupacional')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (52,'Grado en Trabajo Social')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (53,'Grado en Turismo')");
              st.executeUpdate("INSERT INTO Titulacion (titulacion_ID, nombre_Tit) VALUES (54,'Grado en Veterinaria')");
              
              //Introducimos varias tecnolog�as
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                		"VALUES (0,'N/A')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                  	"VALUES (1,'Bases de datos: SQL')");
                st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                    	"VALUES (2,'Bases de datos: mySQL')");
                st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                      "VALUES (3,'Bases de datos: HyperSQL')");
                st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                    	"VALUES (4,'C++')");
                st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                    	"VALUES (5,'C##')");                
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
              		"VALUES (6,'Java2')");             
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                    "VALUES (7,'Spring')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                    "VALUES (8,'Struts')");
              st.executeUpdate("INSERT INTO Tecnologia (tecnologia_ID, nombre_Tec) " +
                  	"VALUES (9,'Visual Basic')");
              
              
              //Creamos la listaTitulaciones con scope=session
              rst1 = st.executeQuery("SELECT * FROM Titulacion");
              ArrayList<Titulacion> listaTitulaciones = new ArrayList<Titulacion>();
             // log.info("In CreaBDAction --> ");
              while (rst1.next()){ 
              	Titulacion tit = new Titulacion();
              	int ID = rst1.getInt("titulacion_ID");
              	String nom = rst1.getString("nombre_Tit"); 
              	tit.setTitulacion_ID(ID);
              	tit.setNombre_Tit(nom);
              	listaTitulaciones.add(tit);
                //  log.info("Tabla Titulaci�n: "+	ID + " "+nom);  
              }
              sesion.setAttribute("listaTitulaciones",listaTitulaciones);
              
              //Creamos la listaTecnologias con scope=session
              rst1 = st.executeQuery("SELECT * FROM Tecnologia");
              ArrayList<Tecnologia> listaTecnologias = new ArrayList<Tecnologia>();
             // log.info("In CreaBDAction --> ");
              while (rst1.next()){ 
              	Tecnologia tec = new Tecnologia();
              	int ID = rst1.getInt("tecnologia_ID");
              	String nom = rst1.getString("nombre_Tec"); 
              	tec.setTecnologia_ID(ID);
              	tec.setNombre_Tec(nom);
              	listaTecnologias.add(tec);
               //   log.info("Tabla Tecnolog�a: "+	ID + " "+nom);  
              }
              sesion.setAttribute("listaTecnologias",listaTecnologias);
              
              
              //crear la lista de pa�ses
              crearListaPaises();

          } catch (Exception ex){  
              log.error(" In CreaBDAction - Base de Datos no creada por --> "+ ex.getMessage());
          }
          log.info("In CreaBDAction --> Base de datos creada");
          return mapping.findForward("Ok");
	 }

	private void crearListaPaises() {
		Map<String,String> listaPaises=new LinkedHashMap<String,String>();
		listaPaises.put("ES","Espa�a");
		listaPaises.put("AF","Afganist�n");
		listaPaises.put("AL","Albania");
		listaPaises.put("DE","Alemania");
		listaPaises.put("AN","Andorra");
				
		listaPaises.put("AO","Angola ");
		listaPaises.put("AI","Anguilla ");
		listaPaises.put("AQ","Ant�rtida ");
		listaPaises.put("AG","Antigua y Barbuda ");
		listaPaises.put("AN","Antillas Holandesas ");
				
		listaPaises.put("SA","Arabia Saud� ");
		listaPaises.put("DZ","Argelia ");
		listaPaises.put("AR","Argentina ");
		listaPaises.put("AM","Armenia ");
		listaPaises.put("AW","Aruba ");
				
		listaPaises.put("MK","ARY Macedonia ");
		listaPaises.put("AU","Australia ");
		listaPaises.put("AT","Austria ");
		listaPaises.put("AZ","Azerbaiy�n ");
		listaPaises.put("BS","Bahamas ");
				
		listaPaises.put("BH","Bahr�in ");
		listaPaises.put("BD","Bangladesh ");
		listaPaises.put("BB","Barbados ");
		listaPaises.put("BE","B�lgica ");
		listaPaises.put("BZ","Belice ");
				
		listaPaises.put("BJ","Benin ");
		listaPaises.put("BM","Bermudas ");
		listaPaises.put("BT","Bhut�n ");
		listaPaises.put("BY","Bielorrusia ");
		listaPaises.put("BO","Bolivia ");
				
		listaPaises.put("BA","Bosnia y Herzegovina ");
		listaPaises.put("BW","Botsuana ");
		listaPaises.put("BR","Brasil ");
		listaPaises.put("BN","Brun�i ");
		listaPaises.put("BG","Bulgaria ");
				
		listaPaises.put("BF","Burkina Faso ");
		listaPaises.put("BI","Burundi ");
		listaPaises.put("CV","Cabo Verde ");
		listaPaises.put("KH","Camboya ");
		listaPaises.put("CM","Camer�n ");
				
		listaPaises.put("CA","Canad� ");
		listaPaises.put("TD","Chad ");
		listaPaises.put("CL","Chile ");
		listaPaises.put("CN","China ");
		listaPaises.put("CY","Chipre ");
				
		listaPaises.put("VA","Ciudad del Vaticano ");
		listaPaises.put("CO","Colombia ");
		listaPaises.put("KM","Comoras ");
		listaPaises.put("CG","Congo ");
		listaPaises.put("KP","Corea del Norte ");
				
		listaPaises.put("KR","Corea del Sur ");
		listaPaises.put("CI","Costa de Marfil ");
		listaPaises.put("CR","Costa Rica ");
		listaPaises.put("HR","Croacia ");
		listaPaises.put("CU","Cuba ");
				
		listaPaises.put("DK","Dinamarca ");
		listaPaises.put("DM","Dominica ");
		listaPaises.put("EC","Ecuador ");
		listaPaises.put("EG","Egipto ");
		listaPaises.put("SV","El Salvador ");
				
		listaPaises.put("AE","Emiratos �rabes Unidos ");
		listaPaises.put("ER","Eritrea ");
		listaPaises.put("SK","Eslovaquia ");
		listaPaises.put("SI","Eslovenia "); 
				
		listaPaises.put("US","Estados Unidos ");
		listaPaises.put("EE","Estonia ");
		listaPaises.put("ET","Etiop�a ");
		listaPaises.put("PH","Filipinas ");
		listaPaises.put("FI","Finlandia ");
				
		listaPaises.put("FJ","Fiyi ");
		listaPaises.put("FR","Francia ");
		listaPaises.put("GA","Gab�n ");
		listaPaises.put("GM","Gambia ");
		listaPaises.put("GE","Georgia ");
				
		listaPaises.put("GH","Ghana ");
		listaPaises.put("GI","Gibraltar ");
		listaPaises.put("GD","Granada ");
		listaPaises.put("GR","Grecia ");
		listaPaises.put("GL","Groenlandia ");
				
		listaPaises.put("GP","Guadalupe ");
		listaPaises.put("GU","Guam ");
		listaPaises.put("GT","Guatemala ");
		listaPaises.put("GF","Guayana Francesa ");
		listaPaises.put("GN","Guinea ");
				
		listaPaises.put("GQ","Guinea Ecuatorial ");
		listaPaises.put("GW","Guinea-Bissau ");
		listaPaises.put("GY","Guyana ");
		listaPaises.put("HT","Hait� ");
		listaPaises.put("HN","Honduras ");
				
		listaPaises.put("HK","Hong Kong ");
		listaPaises.put("HU","Hungr�a ");
		listaPaises.put("IN","India ");
		listaPaises.put("ID","Indonesia ");
		listaPaises.put("IR","Ir�n ");
				
		listaPaises.put("IQ","Iraq ");
		listaPaises.put("IE","Irlanda ");
		listaPaises.put("BV","Isla Bouvet ");
		listaPaises.put("CX","Isla de Navidad ");
		listaPaises.put("NF","Isla Norfolk ");
				
		listaPaises.put("IS","Islandia ");
		listaPaises.put("KY","Islas Caim�n ");
		listaPaises.put("CC","Islas Cocos ");
		listaPaises.put("CK","Islas Cook ");
		listaPaises.put("FO","Islas Feroe ");
				
		listaPaises.put("GS","Islas Georgias del Sur y Sandwich del Sur ");
		listaPaises.put("AX","Islas Gland ");
		listaPaises.put("HM","Islas Heard y McDonald ");
		listaPaises.put("FK","Islas Malvinas ");
		listaPaises.put("MP","Islas Marianas del Norte ");
				
		listaPaises.put("MH","Islas Marshall ");
		listaPaises.put("PN","Islas Pitcairn ");
		listaPaises.put("SB","Islas Salom�n ");
		listaPaises.put("TC","Islas Turcas y Caicos ");
		listaPaises.put("UM","Islas ultramarinas de Estados Unidos ");
				
		listaPaises.put("VG","Islas V�rgenes Brit�nicas ");
		listaPaises.put("VI","Islas V�rgenes de los Estados Unidos ");
		listaPaises.put("IL","Israel ");
		listaPaises.put("IT","Italia ");
		listaPaises.put("JM","Jamaica ");
				
		listaPaises.put("JP","Jap�n ");
		listaPaises.put("JO","Jordania ");
		listaPaises.put("KZ","Kazajst�n ");
		listaPaises.put("KE","Kenia ");
		listaPaises.put("KG","Kirguist�n ");
				
		listaPaises.put("KI","Kiribati ");
		listaPaises.put("KW","Kuwait ");
		listaPaises.put("LA","Laos ");
		listaPaises.put("LS","Lesotho ");
		listaPaises.put("LV","Letonia ");
				
		listaPaises.put("LB","L�bano ");
		listaPaises.put("LR","Liberia ");
		listaPaises.put("LY","Libia ");
		listaPaises.put("LI","Liechtenstein ");
		listaPaises.put("LT","Lituania ");
				
		listaPaises.put("LU","Luxemburgo ");
		listaPaises.put("MO","Macao ");
		listaPaises.put("MG","Madagascar ");
		listaPaises.put("MY","Malasia ");
		listaPaises.put("MW","Malawi ");
				
		listaPaises.put("MV","Maldivas ");
		listaPaises.put("ML","Mal� ");
		listaPaises.put("MT","Malta ");
		listaPaises.put("MA","Marruecos ");
		listaPaises.put("MQ","Martinica ");
				
		listaPaises.put("MU","Mauricio ");
		listaPaises.put("MR","Mauritania ");
		listaPaises.put("YT","Mayotte ");
		listaPaises.put("MX","M�xico ");
		listaPaises.put("FM","Micronesia ");
				
		listaPaises.put("MD","Moldavia ");
		listaPaises.put("MC","M�naco ");
		listaPaises.put("MN","Mongolia ");
		listaPaises.put("MS","Montserrat ");
		listaPaises.put("MZ","Mozambique ");
				
		listaPaises.put("MM","Myanmar ");
		listaPaises.put("NA","Namibia ");
		listaPaises.put("NR","Nauru ");
		listaPaises.put("NP","Nepal ");
		listaPaises.put("NI","Nicaragua ");
				
		listaPaises.put("NE","N�ger ");
		listaPaises.put("NG","Nigeria ");
		listaPaises.put("NU","Niue ");
		listaPaises.put("NO","Noruega ");
		listaPaises.put("NC","Nueva Caledonia ");
				
		listaPaises.put("NZ","Nueva Zelanda ");
		listaPaises.put("OM","Om�n ");
		listaPaises.put("NL","Pa�ses Bajos ");
		listaPaises.put("PK","Pakist�n ");
		listaPaises.put("PW","Palau ");
				
		listaPaises.put("PS","Palestina ");
		listaPaises.put("PA","Panam� ");
		listaPaises.put("PG","Pap�a Nueva Guinea ");
		listaPaises.put("PY","Paraguay ");
		listaPaises.put("PE","Per� ");
				
		listaPaises.put("PF","Polinesia Francesa ");
		listaPaises.put("PL","Polonia ");
		listaPaises.put("PT","Portugal ");
		listaPaises.put("PR","Puerto Rico ");
		listaPaises.put("QA","Qatar ");
				
		listaPaises.put("GB","Reino Unido ");
		listaPaises.put("CF","Rep�blica Centroafricana ");
		listaPaises.put("CZ","Rep�blica Checa ");
		listaPaises.put("CD","Rep�blica Democr�tica del Congo ");
		listaPaises.put("DO","Rep�blica Dominicana ");
				
		listaPaises.put("RE","Reuni�n ");
		listaPaises.put("RW","Ruanda ");
		listaPaises.put("RO","Rumania ");
		listaPaises.put("RU","Rusia ");
		listaPaises.put("EH","Sahara Occidental ");
				
		listaPaises.put("WS","Samoa ");
		listaPaises.put("AS","Samoa Americana ");
		listaPaises.put("KN","San Crist�bal y Nevis ");
		listaPaises.put("SM","San Marino ");
		listaPaises.put("PM","San Pedro y Miquel�n ");
				
		listaPaises.put("VC","San Vicente y las Granadinas ");
		listaPaises.put("SH","Santa Helena ");
		listaPaises.put("LC","Santa Luc�a ");
		listaPaises.put("ST","Santo Tom� y Pr�ncipe ");
		listaPaises.put("SN","Senegal ");
				
		listaPaises.put("CS","Serbia y Montenegro ");
		listaPaises.put("SC","Seychelles ");
		listaPaises.put("SL","Sierra Leona ");
		listaPaises.put("SG","Singapur ");
		listaPaises.put("SY","Siria ");
				
		listaPaises.put("SO","Somalia ");
		listaPaises.put("LK","Sri Lanka ");
		listaPaises.put("SZ","Suazilandia ");
		listaPaises.put("ZA","Sud�frica ");
		listaPaises.put("SD","Sud�n ");
				
		listaPaises.put("SE","Suecia ");
		listaPaises.put("CH","Suiza ");
		listaPaises.put("SR","Surinam ");
		listaPaises.put("SJ","Svalbard y Jan Mayen ");
		listaPaises.put("TH","Tailandia ");
				
		listaPaises.put("TW","Taiw�n ");
		listaPaises.put("TZ","Tanzania ");
		listaPaises.put("TJ","Tayikist�n ");
		listaPaises.put("IO","Territorio Brit�nico del Oc�ano �ndico ");
		listaPaises.put("TF","Territorios Australes Franceses ");
				
		listaPaises.put("TL","Timor Oriental ");
		listaPaises.put("TG","Togo ");
		listaPaises.put("TK","Tokelau ");
		listaPaises.put("TO","Tonga ");
		listaPaises.put("TT","Trinidad y Tobago ");
				
		listaPaises.put("TN","T�nez ");
		listaPaises.put("TM","Turkmenist�n ");
		listaPaises.put("TR","Turqu�a ");
		listaPaises.put("TV","Tuvalu ");
		listaPaises.put("UA","Ucrania ");
				
		listaPaises.put("UG","Uganda ");
		listaPaises.put("UY","Uruguay ");
		listaPaises.put("UZ","Uzbekist�n ");
		listaPaises.put("VU","Vanuatu ");
		listaPaises.put("VE","Venezuela ");
				
		listaPaises.put("VN","Vietnam ");
		listaPaises.put("WF","Wallis y Futuna ");
		listaPaises.put("YE","Yemen ");
		listaPaises.put("DJ","Yibuti ");
		listaPaises.put("ZM","Zambia ");
				
		listaPaises.put("ZW","Zimbabue ");

		sesion.setAttribute("listaPaises",listaPaises);
		
	}

}
