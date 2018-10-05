<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraContenido.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<h2>
			<c:choose>
				<c:when test="${accion =='insertar'}">Inserción de nuevo usuario</c:when>
				<c:when test="${accion == 'editar'}">Modificación de usuario</c:when>
				<c:when test="${accion == 'borrar'}">Borrado de usuario</c:when>
			</c:choose>
		</h2>
		<div class="well bs-component">
			<form class="form-horizontal" action="usuarios?accion=${accion}" method="post">
				<input type="hidden" name="id" value="${usuario.id}" />
				<input type="hidden" name="accion" value="${accion}" />
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nick</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nombre" name="nombre"
							placeholder="Nombre" value="${usuario.nombre}"
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Contraseña</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password" value="${usuario.password}"
							<c:if test="${accion=='borrar'}">disabled="disabled"</c:if>>
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
						<a class="btn btn-danger" href="administrar?accion=users">Cancelar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>