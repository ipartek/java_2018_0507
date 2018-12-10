<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">

<meta charset="UTF-8">
</head>
<body>
<%@ include file="/jsp/index.jsp" %>
	<h2>Listado</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Email</th>
				<th scope="col">Password</th>
				<th scope="col">Equipo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listausuarios}" var="usuario">
				<tr>
					<td><input type="text" name="id" value="${usuario.id}" disabled class="form-control" /></td>
					<td><input type="text" name="text" value="${usuario.email}" disabled class="form-control" /></td>
					<td><input name="password" type="text" value="${usuario.password}" disabled class="form-control"></td>
					<td><input name="equipo" type="text" value="${usuario.equipo}" disabled class="form-control"></td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
