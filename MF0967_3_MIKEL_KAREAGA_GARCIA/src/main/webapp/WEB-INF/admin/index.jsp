<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>
<c:if test="${mensaje != null}">
	<div class="alert alert-success alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	${mensaje}
</div>
</c:if>

<form action="buscarPerro" method="post">
		Buscar perro <input class="form-control" type="search" name="palabra" />
	</form>
	
	<ul>
	<c:forEach items="${resultado}" var="nombreResultado">
		<li><a href="index?perro=${nombreResultado}">${nombreResultado}</a>
	</c:forEach>
	</ul>
	
<table class="table">
<thead>
		<tr>
			<th>Chip</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Raza</th>
			<th>Peso</th>
			<th>Apadrinado</th>
			<th>Identificacion</th>
			<th>Altitud</th>
			<th>Latitud</th>
			<th><a class="btn btn-primary" href="perros?accion=insert">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${perros}" var="perro">
		<tr>
			<th>${perro.id}</th>
			<td>${perro.nombre}</td>
			<td>${perro.edad}</td>
			<td>${perro.raza}</td>
			<td>${perro.peso}</td>
			<td>${perro.apadrinado}</td>
			<td>${perro.identificacion}</td>
			<td>${perro.altitud}</td>
			<td>${perro.latitud}</td>
			<td><a class="btn btn-primary"
					href="perros?accion=update&id=${perro.id}">Editar</a> <a
					class="btn btn-danger" href="perros?accion=delete&id=${perro.id}">Borrar</a>
				</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="includes/pie.jsp"%>