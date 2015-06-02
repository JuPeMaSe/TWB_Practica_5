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
	<title>Consulta</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	 
	<div id="content">
		
		<h1>Página de Consulta</h1>
		<html:form action="/processConsulta"> 
		<fieldset>
			<table>
				
				<tr>
					<td><html:checkbox property="chkPais"/></td>
					<th><label for="pais">País:</label></th> 
<!-- 						<td><html:text property="pais" /></td> -->
					<td align="left">
					<html:select property="pais">
						<c:forEach var="lP" items="${listaPaises}">
							<html:option value="${lP.key}">${lP.value}</html:option> 					
						</c:forEach>
					 </html:select>
					 </td>					
					<td><html:errors property="pais" /></td>
					
				</tr>
				<tr>
					<td><html:checkbox property="chkProvincia"></html:checkbox></td>
					<th><label for="provincia">Provincia:</label></th>
					<td align="left"><html:text property="provincia" /></td>
					<td><html:errors property="provincia" /></td>
				</tr>
				<tr>
					<td><html:checkbox property="chkLocalidad"></html:checkbox></td>
					<th><label for="localidad">Localidad:</label></th>
					<td align="left"><html:text property="localidad" /></td>
					<td><html:errors property="localidad" /></td>
				</tr>
				<tr>
				 	<td><html:checkbox property="chkTecnologia"></html:checkbox></td>
					<th><label for="tecn_ID">Tecnología:</label></th>
					<td align="left"><html:select property="tecn_ID">
					 		<c:forEach var="tecn"  items="${listaTecnologias}" >
					 		<c:set var="tecn_ID" scope="request" value= "${tecn.tecnologia_ID}"/>
					 		<html:option value="${tecn_ID}">${tecn.nombre_Tec}</html:option>					 
							</c:forEach> 
					 	</html:select></td>  
					<td><html:errors property="tecn_ID" /></td>
				</tr>
				<tr>
					<td><html:checkbox property="chkTitulacion"></html:checkbox></td>
					<th><label for="titu_ID">Titulación:</label></th>
				<!-- 	<td><html:text property="nombre_Tit" /></td> -->
					<td align="left"><html:select property="titu_ID">
				 		 <c:forEach var="titu"  items="${listaTitulaciones}" >
					 		<c:set var="titu_ID" scope="request" value= "${titu.titulacion_ID}"/>
					 		<html:option value="${titu_ID}">${titu.nombre_Tit}</html:option>					 
					 	</c:forEach> 
				 		</html:select></td>  
					<td><html:errors property="titu_ID" /></td>
				</tr>
				<tr>
					<td><html:checkbox property="chkExperiencia"></html:checkbox></td>
					<th><label for="a_Experiencia">Años de experiencia:</label></th>
					<td align="left"><html:text property="a_Experiencia" /></td>
					<td><html:errors property="a_Experiencia" /></td>
				</tr>
					
				
			</table>
			</fieldset>
			<p></p>		
			<p><html:errors property="consulta"/></p>						
			<html:submit>Consultar</html:submit>
			<p></p>
		</html:form>
		
		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<fieldset style="background-color:#FFFFC7">
		Para hacer una consulta:
		<ol>
			<li>Marque la casilla de chequeo y elija el valor que desea</li>
			<li>Después pulse el botón "Consultar"</li>
		</ol>  
	</fieldset>	
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
