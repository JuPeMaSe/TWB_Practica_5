<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html"
   xmlns:logic="http://struts.apache.org/tags-logic"
   xmlns:bean="http://struts.apache.org/tags-bean" 		
   version="2.0">
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
 <html:html xhtml="true">
 <head> 
<!-- 	Comentario añadido para probar Github -->

   	<link href="threeregion.css" rel="stylesheet" type="text/css" />
   	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
   	<jsp:useBean id="administrarBean" class= "com.mistrutswebapp.beans.AdministrarBean" scope="application"></jsp:useBean>
   	   	<title>LinkUNEDin</title>  
 </head>
  <body> 	
  	<jsp:directive.include file="header.jsp" />
   
  <div id="content">  
  		
	    <h1>LinkUNEDin</h1>
	    <h3>Página de inicio del portal</h3>	    
	    <p>Este portal se ha creado para aquellos profesionales que decidan compartir con nosotros su currículo, así como, permitir una mejor entrada en el mercado laboral</p>
	   <!--  <p><html:link action="creaBD.do">Crear base de datos automática </html:link>(Crea la estructura de la base de datos para las pruebas).</p>
	    <p> Es la primera acción a realizar antes de utilizar las demás, para evitar errores por no haberse creado ninguna Base de Datos</p> -->
	    
	    <!-- Opción de consulta -->
	    <logic:equal name="administrarBean" property="adConsultar" value="false">
	    	<p class="hp"><html:link action="fromhomeconsulta.do">Hacer una consulta </html:link></p>
	    </logic:equal>
	    <logic:equal name="administrarBean" property="adConsultar" value="true">
	    	<p class="hp"><strong>Consulta de perfiles deshabilitada por el administrador</strong></p>
	    </logic:equal>
	    
	    <!-- Opción de alta de usuario -->
	    <logic:equal name="administrarBean" property="adAltaUsuario" value="false">
	    	<logic:empty name="loginBean" property="user_ID"><!-- Un usuario logueado no puede volver a darse de alta como usuario -->
	    		<p class="hp"><html:link action="fromhomealta.do">Darse de alta como usuario</html:link></p>
	    	</logic:empty>
	    </logic:equal>
	    <logic:equal name="administrarBean" property="adAltaUsuario" value="true">
	    	<p class="hp"><strong>Alta de usuarios deshabilitada por el administrador</strong></p>
	    </logic:equal>
	    
	    <!-- Opción de baja de usuario -->
	    <logic:equal name="administrarBean" property="adBajaUsuario" value="false">
	    	<logic:notEmpty name="loginBean" property="user_ID">	    
	    		<p class="hp"><html:link action="fromhomebaja.do">Darse de baja como usuario</html:link></p>
	    	</logic:notEmpty>
	    	<logic:empty name="loginBean" property="user_ID"><!-- Un usuario anonimo no puede darse de baja -->
	    		<p class="hp"><strong>Baja de usuarios inaccesible para un usuario anónimo</strong></p>
	    	</logic:empty>
	    </logic:equal>
	    <logic:equal name="administrarBean" property="adBajaUsuario" value="true">
	    	<p class="hp"><strong>Baja de usuarios deshabilitada por el administrador</strong></p>
	    </logic:equal>
	    
	    <!-- Opción de modificar un perfil -->
	    <logic:equal name="administrarBean" property="adModificarPerfil" value="false">
	    	<logic:notEmpty name="loginBean" property="user_ID">
	    		<p class="hp"><html:link action="fromhomemodificar.do">Modificar un perfil</html:link></p>
	    	</logic:notEmpty>
	    	<logic:empty name="loginBean" property="user_ID"><!-- Un usuario anonimo no puede modificar un perfil -->
	    		<p class="hp"><strong>Modificar un perfil inaccesible para un usuario anónimo</strong></p>
	    	</logic:empty>
	    </logic:equal>
	    <logic:equal name="administrarBean" property="adModificarPerfil" value="true">
	    	<p class="hp"><strong>Modifica un perfil deshabilitada por el administrador</strong></p>
	    </logic:equal>
	    
	    <!-- Opción de eliminar un perfil -->
	    <logic:equal name="administrarBean" property="adEliminarPerfil" value="false">
	    	<logic:notEmpty name="loginBean" property="user_ID">
	    		<p class="hp"><html:link action="fromhomeeliminar.do">Eliminar un perfil</html:link></p>
	    	</logic:notEmpty>
	    	<logic:empty name="loginBean" property="user_ID"><!-- Un usuario anonimo no puede eliminar un perfil -->
	    		<p class="hp"><strong>Eliminar un perfil inaccesible para un usuario anónimo</strong></p>
	    	</logic:empty>
	    </logic:equal>
	    <logic:equal name="administrarBean" property="adEliminarPerfil" value="true">
	    	<p class="hp"><strong>Eliminar un perfil deshabilitada por el administrador</strong></p>
	    </logic:equal>
	    
	    <!-- Opción de crear un perfil -->
	    <logic:equal name="administrarBean" property="adCrearPerfil" value="false">
	    	<logic:notEmpty name="loginBean" property="user_ID">
	    		<p class="hp"><html:link action="fromhomecrear.do">Crear un perfil</html:link></p>
	    	</logic:notEmpty>
	    	<logic:empty name="loginBean" property="user_ID"><!-- Un usuario anonimo no puede crear un perfil -->
	    		<p class="hp"><strong>Crear un perfil inaccesible para un usuario anónimo</strong></p>
	    	</logic:empty>
	    </logic:equal>
	    <logic:equal name="administrarBean" property="adCrearPerfil" value="true">
	    	<p class="hp"><strong>Crear un perfil deshabilitada por el administrador</strong></p>
	    </logic:equal>
	    <!-- Opciones del administrador -->
	   
	    <logic:notPresent name="loginBean" property="user_ID">  
            <p><strong>Para acceder a la función Administrar web, iniciar sesión con: usuario = admin contraseña = admin</strong></p>
           <!--  <p><strong>Para acceder a la función Eliminar Usuarios, iniciar sesión con: usuario = admin contraseña = admin</strong></p>   -->
        </logic:notPresent>      
	    <logic:equal name="loginBean" property="user_ID" value="admin">    	
	    	<p class="hp"><html:link page="/administrarPage.jsp">Administrar web</html:link></p>
	    	<!-- <p class="hp"><html:link page="/eliminarUsuariosPage.jsp">Eliminar Usuarios</html:link></p> -->
	    </logic:equal>
	    
	     <FIELDSET><LEGEND>Nota aclaratoria: </LEGEND>
	    	<p>Las opciones que aparecen a continuación se ofrecen para una mejor utilización de la página.</p>
	    	<p>Normalmente en una página WEB normal no aparecerían como opciones ni serían visibles</p>	    
	    	<p class="hp"><html:link action="mostrarBD.do">Mostrar Base de Datos</html:link></p>
	    	<p class="hp"><html:link action="addUsuarios.do">Añadir usuarios a la Base de datos</html:link></p>
	    </FIELDSET>
	    
	    
   </div>
 
    <jsp:directive.include file="footer.jsp" />   
  
  </body>
</html:html>
</jsp:root>