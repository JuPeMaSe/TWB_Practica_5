<?xml version="1.0" encoding="UTF-8"?>
<!-- File: creadaBD.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 		
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
	<title>Creada Base de Datos</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<h1>Creada base de datos provisional</h1>

	
	<a href="homePage.jsp">Pulsa para volver la página de inicio</a>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>