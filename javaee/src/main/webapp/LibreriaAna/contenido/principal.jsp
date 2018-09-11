<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel=stylesheet href="../css/estilos.css">
        
    </head>
    <body>
    <%@include file="header.jsp" %>
    <%@include file="menuarrib.jsp" %>
	  <div id="contenedor">
       	<div id="columnaIzq">
            <%@include file="menuizq.jsp" %>
        </div>
       <div class="informacion">
		<%@include file="infoprincipal.jsp" %>     
        </div>
    </div>    
</body>
<footer>
	 <%@include file="pie.jsp" %>
  
</footer> 
        
        
        
        
    </body>
</html>