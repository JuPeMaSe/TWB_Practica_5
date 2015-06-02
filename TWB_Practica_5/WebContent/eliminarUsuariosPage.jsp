<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
   xmlns:bean="http://struts.apache.org/tags-bean"
   xmlns:logic="http://struts.apache.org/tags-logic"
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
	<title>Eliminar Usuarios</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" />   
 	
 	<div id="content"> 
   		<h1>Página eliminar usuarios</h1>
   		<html:form action="/processEliminarUsuarios">
		
		<fieldset><legend>Lista de usuarios a eliminar</legend>
		
			<table align="center">
				<tr>
					<th>Eliminar</th>
					<th>User_ID</th>
					<th>Nombre</th>
					<th>Apellidos</th>
				</tr>
				<c:forEach var="usuario"  items="${listaUsuarios}">
				<c:if test="${usuario.user_ID != 'admin'}"><!-- Con este if se evita que aparezca el usuario 'admin' como posible usuario a eliminar -->
					<tr>						
						<td><html:multibox property="userIds">"${usuario.user_ID}"</html:multibox></td>
						<td><c:out value="${usuario.user_ID}"></c:out></td>
						<td><c:out value="${usuario.nombre}"/></td>
						<td><c:out value="${usuario.apellidos}"/></td>
					</tr>
				</c:if>
				</c:forEach>				
			</table>
			</fieldset>
			<p></p>
			<html:submit>Eliminar Usuarios</html:submit>
		</html:form>
		<p></p>		
		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
