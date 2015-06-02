<?xml version="1.0" encoding="UTF-8"?>
<!-- File: loginform.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html"
   xmlns:bean="http://struts.apache.org/tags-bean"		
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
	<title>Login</title>
</head>
<body>
  	<jsp:directive.include file="header.jsp" />
  	<div id="content">
	<h1 align="center">Introduzca su nombre de usuario y contraseña</h1>
	<!-- <h2 align= "center">El acceso a esta página solo está permitido para usuarios registrados</h2> -->
	
	<h3>Introduzca sus credenciales y pulse Enviar</h3>
   	<html:form action="/processlogin"> 
    <table align= "center">
		<tr>
			<td>Identidad de Usuario</td>
			<td><html:text property="user_ID"/></td>
			<td><html:errors property="user_ID" /></td>
	    </tr>
	    <tr>
			<td>Contraseña</td>
			<td><html:password property="password"/></td>
			<td><html:errors property="password" /></td>
	    </tr>
		<tr>
		    <td></td>
		    <td><html:submit>Enviar</html:submit></td>
		    <td></td>
	    </tr>
  	</table>
 	</html:form>
 	<p></p>
	<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
  	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>