<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/Include/cabecera.jsp"%>


<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Email</th>
			<th>Password</th>
			<th><a class="btn btn-primary" href="edicion?accion=insert">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listado}" var="usus">
			<tr>
				<th>${usus.id}</th>
				<td>${usus.email}</td>
				<td>${usus.password}</td>
				<td><a class="btn btn-primary"
					href="edicion?accion=update&id=${usus.id}">Editar</a> <a
					class="btn btn-danger" href="edicion?accion=delete&id=${usus.id}">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/Include/pie.jsp"%>