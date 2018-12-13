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
				<th scope="col">Estado</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaestados}" var="estado">
				<tr>
					<form action="/modifEstado">
					<td><input type="text" name="id" value="${estado.id}" readonly class="form-control" /></td>
					<td><input type="text" name="estado" value="${estado.estado}" class="form-control" /></td>
					<td><button class="btn btn-default">Guardar</button></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
