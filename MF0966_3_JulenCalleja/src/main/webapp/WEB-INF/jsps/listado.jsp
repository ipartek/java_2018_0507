<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado</title>
</head>
<body>
<h1>Las ultimas 50 personas de la Base de datos</h1>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Direccion</th>
				<th>Numero Portal</th>
				<th>Email</th>
				<th>Dni</th>
				<th>Puesto</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${gente}" var="gente">
				<tr>
					<td>${gente.nombre}</td>
					<td>${gente.apellido}</td>
					<td>${gente.direccion}</td>
					<td>${gente.nPortal}</td>
					<td>${gente.email}</td>
					<td>${gente.dni}</td>
					<td>${gente.puesto}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button></button>

</body>
</html>