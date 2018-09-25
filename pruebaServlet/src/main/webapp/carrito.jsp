<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<div class="container">

	<h2>Carrito</h2>
	<p class="lead">Su compra</p>

	<hr />

	

	<table class="table table-striped table-bordered table-hover">

		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<th>${producto.id}</th>
				<td>${producto.nombre}</td>
				<td>${producto.precio}</td>
				<td>	<a class="btn add-to-cart-button" href="carrito?accion=delete&id=${producto.id}">Borrar</a>
				  
				</td>
				
			</tr>
			</c:forEach>
		</tfoot>
	</table>


	<%@ include file="WEB-INF/includes/pie.jsp"%>