<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/includes/header.jsp"%>
<br />
<div>
	<h1>Listado de perros</h1>
	<div class="table-responsive">
		<table class="table table-hover">
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Raza</th>
				<th>Peso (kg)</th>
				<th>Apadrinado</th>
				<th>Nº de chip</th>
				<th>Última localización</th>
				<th><a href="#" class="btn btn-default">Añadir...</a></th>
			</tr>
			
			<c:forEach items="${perros}" var="perros">
			
			<tr>
				<td>${perros.id}</td>
				<td>${perros.nombre}</td>
				<td>${perros.edad}</td>
				<td>${perros.raza}</td>
				<td>${perros.peso}</td>
				<td>${perros.apadrinado}</td>
				<td>${perros.chip}</td>
				<td>${perros.latitud}- ${perros.longitud}</td>
				<td><a href="#" class="btn btn-default">Editar</a> <a href="#"
					class="btn btn-danger">Borrar</a></td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
</div>

<%@ include file="WEB-INF/includes/footer.jsp"%>
