<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>

<!-- Dependiendo de la accion en la pagina video.jsp se cambian los botones -->

<form action="videos" method="post" class="form-horizontal">

	<c:choose>
		<c:when test="${accion=='insert'}">
			<h1>Inserta nuevo video</h1>
		</c:when>
		<c:when test="${accion=='update'}">
			<h1>Modificar video</h1>
		</c:when>
		<c:when test="${accion=='delete'}">
			<h1>Eliminar video</h1>
		</c:when>
	</c:choose>
	
	<input type="hidden" name="accion" value="${accion}" />
	<input type="hidden" name="id" value="${video.id}" /> 

	<div class="form-group">
		<label for="idvideo" class="col-sm-2 control-label">Id (url)</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="idVideo" name="idVideo"
				placeholder="IdVideo" value="${video.idVideo}"
				<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
		</div>
	</div>
	<div class="form-group">
		<label for="nombre" class="col-sm-2 control-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre"
				placeholder="Nombre" value="${video.nombre}"
				<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
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

<%@ include file="includes/footer.jsp"%>