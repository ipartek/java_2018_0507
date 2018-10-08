<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="includes/cabecera.jsp"%>
<form action="perros" method="post" class="form-horizontal">
	<fieldset>
		<legend>
			<c:choose>
				<c:when test="${accion=='insert'}">Insertar un nuevo perro</c:when>
				<c:when test="${accion=='update'}">Modificar perro</c:when>
				<c:when test="${accion=='delete'}">Borrar perro</c:when>
			</c:choose>
		</legend>
		<input type="hidden" name="id" value="${perro.id}" />
		<input type="hidden" name="accion" value="${accion}" />
		
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-10">
				<input type="id" class="form-control" id="id" name="id"
					placeholder="Id" value="${perro.id}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
				<input type="nombre" class="form-control" id="nombre" name="nombre"
					placeholder="Nombre" value="${perro.nombre}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="edad" class="col-sm-2 control-label">Edad</label>
			<div class="col-sm-10">
				<input type="edad" class="form-control" id="edad"
					name="edad" placeholder="Edad" value="${perro.edad}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
			
			</div>
		</div>
		<div class="form-group">
			<label for="raza" class="col-sm-2 control-label">Raza</label>
			<div class="col-sm-10">
				<input type="raza" class="form-control" id="raza"
					name="raza" placeholder="Raza" value="${perro.raza}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="peso" class="col-sm-2 control-label">Peso</label>
			<div class="col-sm-10">
				<input type="peso" class="form-control" id="peso"
					name="peso" placeholder="Peso" value="${perro.peso}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="apadrinado" class="col-sm-2 control-label">Apadrinado</label>
			<div class="col-sm-10">
				<input type="apadrinado" class="form-control" id="apadrinado"
					name="apadrinado" placeholder="Apadrinado" value="${perro.apadrinado}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="identificacion" class="col-sm-2 control-label">Identificacion</label>
			<div class="col-sm-10">
				<input type="identificacion" class="form-control" id="identificacion" pattern="[1-9]{2}-[1-9]{4}-[1-9]{4}"
					name="identificacion" placeholder="Identificacion" value="${perro.identificacion}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="altitud" class="col-sm-2 control-label">Altitud</label>
			<div class="col-sm-10">
				<input type="altitud" class="form-control" id="altitud"
					name="altitud" placeholder="Altitud" value="${perro.altitud}"
					<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				
			</div>
		</div>
		<div class="form-group">
			<label for="latitud" class="col-sm-2 control-label">Latitud</label>
			<div class="col-sm-10">
				<input type="peso" class="form-control" id="latitud"
					name="latitud" placeholder="Latitud" value="${perro.latitud}"
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
	</fieldset>
</form>
<%@ include file="includes/pie.jsp"%>