<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

</head>
<body>
<h2>Listado</h2>


<a href="buscarxdni.jsp">Buscar por dni</a>

<br>
<form action="ListadoPersonaServlet">
<table>

	<c:forEach items="${personasdni}" var="persona">
				<tr>
					<td><input type="text" name="id" value="${persona.id}" disabled/></td>
					<td>${persona.dni}</td>
					<td>Nombre: <input name="nombre" type=text value="${persona.nombre}"></td>
					<td>Apellido1 : <input name="apellido1" type=text value="${persona.apellido1}"></td>
					<td>Calle:<input name="calle" type=text value="${persona.calle}"></td>
					</tr><tr>
					<td>Numero:<input name="numero" type=text value="${persona.numero}"></td>
					<td>Email:<input name="email" type=text value="${persona.email}"></td>
					<td>Dni:<input name="dni" type=text value="${persona.dni}"></td>
					<td>Status:<input name="status" type=text value="${persona.status}"></td>
					<td><a href="ListadoPersonaServlet?accion=guardar&id=${persona.id}">Guardar ${persona.id}</a></td>
				
				</tr>
</c:forEach>
</table>
</form>
</body>
</html>
