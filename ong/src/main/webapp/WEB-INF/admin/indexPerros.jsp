<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>


<div class="container">

	<h1 class="p-4">Zona administracion de perros</h1>

	<c:if test="${mensaje!=null}">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${mensaje}
		</div>
	</c:if>

	<table
		class="table table-hover table-responsive w-100 d-block d-md-table bg-white">
		<thead>
			<tr class="table-primary">		
				<th>Id</th>
				<th>Nombre</th>
				<th>Raza</th>
				<th>Edad</th>
				<th>Peso (kg)</th>
				<th>Apadrinado</th>
				<th>Nº de identificacion</th>
				<th>Latitud</th>
				<th>Longitud</th>
				<th><a class="btn btn-primary" href="perros?accion=insert">Añadir</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="perro">
				<tr>
					<th>${perro.id}</th>
					<td>${perrop.nombre}</td>
					<td>${perro.raza}</td>
					<td>${perro.edad}</td>
					<td>${perro.peso}</td>
					<td>${perro.apadrinado}</td>
					<td>${perro.numIdent}</td>
					<td>${perro.latitud}</td>
					<td>${perro.longitud}</td>
				<!-- <td><a class="btn btn-primary"
						href="perros?accion=update&id=${perro.id}">Editar</a> <a
						class="btn btn-danger" href="perros?accion=delete&id=${perro.id}">Borrar</a>
					</td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="includes/footer.jsp"%>