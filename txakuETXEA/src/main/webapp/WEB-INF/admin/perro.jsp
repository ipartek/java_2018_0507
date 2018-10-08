<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<form action="perro" method="post" class="form-horizontal">
	<fieldset>
		
		<input type="hidden" name="id" value="${perro.id}" />
		<input type="hidden" name="accion" value="${accion}" />
		
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nombre" name="nombre"
					placeholder="Nombre" value="${perro.nombre}">
			</div>
		</div>
		<div class="form-group">
			<label for="edad" class="col-sm-2 control-label">Edad</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="edad"
					name="edad" placeholder="Edad" value="${perro.edad}">
			</div>
		</div>
		<div class="form-group">
			<label for="raza" class="col-sm-2 control-label">Raza</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="raza"
					name="raza" placeholder="Raza" value="${perro.raza}">
			</div>
		</div>
		<div class="form-group">
			<label for="peso" class="col-sm-2 control-label">Peso</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="peso"
					name="peso" placeholder="Peso" value="${perro.peso}">
			</div>
		</div>
		
		<div class="form-group">
			<label for="apadrinado" class="col-sm-2 control-label">Apadrinado</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="apadrinado" name="apadrinado" placeholder="SI / NO" value="${perro.apadrinado}">
			</div>
		</div>
		
		<div class="form-group">
			<label for="chip" class="col-sm-2 control-label">Chip</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="chip" name="chip" placeholder="Formato DD-DDDD-AAAA" value="${perro.chip}">
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
	</fieldset>
</form>

<%@ include file="includes/footer.jsp"%>