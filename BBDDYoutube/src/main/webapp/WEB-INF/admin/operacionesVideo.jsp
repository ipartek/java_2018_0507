<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraContenido.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<h2>
			<c:choose>
				<c:when test="${accion =='insertar'}">Inserción de nuevo video</c:when>
				<c:when test="${accion == 'editar'}">Modificación de video</c:when>
				<c:when test="${accion == 'borrar'}">Borrado de video</c:when>
			</c:choose>
		</h2>
		<div class="well bs-component">
			<form class="form-horizontal" action="videos?accion=${accion}" method="post">
				<input type="hidden" name="id" value="${video.id}" />
				<input type="hidden" name="accion" value="${accion}" />
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">ID Youtube</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="idYoutube" name="idYoutube"
						placeholder="ID Youtube" value="${video.idVideo}"
						<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nombre</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nombre"
							name="nombre" placeholder="Nombre" value="${video.nombre}"
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Usuario</label>
					<div class="col-sm-10">
						<select class="form-control" name='idUsuario'>
						    <c:forEach items="${usuarios}" var="usuario">
						        <option value="${usuario.id}" ${usuario.id == selectedUsuarioId ? 'selected' : ''}>${usuario.nombre}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button type="submit" class="btn btn-success">
							<c:choose>
								<c:when test="${accion == 'insertar'}">Añadir</c:when>
								<c:when test="${accion == 'editar'}">Modificar</c:when>
								<c:when test="${accion == 'borrar'}">Borrar</c:when>
							</c:choose>
						</button>
						<a class="btn btn-danger" href="administrar?accion=videos">Cancelar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>