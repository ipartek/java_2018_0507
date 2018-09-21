<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Carrito</h1>
</header>

<table id="carritolistado">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Producto 1</td>
			<td>12,34€</td>
			<td>
				<a href="edicion.jsp?id=1&accion=delete">Borrar</a>
			</td>
		</tr>
		<tr>
			<td>Producto 2</td>
			<td>23,45€</td>
			<td>
				<a href="edicion.jsp?id=2&accion=delete">Borrar</a>
			</td>
		</tr>
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp"%>