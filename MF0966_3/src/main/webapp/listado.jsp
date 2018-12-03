<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

</head>
<body>
<h2>Listado</h2>
<a href="index.jsp">Agregar</a>

<a href="buscarxdni.jsp">Buscar por dni</a>

<br>

<table>

	<c:forEach items="${personaslist}" var="persona">
				<tr>
					<th class="text-center">${persona.nombre}
					
					</th>
					<td>${persona.dni}</td>
					<td>${persona.apellido1}</td>
					<td>${persona.calle}</td>
					<td><a href="ListadoPersonaServlet?accion=editar&id=${persona.id}">Editar ${persona.id}</a></td>
				
			
</c:forEach>
</table>
</body>
</html>
