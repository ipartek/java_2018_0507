<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<h2>
			<c:choose>
				<c:when test="${accion =='insertar'}">Inserción de nuevo perro</c:when>
				<c:when test="${accion == 'editar'}">Modificación de perro</c:when>
				<c:when test="${accion == 'borrar'}">Borrado de perro</c:when>
			</c:choose>
		</h2>
		<div class="well bs-component">
			<form class="form-horizontal" action="perros?accion=${accion}" method="post">
				<input type="hidden" name="id" value="${perro.id}" />
				<input type="hidden" name="accion" value="${accion}" />
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nombre</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nombre"
							name="nombre" placeholder="Nombre" value="${perro.nombre}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="edad" class="col-sm-2 control-label">Edad</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="edad"
							name="edad" placeholder="Edad" value="${perro.edad}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="raza" class="col-sm-2 control-label">Raza</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="raza"
							name="raza" placeholder="Raza" value="${perro.raza}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="peso" class="col-sm-2 control-label">Peso</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="peso"
							name="peso" placeholder="Peso" value="${perro.peso}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="apadrinado" class="col-sm-2 control-label">Apadrinado</label>
					<div class="col-sm-10">
						<select class="form-control" name='apadrinado' 
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
							<c:choose>
								<c:when test="${perro.apadrinado == 0 }">
									<option value="0" selected>NO apadrinado</option>
								</c:when>
								<c:otherwise>
									<option value="0">NO apadrinado</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${perro.apadrinado == 1 }">
									<option value="1" selected>Apadrinado</option>
								</c:when>
								<c:otherwise>
									<option value="1">Apadrinado</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="chip" class="col-sm-2 control-label">Chip</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="chip" pattern="[0-9]{2}-[0-9]{4}-[0-9]{4}"
							name="chip" placeholder="Chip" value="${perro.getChip().getChip()}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="latitud" class="col-sm-2 control-label">Latitud</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="latitud"
							name="latitud" placeholder="Latitud" value="${perro.getChip().getLatitud()}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
					</div>
				</div>
				<div class="form-group">
					<label for="longitud" class="col-sm-2 control-label">Longitud</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="longitud"
							name="longitud" placeholder="Longitud" value="${perro.getChip().getLongitud()}" required
							<c:if test="${accion == 'borrar'}">disabled="disabled"</c:if>>
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
						<a class="btn btn-danger" href="index">Cancelar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>