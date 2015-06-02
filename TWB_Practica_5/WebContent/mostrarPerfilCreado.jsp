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
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	<title>Editar perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" />  	 
 	<div id="content">   		
	<h1>Confirmación de los datos del Perfil</h1>
	<html:form action="/processGrabar" enctype="multipartform-data">
	<fieldset>
	  <table border="0">
					<tr>
						<th>Dirección</th>
						<td><jsp:getProperty name="perfilBean" property="direccion"/></td>
					</tr>
					<tr>
						<th>Provincia</th>
						<td><jsp:getProperty name="perfilBean" property="provincia"/></td>
					</tr>
					<tr>
						<th>Pais</th>
						<td><jsp:getProperty name="perfilBean" property="pais"/></td>
					</tr>
					<tr>
						<th>Pdf</th>
						<td><jsp:getProperty name="perfilBean" property="pdf"/></td>
					</tr>
					<tr>
						<th>Fotografía</th>
						<td><jsp:getProperty name="perfilBean" property="fotografia"/></td>
					</tr> 
					<c:forEach var="titu" items="${perfilBean.listaTit}">
						<c:forEach var="titula" items="${listaTitulaciones}">
	 						<c:if test="${titula.titulacion_ID == titu}">
	 							<tr><th>Titulación: </th><td>${titula.nombre_Tit}</td></tr>
	 						</c:if>
	 					</c:forEach>
					</c:forEach>
					<c:forEach var="tecn" items="${perfilBean.listaTec}" >
						<c:forEach var="tecnol" items="${listaTecnologias}">
	 						<c:if test="${tecnol.tecnologia_ID == tecn}">
	 							<tr><th>Tecnología: </th><td>${tecnol.nombre_Tec}</td></tr>
	 						</c:if>
	 					</c:forEach>
					</c:forEach>
					</table>
					<table>
					<jsp:setProperty name="perfilBean" property="listaExp" param="listaExp"/>
					<tr>
					<th align="center">Empresa</th><th align="center">Cargo</th><th align="center">Año de Inicio</th><th align="center">Año de Finalización</th>
					</tr>
					<c:forEach var="expe" items="${perfilBean.listaExp}">
						<tr>
						<td><c:out value="${expe.empresa}"/></td>
						<td><c:out value="${expe.cargo}"/></td>
						<td><c:out value="${expe.a_Inicio}"/></td>
						<td><c:out value="${expe.a_Fin}"/></td>
						</tr>
					</c:forEach>					
				</table>
			</fieldset>
			<p></p>
			<p><html:button property="atras" onclick="parent.location='crearPage.jsp'">Cancelar</html:button><html:submit>Confirmar</html:submit></p>
		</html:form>
		<p></p>
		<p><html:link action="home"><bean:message key="tohome.link" /></html:link></p>  		
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
  	