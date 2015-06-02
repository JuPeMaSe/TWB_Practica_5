<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
    xmlns:bean="http://struts.apache.org/tags-bean"	
    xmlns:logic="http://struts.apache.org/tags-logic"
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
	<jsp:useBean id="administrarBean" class= "com.mistrutswebapp.beans.AdministrarBean" scope="application"></jsp:useBean>
	
	<title>Administrador</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" /> 
   	<div id="content">
   		
		<h1>Página administrador</h1>
		<p align="center">Deshabilitar las siguientes funciones para todos los usuarios.</p>
		<p align="center">  Unchecked = habilitado. Checked = deshabilitado.</p>
		<html:form action="/processAdministrar">		
			
			<!-- 
			<html:checkbox property="adConsultar">Consultas de perfiles</html:checkbox><br/>
			<fieldset>
			<legend>Usuarios</legend>
			<html:checkbox property="adAltaUsuario">Dar de alta a usuarios</html:checkbox><br/>
			<html:checkbox property="adBajaUsuario">Dar de baja a usuarios</html:checkbox><br/>
			</fieldset>
			<fieldset>
			<legend>Perfiles</legend>
			<html:checkbox property="adCrearPerfil">Crear perfiles</html:checkbox><br/>
			<html:checkbox property="adModificarPerfil">Modificar perfiles</html:checkbox><br/>
			<html:checkbox property="adEliminarPerfil">Eliminar perfiles</html:checkbox><br/>
			</fieldset>
			  -->
			  
			  <fieldset>
			  <legend>Consultas</legend>
			  <!-- Consultas -->		
			<logic:equal name="administrarBean" property="adConsultar" scope="application" value="true">
				<input type="checkbox" name="adConsultar" id="adConsultar" checked="checked"/>
			 </logic:equal>
			<logic:equal name="administrarBean" property="adConsultar" scope="application" value="false">
				<input type="checkbox" name="adConsultar" id="adConsultar" />
			 </logic:equal>
			 <label for="adConsultar">Consultas de perfiles</label><br />
			 </fieldset>
			 
			 <fieldset>
			 <legend>Usuarios</legend>
			 <!-- Alta Usuario -->			 
			<logic:equal name="administrarBean" property="adAltaUsuario" scope="application" value="true">
				<input type="checkbox" name="adAltaUsuario" id="adAltaUsuario" checked="checked"/>
			 </logic:equal>
			<logic:equal name="administrarBean" property="adAltaUsuario" scope="application" value="false">
				<input type="checkbox" name="adAltaUsuario" id="adAltaUsuario" />
			 </logic:equal>
			 <label for="adConsultar">Dar de alta a un usuario</label><br />
			 		 
			 <!-- Baja Usuario -->			 
			<logic:equal name="administrarBean" property="adBajaUsuario" scope="application" value="true">
				<input type="checkbox" name="adBajaUsuario" id="adBajaUsuario" checked="checked"/>
			 </logic:equal>
			<logic:equal name="administrarBean" property="adBajaUsuario" scope="application" value="false">
				<input type="checkbox" name="adBajaUsuario" id="adBajaUsuario" />
			 </logic:equal>
			 <label for="adConsultar">Dar de baja a un usuario</label><br />
			 </fieldset>
			 
			 <fieldset>
			 <legend>Perfiles</legend> 
			 <!-- Crear Perfil -->			 
			<logic:equal name="administrarBean" property="adCrearPerfil" scope="application" value="true">
				<input type="checkbox" name="adCrearPerfil" id="adCrearPerfil" checked="checked"/>
			 </logic:equal>
			<logic:equal name="administrarBean" property="adCrearPerfil" scope="application" value="false">
				<input type="checkbox" name="adCrearPerfil" id="adCrearPerfil" />
			 </logic:equal>
			 <label for="adConsultar">Crear un perfil</label><br />
			 
			 <!-- Modificar Perfil -->			 
			<logic:equal name="administrarBean" property="adModificarPerfil" scope="application" value="true">
				<input type="checkbox" name="adModificarPerfil" id="adModificarPerfil" checked="checked"/>
			 </logic:equal>
			<logic:equal name="administrarBean" property="adModificarPerfil" scope="application" value="false">
				<input type="checkbox" name="adModificarPerfil" id="adModificarPerfil" />
			 </logic:equal>
			 <label for="adConsultar">Modificar un perfil</label><br />
			 
			 <!-- Eliminar Perfil -->			 
			<logic:equal name="administrarBean" property="adEliminarPerfil" scope="application" value="true">
				<input type="checkbox" name="adEliminarPerfil" id="adEliminarPerfil" checked="checked"/>
			 </logic:equal>
			<logic:equal name="administrarBean" property="adEliminarPerfil" scope="application" value="false">
				<input type="checkbox" name="adEliminarPerfil" id="adEliminarPerfil" />
			 </logic:equal>
			 <label for="adConsultar">Eliminar un perfil</label><br/>
			 </fieldset>
			<p></p>
			<html:submit>Confimar cambios</html:submit>	
			<p></p>			
		</html:form>
		
		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
