<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>
<h2>Buscar</h2>



<form action="BuscarxDNIServlet" method="post">
	
	DNI: <input type="text" name="dni" id="dni"  maxlength="9"/>

	<button>Aceptar</button>
</form>



<table>

	<c:forEach items="${personasdni}" var="persona">
				<tr>
					<th class="text-center">${persona.nombre}
					
					</th>
					<td>${persona.dni}</td>
					<td>${persona.apellido1}</td>
					<td>${persona.calle}</td>
					<td><a href="ListadoPersonaServlet?accion=Editar&id=${persona.id}">Editar ${persona.id}</a></td>
				
			
	</c:forEach>
</table>
</body>
</html>
