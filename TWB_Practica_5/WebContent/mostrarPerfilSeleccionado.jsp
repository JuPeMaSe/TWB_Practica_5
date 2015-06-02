<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
    xmlns:bean="http://struts.apache.org/tags-bean"	
    xmlns:c="http://java.sun.com/jstl/core_rt"
   version="2.0">

<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />

<html:html xhtml="true">
<head>
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	
	<title>Perfil seleccionado</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	 
 	<div id="content">
   		
	<h1>Perfil Seleccionado</h1>
	<!-- <html:form action="/processConsulta">-->
		<table> <!-- tabla 0 -->
		<tr><td>
		
		<c:forEach var="perfil" items="${listaPerfiles}">
				<fieldset><legend>Perfil del usuario: ${perfil.user_ID } </legend>
				<!-- <html:button property="mostrar" onclick="parent.location='mostrarPerfilSeleccionado.jsp'">Mostrar Perfil</html:button> -->
				<table> <!-- tabla 1 -->
				<tr><td>
					<fieldset><legend>Perfil</legend>	
						<table border="1"> <!-- Tabla 2 -->
	<!-- 						<tr><th>profile_ID</th><th>dirección</th><th>localidad</th><th>provincia</th><th>pais</th>
							<th>Me gusta</th><th>pdf(url)</th><th>fotografia</th><th>user_ID</th></tr>	-->
	<!--  		 			<tr><th>profile_ID</th><td>${perfil.profile_ID}</td></tr> -->
		 					<tr><th>Dirección</th><td>${perfil.direccion}</td></tr>
		 					<tr><th>Localidad</th><td>${perfil.localidad}</td></tr>
		 					<tr><th>Provincia</th><td>${perfil.provincia}</td></tr>
		 					<tr><th>Pais</th><td>${perfil.pais}</td></tr>
		 					<tr><th>Me Gusta</th><td>${perfil.cont_MeGusta}</td></tr>
		 					<tr><th>PDF</th><td><a href="${perfil.pdf}" target="_blank">${perfil.pdf}</a></td></tr>
		 					<tr><th>Fotografia</th><td><a href="${perfil.fotografia}" target="_blank">${perfil.fotografia}</a></td></tr>
		 					<!-- <tr><th>user_ID</th><td>${perfil.user_ID}</td></tr> --> 	 					
		 				</table> <!-- tabla 2 -->
	 				</fieldset>
	 			</td>
	 			<td>
	 				<fieldset><legend>Usuario</legend>
	 					<table border="1"> <!-- tabla 2 -->
	 					<c:forEach var="usuario" items="${listaUsuarios}">
	 						<!-- <tr><th>user_ID</th><td>${usuario.user_ID}</td></tr>
		 					<tr><th>password</th><td>${usuario.password}</td></tr> -->
		 					<tr><th>Nombre</th><td>${usuario.nombre}</td></tr>
		 					<tr><th>Apellidos</th><td>${usuario.apellidos}</td></tr>
		 					<tr><th>Teléfono</th><td>${usuario.tfno}</td></tr>
		 					<tr><th>E-mail</th><td>${usuario.email}</td></tr>
		 					<!-- <tr><th>userType</th><td>${usuario.userType}</td></tr> -->
	 					</c:forEach>
	 					</table> <!-- tabla 2 -->
	 				</fieldset>
	 			</td>
				</tr>
	 <!-- 			</table> tabla 1  -->
<!-- 	 			<table>  tabla 1 --> 
	 			<tr> 			
	 			<td> 				
	 				<fieldset><legend>Titulaciones: </legend>
	 					<table> <!-- tabla 2 -->
	 						<c:forEach var="titu" items="${perfil.listaTit}">
	 							<c:forEach var="titula" items="${listaTitulaciones}">
		 							<c:if test="${titula.titulacion_ID == titu}">
		 								<tr><th>Titulación: </th><td>${titula.nombre_Tit}</td></tr>
		 							</c:if>
		 						</c:forEach>
	 						</c:forEach>
	 					</table> <!-- tabla 2 -->
	 				</fieldset> 				
	 			</td>
	 			<td rowspan="2"> 				
	 				<fieldset><legend>Experiencia: </legend>
	 					<c:forEach var="expe" items="${perfil.listaExp}">
	 						<table border="1"> <!--  tabla 2 -->
		 						<!-- <tr><th>exp_ID</th><td>${expe.exp_ID}</td></tr>  
		 						<tr><th>profile_ID</th><td>${expe.profile_ID}</td></tr>  -->
			 					<tr><th>Empresa</th><td>${expe.empresa}</td></tr>
			 					<tr><th>Cargo</th><td>${expe.cargo}</td></tr>
			 					<tr><th>Fecha Inicio</th><td>${expe.a_Inicio}</td></tr>
			 					<tr><th>Fecha Fin</th><td>${expe.a_Fin}</td></tr>		 						
		 					</table> <!-- tabla 2 -->
		 				</c:forEach>
	 				</fieldset> 						
	 			</td>
	 			</tr>
	 			<tr>
	 			<td>	
		 			<fieldset><legend>Tecnologías: </legend>
		 				<table> <!-- tabla 2 -->
		 					<c:forEach var="tecn" items="${perfil.listaTec}">
		 						<c:forEach var="tecnol" items="${listaTecnologias}">
		 							<c:if test="${tecnol.tecnologia_ID == tecn}">
		 								<tr><th>Tecnología: </th><td>${tecnol.nombre_Tec}</td></tr>
		 							</c:if>
		 						</c:forEach>
		 					</c:forEach>
		 				</table> <!-- tabla 2 -->
		 			</fieldset>
		 		</td>
	 			</tr>
	 			</table> <!-- tabla 1 -->
	 			</fieldset>							 
		</c:forEach> 
		</td></tr>
		<tr><td>		  
			<a href="javascript:history.back()">Volver</a>
	  		<!-- <html:link action="home"><bean:message key="tohome.link" /></html:link>-->
	  			<!-- 	<html:submit property="mostrar" value="Mostrar Perfil: ${perfil.profile_ID}"></html:submit>
	 				<html:submit property="accion" value="${perfil.profile_ID }"></html:submit>
	 				<html:submit property="accion" value="Me gusta"></html:submit>
	 				<html:submit property="accion" value="borrar"></html:submit>   -->		
	 						
	  	</td></tr>
	  	</table> <!-- tabla 0 -->
	  	
	<!--    </html:form>  -->
  	</div>

	<jsp:directive.include file="footer.jsp" />
</body>

</html:html>
</jsp:root>