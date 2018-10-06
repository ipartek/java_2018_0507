<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/admin/includes/cabecera.jsp"%>

<c:if test="${mensaje!=null}">
<div class="alert alert-success alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	${mensaje}
</div>
</c:if>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Email</th>
			<th>Password</th>
			<th><a class="btn btn-primary" href="usuarios?accion=insert">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<th>${usuario.id}</th>
				<td>${usuario.email}</td>
				<td>${usuario.password}</td>
				<td><a class="btn btn-primary"
					href="usuarios?accion=update&id=${usuario.id}">Editar</a> <a
					class="btn btn-danger" href="usuarios?accion=delete&id=${usuario.id}">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/admin/includes/pie.jsp"%>