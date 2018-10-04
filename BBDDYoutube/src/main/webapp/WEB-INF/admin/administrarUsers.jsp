<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraContenido.jsp" %>

<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="row">
	<div class="col-md-12">
		<div class="table-responsive"> 
			<table class="table table-striped table-hover">
				<thead>
					<tr class="success">
						<th>ID</th>
						<th>NOMBRE</th>
						<th>PASSWORD</th>
						<th><a class="btn btn-sm btn-primary" href="usuarios?accion=insertar">Crear nuevo</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td>${usuario.id}</td>
							<td>${usuario.nombre}</td>
							<td>${usuario.password}</td>
							<td>
								<a class="btn btn-sm btn-info" href="usuarios?accion=editar&id=${usuario.id}">Editar</a>
								<a class="btn btn-sm btn-danger" href="usuarios?accion=borrar&id=${usuario.id}">Borrar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>