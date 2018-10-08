<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>



<div class="container">

	<div class="box col-md-9 col-sm-12">

		<form action="perros" method="post" class="form-horizontal">

			<c:choose>
				<c:when test="${accion=='insert'}">
					<h1>Inserta nuevo perro</h1>
				</c:when>
				<c:when test="${accion=='update'}">
					<h1>Modificar perro</h1>
				</c:when>
				<c:when test="${accion=='delete'}">
					<h1>Eliminar perro</h1>
				</c:when>
			</c:choose>

			<input type="hidden" name="accion" value="${accion}" /> <input
				type="hidden" name="id" value="${perro.id}" />
				
			<div class="form-group">
				<label for="nombre" class="col-sm-2 control-label">Nombre</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" required="required" id="nombre" name="nombre"
						placeholder="Nombre" value="${perro.nombre}"
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				</div>
			</div>
			<div class="form-group">
				<label for="raza" class="col-sm-2 control-label">Raza</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="raza" name="raza"
						placeholder="Raza" value="${perro.raza}"
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				</div>
			</div>
			<div class="form-group">
				<label for="edad" class="col-sm-2 control-label">Edad</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" required="required" id="edad" name="edad"
						placeholder="Edad" min="0" max="20" value="${perro.edad}"
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
						<div class="input-group-addon">año(s)</div>
				</div>
			</div>
			<div class="form-group">
				<label for="peso" class="col-sm-2 control-label">Peso</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" required="required" id="peso" name="peso"
						placeholder="Peso" min="0" max="100" value="${perro.peso}"
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
						<div class="input-group-addon">kg</div>
				</div>
			</div>
			<div class="form-group">
				<label for="apadrinado" class="col-sm-2 control-label">Apadrinado</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" required="required" id="apadrinado" name="apadrinado"
						placeholder="Apadrinado" value="${perro.apadrinado}"
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				</div>
			</div>
			<div class="form-group">
				<label for="numIdent" class="col-sm-2 control-label">numIdent</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" required="required" id="numIdent" name="numIdent"
						placeholder="Numero de identificacion" value="${perro.numIdent}"
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				</div>
			</div>
			<div class="form-group">
				<label for="latitud" class="col-sm-2 control-label">Latitud</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" required="required" id="latitud" name="latitud"
						placeholder="Latitud" value="${perro.latitud}" 
						<c:if test="${accion=='delete'}">disabled="disabled"</c:if>>
				</div>
			</div>
			<div class="form-group">
				<label for="longitud" class="col-sm-2 control-label">Longitud</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" required="required" id="longitud" name="longitud"
						placeholder="longitud" value="${perro.longitud}" 
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
					<a class="btn btn-danger" href="indexPerros">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>