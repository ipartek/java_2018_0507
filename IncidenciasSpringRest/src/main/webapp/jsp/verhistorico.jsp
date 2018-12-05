<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

</head>
<body>
<h2>Listado</h2>

<table>
	<c:forEach items="${incidencia}" var="incidencia">
				<tr>
					<td><input type="text" name="id" value="${incidencia.id}" disabled/></td>
					<td>${incidencia.fecha}</td>
					<td>Creador: <input name="nombre" type=text value="${incidencia.usuario_creador}"></td>
					<td>Titulo : <input name="apellido1" type=text value="${incidencia.titulo}"></td>
					<td>Desc:<input name="calle" type=text value="${incidencia.descripcion}"></td>
					</tr><tr>
					<td>Equipo:<input name="numero" type=text value="${incidencia.equipo}"></td>
					<td>Usuario Asignado:<input name="email" type=text value="${incidencia.usuario_asignado}"></td>
				
				</tr>
</c:forEach>
</table>

</body>
</html>
