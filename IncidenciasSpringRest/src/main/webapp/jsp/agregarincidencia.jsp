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
	<h2>Agregar Incidencia</h2>

	<br>

	<form action="/addIncidencia">
		<div class="container-fluid">
			<!-- Row 1 -->
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="fecha">Fecha: </label> 
					<input name="fecha" id="fecha" class="form-control input-normal" required placeholder="YYYY-MM-DD" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="usuario_creador">Usuario Creador:</label> 
					<input name="usuario_creador" id="usuario_creador" class="form-control input-normal" required>
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="titulo">Titulo</label> 
					<input name="titulo" id="titulo" class="form-control input-normal" maxlength="45" required>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<!-- Row 2 -->
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="descripcion">Descripcion</label> 
					<input name="descripcion" id="descripcion"  maxlength="45" required class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="equipo">Equipo</label> 
					<select name="equipo" id="equipo" class="form-control input-normal">
					 <c:forEach var = "equipo" items="${listaequipos}">
        				 <option value="${equipo.nombre}">${equipo.nombre}</option>
     				 </c:forEach>
     				 </select>
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="usuario_asignado">Usuario Asignado</label> 
					<select name="usuario_asignado" id="usuario_asignado" class="form-control input-normal">
				
				 <c:forEach var = "usuario" items="${listausuarios}">
        				 <option value="${usuario.email}">${usuario.email}</option>
     				 </c:forEach>
				
     				 </select>
				</div>
			</div>
			
			<div class="container-fluid">
			<!-- Row 3 -->
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
				
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
						<label for="estado">Estado</label> 
					<select name="estado" id="estado" class="form-control input-normal">
					 <c:forEach var = "estado" items="${listaestados}">
        				 <option value="${estado.estado}">${estado.estado}</option>
     				 </c:forEach>
     				 </select>
				
		
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
				<br>
				<button class="btn btn-secondary">Guardar</button>
				
				</div>
			</div>
			
			
			
			
			
			
			
			
		</div>
	</form>
</body>
</html>
