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
<body class="container-fluid">
<%@ include file="/jsp/index.jsp" %>
	<h2>Listado</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Nombre</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaequipos}" var="equipo">
				<tr>
					<form action="/modifEquipo">
					<td><input type="text" name="id" value="${equipo.id}" readonly class="form-control" /></td>
					<td><input type="text" name="email" value="${equipo.nombre}" class="form-control" /></td>
					<td><button class="btn btn-default">Guardar</button></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
