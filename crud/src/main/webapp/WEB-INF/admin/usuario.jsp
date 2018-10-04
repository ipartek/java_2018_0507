<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>


<!-- Dependiendo de la accion en la pagina usuario.jsp se cambian los botones -->

<form action="usuarios" method="get" class="form-horizontal">

	<c:choose>
		<c:when test="${accion=='insert'}">
			<h1>Inserta nuevo usuario</h1>
		</c:when>
		<c:when test="${accion=='update'}">
			<h1>Modificar usuario</h1>
		</c:when>
		<c:when test="${accion=='delete'}">
			<h1>Eliminar usuario</h1>
		</c:when>
	</c:choose>
	
	<input type="hidden" name="id" value="${usuario.id}" />

	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email"
				placeholder="Email" value="${usuario.email}"

				<c:if test="${accion=='delete'}">disabled="disabled"</c:if>
				
				> <span class="text-danger">Error en el email</span>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password"
				name="password" placeholder="Password" value="${usuario.password}"
				
				<c:if test="${accion=='delete'}">disabled="disabled"</c:if>
				
				> <span
				class="text-danger">Error en la password</span>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">
				<c:choose>
					<c:when test="${accion=='insert'}">Añadir</c:when>
					<c:when test="${accion=='update'}">Modificar</c:when>
					<c:when test="${accion=='delete'}">Borrar</c:when>
				</c:choose>
			</button>
			<a class="btn btn-danger" href="index">Cancelar</a>
		</div>
	</div>

</form>

<%@ include file="includes/pie.jsp"%>