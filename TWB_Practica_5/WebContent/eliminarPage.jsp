<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:html="http://struts.apache.org/tags-html"
	xmlns:bean="http://struts.apache.org/tags-bean" xmlns:c="http://java.sun.com/jstl/core_rt" version="2.0">
	<jsp:directive.page contentType="text/html" />
	<jsp:output omit-xml-declaration="false" doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.1//EN"
		doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
<html:html xhtml="true">
	<head>
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	
	<title>Eliminar Perfil</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div id="content">
	<h1>Página eliminar perfil</h1>
	<html:form action="/processEliminarPerfiles" enctype="multipartform-data">
	<fieldset>
		<table>
			<tr>
				<th>Eliminar</th>
				<th>Profile_ID</th>
				<th>Direccion</th>
				<th>Localidad</th>
				<th>Provincia</th>
				<th>Pais</th>
				<th>Me Gusta</th>
				<th>Usuario</th>
			</tr>
			<c:forEach var="perfil"  items="${listaPerfiles}">
				<c:if test="${perfil.user_ID != 'admin'}"><!-- Con este if se evita que aparezca el usuario 'admin' como posible usuario a eliminar -->
				<tr>						
					<td><html:multibox property="profileIds" value="${perfil.profile_ID}"></html:multibox></td>
					<td><c:out value="${perfil.profile_ID}"></c:out></td>
					<td><c:out value="${perfil.direccion}"/></td>
					<td><c:out value="${perfil.localidad}"/></td>
					<td><c:out value="${perfil.provincia}"/></td>
					<td><c:out value="${perfil.pais}"/></td>
					<td><c:out value="${perfil.cont_MeGusta}"/></td>
					<td><c:out value="${perfil.user_ID}"/></td>
				</tr>
				</c:if>
			</c:forEach>				
		</table>
		</fieldset>
		<p></p>
		<html:submit>Eliminar Perfil</html:submit>
	</html:form>
	<p></p>
	<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
