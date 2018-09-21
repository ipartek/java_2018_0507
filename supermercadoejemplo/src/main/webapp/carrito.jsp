<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Administración Edición</h1>
</header>

<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Producto1</td>
			<td>12,34€</td>
			<td><a href="edicion.jsp?id=1&accion=delete">Borrar</a></td>
		</tr>
		<tr>
			<td>Producto2</td>
			<td>23,45€</td>
			<td><a href="edicion.jsp?id=2&accion=borrar">Borrar</a></td>
		</tr>
	</tbody>
</table>


<%@include file="/WEB-INF/includes/pie.jsp"%>