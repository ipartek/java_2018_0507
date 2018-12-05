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
	<h2>Agregar Incidencia</h2>

	<br>

	<form action="/addIncidencia">
		<div class="container-fluid">
			<!-- Row 1 -->
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="fecha">Fecha: </label> 
					<input name="fecha" id="fecha" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="usuario_creador">Usuario Creador:</label> 
					<input name="usuario_creador" id="usuario_creador" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="titulo">Titulo</label> 
					<input name="titulo" id="titulo" class="form-control input-normal">
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<!-- Row 2 -->
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="descripcion">Descripcion</label> 
					<input name="descripcion" id="descripcion" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="equipo">Equipo</label> 
					<input name="equipo" id="mobile" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="usuario_asignado">Usuario Asignado</label> 
					<select name="usuario_asignado" id="level" class="form-control input-normal">
						<option value="1">Cargar</option>
						<option value="2">Cargar</option>
					</select>
					cargar desde db los usuarios
				</div>
			</div>
			<center>
				<button class="btn btn-secondary">Guardar</button>
			</center>
		</div>
	</form>
</body>
</html>
