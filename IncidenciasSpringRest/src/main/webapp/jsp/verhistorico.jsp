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
				<th scope="col">Fecha Creacion</th>
				<th scope="col">Usuario Creador</th>
				<th scope="col">Titulo</th>
				<th scope="col">Descripcion</th>
				<th scope="col">Equipo</th>
				<th scope="col">Usuario Asignado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaincidencia}" var="incidencia">
			
				<tr>
				<form action="/modifIncidencia">
					<td><input name="id" type="text" value="${incidencia.id}" readonly class="form-control  input-sm" /></td>
					<td><input name="fecha" type="text" value="${incidencia.fecha}" readonly class="form-control" /></td>
					<td><input name="usuario_creador" type=text value="${incidencia.usuario_creador}" class="form-control"></td>
					<td><input name="titulo" type=text value="${incidencia.titulo}" class="form-control"></td>
					<td><input name="descripcion" type=text value="${incidencia.descripcion}" class="form-control"></td>
					<td><input name="equipo" type=text value="${incidencia.equipo}" class="form-control"></td>
					<td><input name="usuario_asignado" type=text value="${incidencia.usuario_asignado}" class="form-control"></td>
					<td><button class="btn btn-default">Guardar</button></td>
				</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
