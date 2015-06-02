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
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	<script type="text/JavaScript">
	 	function cambiar(esto){
                vista=document.getElementById(esto).style.display;
                if (vista=='none')
                    vista='block';
                else
                    vista='none';
                                
                document.getElementById(esto).style.display = vista;
         }
	</script>
	<title>Edita perfil</title>
</head>
<body>
 	<jsp:directive.include file="header.jsp" /> 
 	<div id="content">
		<h1>${opcionSelec} perfil</h1>
			<!-- el action tendrá que ir hacia processCrear -->
		<html:form action="/processCrear" enctype="multipart/form-data" >
			
			<fieldset><legend>Perfil del usuario : <jsp:getProperty property="user_ID" name="loginBean"/></legend>
				<table>
				<tr><th><label for="pais">País:</label></th> 
<!--  				<td><html:text property="pais" /></td>    -->
 					<td><html:select property="pais" name="perfilBean">
					<c:forEach var="lP" items="${listaPaises}">
						<html:option value="${lP.key}">${lP.value}</html:option> 					
					</c:forEach>
					</html:select>
					</td>    
				</tr>
				<tr><th><label for="provincia">Provincia:</label></th>
					<td><html:text property="provincia" name="perfilBean"/></td>
				</tr>
				<tr><th><label for="localidad">Localidad:</label></th>
					<td><html:text property="localidad" name="perfilBean"/></td>
				</tr>
				<tr><th><label for="direccion">Dirección:</label></th>
					<td><html:text property="direccion" name="perfilBean"/></td>
				</tr>
				<tr>
					<c:choose>
					<c:when test="${perfilBean.pdf=='' || perfilBean.pdf == null}">
						<th><label for="pdf_file">PDF:</label></th>
						<td><html:file property="pdf_file" value="perfilBean"/></td>
						<td><html:submit property="accion" value="Nuevo Archivo PDF"/></td>
					</c:when>
					<c:otherwise>
						<th>PDF:</th>
						<td>${perfilBean.pdf}</td>
						<td><html:submit property="accion" value="Eliminar Archivo PDF"></html:submit></td>
					</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<c:choose>
					<c:when test="${perfilBean.fotografia=='' || perfilBean.fotografia==null}">
						<th><label for="fotografia_file">Fotografía:</label></th>
						<td><html:file property="fotografia_file" value="perfilBean" /></td>
						<td><html:submit property="accion" value="Nueva Fotografía" /></td>
					</c:when>
					<c:otherwise>
						<th>Fotografía:</th>
						<td>${perfilBean.fotografia}</td>
						<td><html:submit property="accion" value="Eliminar Foto"></html:submit></td>
					</c:otherwise>
					</c:choose>
				</tr> 
				<tr><td> </td></tr>
				<tr><td colspan="3">
					<!-- <p><a href="#" onclick="cambiar('ayuda'); return false;"><b>Abrir Ayuda</b></a></p> -->	
					<fieldset style="background-color:#FFFFC7"><LEGEND><a href="#" onclick="cambiar('ayuda1'); return false;"><b>Mostrar ayuda</b></a></LEGEND>
						<div id="ayuda1" style="display:none;">
							<table>
							<tr><td>Para añadir una foto o un pdf, primero pulsar Examinar y eligir el archivo a incluir</td></tr>
							<tr><td>Después pulsar Nuevo Archivo PDF o Nueva Fotografía antes de pulsar Guardar Cambios</td></tr>
							<tr><td>Para eliminar, pulsar Eliminar Archivo PDF o Eliminar Foto</td></tr>
							</table>
				 			<a href="#" onclick="cambiar('ayuda1'); return false;"><b>Cerrar ayuda</b></a>	
						</div>
					</fieldset>			
				</td>
				</tr>
				</table>
			</fieldset>			
			<table>
			<tr>
			<td><fieldset><legend>Titulaciones:</legend>
					<table>
						<c:forEach var="titu" items="${perfilBean.listaTit}">
							<tr>
								<c:forEach var="titula" items="${listaTitulaciones}">
		 							<c:if test="${titula.titulacion_ID == titu}">
		 								<tr><th>Titulación: </th>
		 									<td>${titula.nombre_Tit}</td>
		 								 	<td><html:submit property="accion" value="Eliminar Titulac. : ${titula.titulacion_ID}"></html:submit></td> 
		 								</tr>
		 							</c:if>
	 							</c:forEach>
							</tr>
						</c:forEach>	
					<tr>
 						<td><label for="titulacion_ID">Añadir Titulación:</label></td>
 					 	<!-- 	<td><html:text property="nombre_Tit" /></td>      -->
					 	<td><html:select property="titulacion_ID" name="perfilBean">					 
						<c:forEach var="titu"  items="${listaTitulaciones}" >
							 <c:set var="titu_ID" scope="request" value= "${titu.titulacion_ID}"/>
							 <c:set var="titu_nombre" scope="request" value="${titu.nombre_Tit}"/>
							 <html:option value="${titu_ID}">${titu_nombre}</html:option>					 
						</c:forEach> 					
				 		</html:select>
				 		</td>  
				 		<td><html:submit property="accion" value="Nueva Titulación"></html:submit> </td>
				 		<!--   		<html:text property="nombre_Tit"><c:out value="${titu_nombre}"/></html:text>    
						<td><html:errors property="titulacion_ID" /></td>
					 	<td><A HREF="javascript:newTitulacion('${titu_nombre}')">Agregar otra Titulación</A></td>  -->
					</tr>
					<tr><td> </td></tr>
					<tr><td colspan="3">
						<fieldset style="background-color:#FFFFC7"><LEGEND><a href="#" onclick="cambiar('ayuda2'); return false;"><b>Mostrar ayuda</b></a></LEGEND>
							<div id="ayuda2" style="display:none;">
								<table>
								<tr><td>Para añadir, seleccionar una titulación en el desplegable y pulsar Nueva Titulación</td></tr>
								<tr><td>Para eliminar, pulsar Eliminar Titulac.</td></tr>
								</table>
							 	<a href="#" onclick="cambiar('ayuda2'); return false;"><b>Cerrar ayuda</b></a>	
							</div>
						</fieldset>	
					</td>
					</tr>
					</table>
				</fieldset>
				</td></tr>
				</table>
				<table>
				<tr><td>
					<fieldset><LEGEND>Tecnologías</LEGEND>	
						<table>
							<c:forEach var="tecn" items="${perfilBean.listaTec}" >
								<c:forEach var="tecnol" items="${listaTecnologias}">
			 						<c:if test="${tecnol.tecnologia_ID == tecn}">
			 							<tr><th>Tecnología: </th><td>${tecnol.nombre_Tec}</td>
			 							<td><html:submit property="accion" value="Eliminar Tecnolo. : ${tecnol.tecnologia_ID}"></html:submit> </td> 
			 							</tr>
			 						</c:if>
			 					</c:forEach>
							</c:forEach>
						<tr>
						<td><label for="tecnologia_ID">Añadir Tecnología:</label></td>
						 <td><html:select property="tecnologia_ID" multiple= "multiple">
							  	<c:forEach var="tecn"  items="${listaTecnologias}" >
						 		<c:set var="tecn_ID" scope="page" value= "${tecn.tecnologia_ID}"/>
						 		<html:option value="${tecn_ID}">${tecn.nombre_Tec}</html:option>					 
							</c:forEach> 
						 	</html:select></td>  
						<td><html:submit property="accion" value="Nueva Tecnología"></html:submit> </td>
						</tr>
						<tr><td> </td></tr>
						<tr><td colspan="3">
							<fieldset style="background-color:#FFFFC7"><LEGEND><a href="#" onclick="cambiar('ayuda3'); return false;"><b>Mostrar ayuda</b></a></LEGEND>
							<div id="ayuda3" style="display:none;">
								<table>
								<tr><td>Para añadir, seleccionar una tecnología en el desplegable y pulsar Nueva Tecnología</td></tr>
								<tr><td>Para eliminar, pulsar Eliminar Tecnolo.</td></tr>
								</table>
								 <a href="#" onclick="cambiar('ayuda3'); return false;"><b>Cerrar ayuda</b></a>	
							</div>
							</fieldset>	
						</td>
						</tr>
						</table>
					</fieldset>
				</td>				
				</tr>
				</table>
				<fieldset><LEGEND>Experiencia: </LEGEND>
					<table>
						<c:forEach var="expe" items="${perfilBean.listaExp}">
							<tr><td>
							<fieldset>
								<table>					
								<tr><th>Empresa</th><td>${expe.empresa}</td></tr>
								<tr><th>Cargo</th><td>${expe.cargo}</td></tr>
								<tr><th>Año de Inicio</th><td>${expe.a_Inicio}</td></tr>
								<tr><th>Año de Finalización</th><td>${expe.a_Fin}</td></tr>
								</table>
							</fieldset>
							</td>
							<td><html:submit property="accion" value="Eliminar Experie. : ${expe.exp_ID}"></html:submit> </td>
							</tr>
						</c:forEach>
					<tr><td>				
						<fieldset><legend>Nueva Experiencia:</legend>				
 							<table>
							<tr><th><label for="empresa">Empresa:</label></th>
							<td><html:text property="empresa" name="perfilBean"  /></td>
							<td><html:errors property="empresa" /></td>
							</tr>
							<tr><th><label for="cargo">Cargo:</label></th>
							<td><html:text property="cargo" name="perfilBean"/></td>
							<td><html:errors property="cargo" /></td>
							</tr>
							<tr><th><label for="a_Inicio">Año de inicio:</label></th>
							<td><html:text property="a_Inicio" name="perfilBean"/></td>
							<td><html:errors property="a_Inicio" /></td>
							</tr>
							<tr><th><label for="a_Fin">Año de finalización:</label></th>
							<td><html:text property="a_Fin" name="perfilBean"/></td>
							<td><html:errors property="a_Fin" /></td>
							</tr>	
							</table>
						</fieldset>
					</td>
					<td><html:submit property="accion" value="Nueva Experiencia"></html:submit> </td>
					</tr>
					<tr><td> </td></tr>
					<tr><td colspan="3">
						<fieldset style="background-color:#FFFFC7"><LEGEND><a href="#" onclick="cambiar('ayuda4'); return false;"><b>Mostrar ayuda</b></a></LEGEND>
							<div id="ayuda4" style="display:none;">
								<table>
								<tr><td>Para añadir una Experiencia, rellenar todos los campos y pulsar Nueva Experiencia</td></tr>
								<tr><td>Para eliminar, pulsar Eliminar Experie.</td></tr>
								</table>
				 				<a href="#" onclick="cambiar('ayuda4'); return false;"><b>Cerrar ayuda</b></a>	
							</div>
						</fieldset>	
					</td>
					</tr>						
					</table>
				</fieldset>
				<p></p>
				<html:submit property="accion" value="Guardar Cambios"></html:submit>
				<p></p>
		</html:form>
		<p></p>
		<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
