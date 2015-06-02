<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
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
	<title>Login Correcto</title>
		<META HTTP-EQUIV="REFRESH" CONTENT="2;URL=homePage.jsp"></META> 
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div id="content"> 
		
		<h1>Usuario <jsp:getProperty property="user_ID" name="loginBean"/> registrado correctamente</h1>
		
		<p>Si el navegador no le muestra la pantalla de inicio, pulse: 
			<html:link action="home"><bean:message key="tohome.link" /></html:link>
		</p>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
