
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp"%>

<header>
	<h1>Administración</h1>
</header>

<div class="mensaje">
</div>

<table id="adminlistado">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<td><a href="edicion?accion=add">Añadir</a></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${paginas}" var="pagina">
			<tr>
				<th>${pagina.id}</th>
				<td>${pagina.texto}</td>
				<td>${pagina.nick}</td>
				<td><a href="edicion?id=${pagina.id}&accion=update">Editar</a> <a
					href="edicion?id=${pagina.id}&accion=delete">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp"%>