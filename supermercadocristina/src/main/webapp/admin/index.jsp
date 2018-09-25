<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp" %>

<header>
	<h1>Administración</h1>
</header>

<table id="adminlistado">
	<thead>
		<tr>
			<th>Id</th><th>Nombre</th><th>Precio</th>
			<td><a href="edicion.jsp?accion=add">Añadir</a></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>1</th><td>Producto 1</td><td>12,34€</td>
			<td>
				<a href="edicion.jsp?id=1&accion=update">Editar</a>
				<a href="edicion.jsp?id=1&accion=delete">Borrar</a>
			</td>
		</tr>
		<tr>
			<th>2</th><td>Producto 2</td><td>23,45€</td>
			<td>
				<a href="edicion.jsp?id=2&accion=update">Editar</a>
				<a href="edicion.jsp?id=2&accion=delete">Borrar</a>
			</td>
		</tr>
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp" %>