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
	<meta http-equiv="Content-Type" content="text/html" />
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<title>Página de contacto</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<h1>Página de contacto</h1>
	<div id="content">
	<FIELDSET><legend>Contacta con nosotros: </legend>
	<p>Si tienes alguna sugerencia, o simplemente quieres comentarnos algo, y tienes una aplicación de correo instalada</p>
	<p>Envíanos un correo a:</p> 
	<c:set var="str" value="?subject=Sugerencias&amp;body=Escribe aquí tus sugerencias. Gracias "/> 
		<ul>
			<li><a href="mailto:jpmarquez199@gmail.com${str}">Juan Pedro</a></li>
			<li><a href="mailto:jjlife06@gmail.com${str}">Juan</a></li>
			<li><a href="mailto:j.a.torrellas@gmail.com${str}">Jesús</a></li>			
		</ul>
	</FIELDSET>

	<p></p>	
	<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
</body>
</html:html>
</jsp:root>