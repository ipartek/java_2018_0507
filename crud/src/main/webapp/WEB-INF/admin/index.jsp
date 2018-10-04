<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<div class="alert alert-success alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	Se ha hecho la operación correctamente
</div>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Email</th>
			<th>Password</th>
			<th><a class="btn btn-primary" href="usuarios?accion=add">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>1</th>
			<td>falso@email.com</td>
			<td>falso</td>
			<td><a class="btn btn-primary"
				href="usuarios?accion=editar&id=1">Editar</a> <a
				class="btn btn-danger" href="usuarios?accion=borrar&id=1">Borrar</a>
			</td>
		</tr>
	</tbody>
</table>

<%@ include file="includes/pie.jsp"%>