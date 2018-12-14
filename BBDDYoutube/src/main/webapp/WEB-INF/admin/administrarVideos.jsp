<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraContenido.jsp" %>

<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="row">
	<div class="col-md-12">
		<c:if test="${mensaje!=null}">
			<div class="alert alert-info alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${mensaje}
			</div>
		</c:if>
		<div class="table-responsive"> 
			<table class="table table-striped table-hover">
				<thead>
					<tr class="success">
						<th>ID</th>
						<th>ID YOUTUBE</th>
						<th>NOMBRE</th>
						<th>USUARIO</th>
						<th><a class="btn btn-sm btn-primary" href="videos?accion=insertar">Crear nuevo</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${videos}" var="video">
						<tr>
							<td class="text-md-left">${video.id}</td>
							<td>${video.idVideo}</td>
							<td>${video.nombre}</td>
							<td>${video.nombreUsuario}</td>
							<td>
								<a class="btn btn-sm btn-info" href="videos?accion=editar&id=${video.id}">Editar</a>
								<a class="btn btn-sm btn-danger" href="videos?accion=borrar&id=${video.id}">Borrar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>