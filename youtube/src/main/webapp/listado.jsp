<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="TF-8">

<link rel="stylesheet" href="css/all.css">

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/shop-item.css" rel="stylesheet">
</head>
<title>Listado</title>

</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Contraseña</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${listausus}" var="usuario">
				<tr>
					<th>${usuario.id}</th>
					<td>${usuario.email}</td>
					<td>${usuario.password}</td>
					<td><a class="btn btn-primary" href="inicio">Cancelar</a></td>
				</tr>
				
			</c:forEach>
		</tbody>
		
	</table>

</body>
</html>