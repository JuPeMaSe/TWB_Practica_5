<?xml version="1.0" encoding="UTF-8"?>
<!-- File: bajaPage.jsp -->
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
	<title>Página de Baja</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
 	 
	<div id="content"> 
	  	<h1>Página de Baja</h1>
	  	<h3>El usuario -- <bean:write name="loginBean" property="user_ID"/> -- va ha ser dado de baja.</h3>
	  	<p>Esta operación no se puede deshacer.</p>
	  	<p>Se eliminarán todos los perfiles asociados con este usuario. </p>
	  	<h3>Si desea continuar con la baja pulse <html:link action="processBaja">aquí para confirmar</html:link> la baja de usuario</h3>
	  	<h4>Pulse <html:link action="home">aquí para Cancelar</html:link> y volver a la página de inicio</h4>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
