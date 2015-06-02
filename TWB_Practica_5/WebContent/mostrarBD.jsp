<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
   xmlns:bean="http://struts.apache.org/tags-bean"	
   xmlns:c="http://java.sun.com/jstl/core_rt"
   version="2.0">
<jsp:directive.page import="java.sql.Date"/>
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
<html:html xhtml="true">
<head>
	<meta http-equiv="Content-Type" content="text/html" />
	 <link href="threeregion.css" rel="stylesheet" type="text/css" />  
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<title>Base de Datos</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	 	 
	 <div id="content"> 
	<h1>Base de Datos Completa</h1>
	<table><tr><td>
		<FIELDSET><legend>Usuarios</legend>
			<table>
				<tr><th>user_ID</th><th>password</th><th>nombre</th><th>apellidos</th><th>tfno</th><th>email</th><th>userType</th></tr>
		 		<c:forEach var="usuario" items="${listaUsuarios}">
			 		<tr><td>${usuario.user_ID}</td><td>${usuario.password}</td><td>${usuario.nombre}</td><td>${usuario.apellidos}</td>
			 		<td>${usuario.tfno}</td><td>${usuario.email}</td><td>${usuario.userType}</td></tr>
			 	</c:forEach>
			 </table>
		 </FIELDSET>
		 </td></tr>
		 <tr><td>
		 <FIELDSET><LEGEND>Perfiles</LEGEND>
			<table>
			
			 	<c:forEach var="perfil" items="${listaPerfiles}">
			 	<tr><td><fieldset><legend>Perfil ID = ${perfil.profile_ID} - Usuario ID =  ${perfil.user_ID }</legend>
			 	<table>	
			 	<tr><th>dirección</th><th>localidad</th><th>provincia</th><th>pais</th>
					<th>Me gusta</th><th>pdf(url)</th><th>fotografia</th><th>Titulaciones</th><th>Tecnologia</th><th>Experiencia</th></tr>	 		
			 		<tr><td>${perfil.direccion}</td>
			 		<td>${perfil.localidad}</td>
			 		<td>${perfil.provincia}</td>
			 		<td>${perfil.pais}</td>
			 		<td>${perfil.cont_MeGusta}</td>
			 		<td>${perfil.pdf}</td>
			 		<td>${perfil.fotografia}</td>
			 		<!-- <td>${perfil.user_ID}</td>   -->
			 		<td>		
						<fieldset><legend>Titulaciones: </legend>
	 					<table>
	 						<c:forEach var="titu" items="${perfil.listaTit}">
	 							<c:forEach var="titula" items="${listaTitulaciones}">
		 							<c:if test="${titula.titulacion_ID == titu}">
		 								<tr><th>Titulación: </th><td>${titula.nombre_Tit}</td></tr>
		 							</c:if>
		 						</c:forEach>
	 						</c:forEach>
	 					</table> 
	 					</fieldset>
	 				</td>
	 				<td>
		 				<fieldset><legend>Tecnologías: </legend>
							<table>
								<c:forEach var="tecn" items="${perfil.listaTec}">
									<c:forEach var="tecnol" items="${listaTecnologias}">
										<c:if test="${tecnol.tecnologia_ID == tecn}">
											<tr><th>Tecnología: </th><td>${tecnol.nombre_Tec}</td></tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</table> 
						</fieldset>
	 				</td>
	 				<td> 				
	 					<fieldset><legend>Experiencia: </legend>
		 					<table border="1">
		 						<c:forEach var="expe" items="${perfil.listaExp}">
		 							<tr><th>exp_ID</th><td>${expe.exp_ID}</td></tr>
			 						<tr><th>profile_ID</th><td>${expe.profile_ID}</td></tr>
				 					<tr><th>empresa</th><td>${expe.empresa}</td></tr>
				 					<tr><th>cargo</th><td>${expe.cargo}</td></tr>
				 					<tr><th>a_Inicio</th><td>${expe.a_Inicio}</td></tr>
				 					<tr><th>a_Fin</th><td>${expe.a_Fin}</td></tr>		 						
			 					</c:forEach>
			 				</table> 
	 					</fieldset> 					
	 				</td>
	 				
	 				</tr>
	 			</table>
	 		</fieldset></td></tr>
	 		</c:forEach>
	 	</table>
	 	
	</FIELDSET>
	</td></tr>
	</table>
		
		
			<html:link action="home"><bean:message key="tohome.link" /></html:link>
		
		</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>