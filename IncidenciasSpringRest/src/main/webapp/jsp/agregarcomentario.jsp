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
<body class="container-fluid">
<%@ include file="/jsp/index.jsp" %>
<div class="d-flex justify-content-center align-items-center container ">  
	<h2>Agregar Comentario</h2>

	<br>

	<form action="/addComentario">
		<div class="container-fluid">

			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<div class="form-group">
					<label for="equipo">Incidencia</label> 
					<select name="id_incidencia" id="id_incidencia" class="form-control input-normal">
					 <c:forEach var = "incidencia" items="${listaincidencia}">
        				 <option value="${incidencia.id}">${incidencia.id} - ${incidencia.titulo}</option>
     				 </c:forEach>
     				 </select>
				</div>
				<div class="form-group">
					<div class="form-group">
					<label for="equipo">Usuario</label> 
					<select name="usuario" id="usuario" class="form-control input-normal">
					 <c:forEach var = "usuario" items="${listausuario}">
        				 <option value="${usuario.email}">${usuario.id} - ${usuario.email}</option>
     				 </c:forEach>
     				 </select>
					</div>
				
				</div>
				
				<div class="form-group">
					<div class="form-group">
					<label for="fecha">Fecha</label> 
					<input name="fecha" id="fecha" type="text" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" required placeholder="Formato YYYY-MM-DD">
				</div>
			</div>
		</div>
		</div>
		<div class="container-fluid">

			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<div class="form-group">
						<div class="col-lg-4" id="userFormColumn2">
								<div class="form-group">
									<div class="form-group">
									<label for="comentario">Comentario</label> 
									<textarea name="comentario" id="comentario" rows="6" cols="100" maxlength="399"></textarea>
									</div>
								</div>
						</div>
					</div>
				</div>
			
			</div>
		</div>
		<center>
				<button class="btn btn-secondary">Guardar</button>
			</center>
	</form>
	
	</div>
</body>
</html>
