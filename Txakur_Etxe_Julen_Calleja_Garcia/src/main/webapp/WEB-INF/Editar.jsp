<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabezapagina.jsp"%>

<form action="anadir" method="post" class="form-horizontal">
	<fieldset>
		<legend> Añadir nuevo Perro </legend>

		<div class="form-group">
			<label for="identificador" class="col-sm-2 control-label">Identificador</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="identificador" name="identificador">
			</div>
		</div>
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nombre" name="nombre">
			</div>
		</div>
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Raza</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="raza" name="raza">
			</div>
		</div>
		<div class="form-group">
			<label for="peso" class="col-sm-2 control-label">Peso</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="peso" name="peso">
			</div>
		</div>
		<div class="form-group">
			<label for="apadrinado" class="col-sm-2 control-label">apadrinado</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="apadrinado"
					name="apadrinado">
			</div>
		</div>
		<div class="form-group">
			<label for="latitud" class="col-sm-2 control-label">Latitud</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="latitud"
					name="latitud">
			</div>
		</div>
		<div class="form-group">
			<label for="longitud" class="col-sm-2 control-label">Longitud</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="longitud"
					name="longitud">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">
				Añadir
				</button>
				<a class="btn btn-danger" href="principal">Cancelar</a>
			</div>
		</div>
	</fieldset>
</form>

<%@ include file="/WEB-INF/includes/piepagina.jsp"%>