<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>

	<h1>Principal</h1>
	<h2>Bienvenido ${usuario.nombre}</h2>

	<c:if test="${usuario == null}">
		<h1>¡¡¡¿¿¿Cómo narices has llegado aquí????!!!</h1>
	</c:if>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>NickName</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<th>${u.id}</th>
					<td>${u.nickName}</td>
					<td>${u.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
