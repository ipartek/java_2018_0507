<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<div class="container">

	<h2>Administración</h2>
	<p class="lead">Listado de productos</p>

	<hr />

	

	<table class="table table-striped table-bordered table-hover">

		<thead>
			<tr>
				<th>ID</th>
				<th>Título</th>
				<th>Precio</th>
				<th style="width: 10%"> <a class="btn btn-success add-to-cart-button" href="edicion?accion=add">Añadir</a></th>
					
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${productos}" var="producto">
		
			<tr>
				<th>${producto.id}</th>
				<td>${producto.nombre}</td>
				<td><fmt:formatNumber value="${producto.precio}" type="currency"/></td>
				<td><a class="btn btn-success add-to-cart-button" href="edicion?accion=update&id=${producto.id}">Editar</a>
				
				  <a class="btn btn-success add-to-cart-button" href="edicion?accion=delete&id=${producto.id}">Borrar</a>
				</td>
				
			</tr>
		</c:forEach>	
		</tbody>
	
	</table>


	<%@ include file="WEB-INF/includes/pie.jsp"%>