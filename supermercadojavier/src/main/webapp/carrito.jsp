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
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<td>${producto.nombre}</td>
				<td><fmt:formatNumber value="${producto.precio}" type="currency"/></td>
				<td><a href="carrito.jsp?id=${producto.id}&accion=delete">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp"%>