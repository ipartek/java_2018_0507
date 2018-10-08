<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp"%>
<div class="container">

	<h2>Administración</h2>
	<p class="lead">Usuarios</p>

	<hr />



	<table class="table table-striped table-bordered table-hover">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Contraseña</th>
				<th style="width: 10%"><a
					class="btn btn-success add-to-cart-button"
					href="listado?accion=add">Añadir</a></th>

			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${listadoUsuarios}" var="usuario">

				<tr>
					<th>${usuario.id}</th>
					<td>${usuario.email}</td>
					<td>${usuario.password}</td>
					
					<td><a class="btn btn-success add-to-cart-button"
					href="listado?accion=edit&id=${usuario.id}">Editar</a> <a
						class="btn btn-success add-to-cart-button"
					href="listado?accion=delete&id=${usuario.id}">Borrar</a></td>

				</tr>
			</c:forEach>
		</tbody>

	</table>


	<%@ include file="/WEB-INF/includes/pie.jsp"%>