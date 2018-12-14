<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Incidencias</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/estilos.css" />

<script src="../js/jquery-1.12.4.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/jsp/index.jsp" %>
<div class="d-flex justify-content-center align-items-center container ">  
	<h2>Agregar Usuario</h2>

	<br>

	<form action="/addUsuario">
		<div class="container-fluid">
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="email">Email: </label> 
					<input name="email" id="email" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="password">Password:</label> 
					<input name="password" id="password" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<div class="form-group">
					<label for="equipo">Equipo</label> 
					<select name="equipo" id="equipo" class="form-control input-normal">
					 <c:forEach var = "equipo" items="${listaquipos}">
        				 <option value="${equipo.nombre}">${equipo.nombre}</option>
     				 </c:forEach>
     				 </select>
				</div>
				
				</div>
			</div>
		</div>
			<center>
				<button class="btn btn-secondary">Guardar</button>
			</center>
		</div>
	</form>
	
	</div>
</body>
</html>
