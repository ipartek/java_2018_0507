
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <link rel=stylesheet href="../css/estilos.css">
        
    </head>
    <body>
    <%@include file="cabecera.jsp" %>
    <%@include file="menuarrib.jsp" %>
	  <div id="contenedor">
       	<div id="columnaIzq">
            <%@include file="menuizq.jsp" %>
        </div>
       <div class="informacion">
		<%@include file="principal.jsp" %>     
        </div>
    </div>    
</body>
<footer>
	 <%@include file="pie.jsp" %>
</footer> 
        
    </body>
</html>