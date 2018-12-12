<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Ejemplo Bootstrap</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/estilos.css" />

<script src="../js/jquery-1.12.4.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/jsp/index.jsp" %>
	<h2>Agregar Equipo</h2>

	<br>

	<form action="/addEquipo">
		<div class="container-fluid">
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="nombre">Nombre: </label> 
					<input name="nombre" id="nombre" class="form-control input-normal">
				</div>
			</div>
			<center>
				<button class="btn btn-secondary">Guardar</button>
			</center>
		</div>
	</form>
</body>
</html>
