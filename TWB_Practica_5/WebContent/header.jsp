<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<div id="logotipo">
	<a href="homePage.jsp" >
	  <img src="webhomelogo.gif" alt="Web logo" />
	</a>
</div>
<table align="center">
	<tr><td align="left">
		<div id="navigationbar">
			<span class="topnavigationlink">
			  <a class="a" href="homePage.jsp">Home</a>
			 </span>
			 <span class="topnavigationlink">
			  <a class="a" href="consultaPage.jsp">P&aacute;gina Consulta</a>
			 </span>
			 <span class="topnavigationlink">
			  <a class="a" href="contactoPage.jsp">Contacta con nosotros</a>
			 </span>
			 <span class="topnavigationlink">
			  <a class="a" href="ayudaPracticaTWB.htm" target="_blank">Ayuda</a>
			 </span>
			  <span class="topnavigationlink">
			  <a class="a" href="./memoriaArchivos/MemoriasTW.pdf" target="_blank">Memoria de la práctica(PDF)</a>
			 </span>
			 <span class="topnavigationlink">
			  <a class="a" href="./doc/index.html" target="_blank">Javadoc de la Práctica</a>
			 </span>
		</div>
	</td>
	<td align="right">
		<p align="right">Usuario:
		<logic:notEmpty name="loginBean" property="user_ID">			
			<bean:write name="loginBean" property="user_ID"/>
			<html:link page="/logout.jsp">  Terminar Sesion</html:link>	
		</logic:notEmpty>
		<logic:empty name="loginBean" property="user_ID">
			Anónimo
			<html:link page="/loginform.jsp">  Iniciar Sesión</html:link>
		</logic:empty>
		</p>
	</td></tr>
</table>


<!-- 
<p align="right">Usuario:
	 <logic:notEmpty name="loginBean" property="user_ID">			
		<bean:write name="loginBean" property="user_ID"/>
		<html:link page="/logout.jsp">  Terminar Sesion</html:link>	
	</logic:notEmpty>
	<logic:empty name="loginBean" property="user_ID">
		Anónimo
		<html:link page="/loginform.jsp">  Iniciar Sesión</html:link>
	</logic:empty>
	
</p>
	
<div id="navigationbar">
	<span class="topnavigationlink">
	  <a class="a" href="homePage.jsp">Home</a>
	 </span>
	 <span class="topnavigationlink">
	  <a class="a" href="consultaPage.jsp">P&aacute;gina Consulta</a>
	 </span>
	 <span class="topnavigationlink">
	  <a class="a" href="contactoPage.htm">Contacta con nosotros</a>
	 </span>
</div>

<div id="leftnavigation">
	<div class="leftnavigationlink">
	  	<a class="a" href="ayudaPage.htm">Ayuda</a>
	 </div>
	 <div class="leftnavigationlink">
	  	<a class="a" href="content.htm">Qui&eacute;nes somos</a>
	 </div>
	 <div class="leftnavigationlink">
	  	<a class="a" href="deal.htm">Mapa de Navegaci&oacute;n</a>
	 </div>
	 <div class="leftnavigationlink">
	  	<a class="a" href="more.htm">M&aacute;s info</a>
	 </div>
</div>



<p align="right">Usuario:
	 <logic:notEmpty name="loginBean" property="user_ID">			
		<bean:write name="loginBean" property="user_ID"/>
		<p align="right"><html:link page="/logout.jsp">Terminar Sesion</html:link></p>	
	</logic:notEmpty>
	<logic:empty name="loginBean" property="user_ID">
		Anónimo
		<p align="right"><html:link page="/loginform.jsp">Iniciar Sesión</html:link>
	</logic:empty>
	
</p>
-->
