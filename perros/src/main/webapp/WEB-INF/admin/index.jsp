<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/includes/cabecera.jsp"%>

<header>
	<h1>Administración de perros</h1>
</header>

<form action="index" method="post" class="form-horizontal">
	<fieldset>
		<legend>Datos del perro</legend>
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nombre" name="nombre"
					required="required" placeholder="Nombre del perro"
					value="${perro.nombre}" />
			</div>
		</div>
		<div class="form-group">
			<label for="edad" class="col-sm-2 control-label">Edad</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="edad" name="edad"
					placeholder="Edad del perro" min="0" value="${perro.edad}" />
				<span class="text-danger">${perro.errorEdad}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="peso" class="col-sm-2 control-label">Peso</label>
			<div class="col-sm-10">
				<input type="number" step=".01" class="form-control" id="peso" name="peso"
					placeholder="Peso del perro en kg" min="1" value="${perro.peso}" />
				<span class="text-danger">${perro.errorPeso}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="raza" class="col-sm-2 control-label">Raza</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="raza" name="raza"
					placeholder="Raza del perro" value="${perro.raza}" />
			</div>
		</div>
		<div class="form-group">
			<label for="apadrinado" class="col-sm-2 control-label">Apadrinado</label>
			<div class="col-sm-10">
				<input type="checkbox" class="form-control" id="apadrinado"
					name="apadrinado" placeholder="Apadrinado o no"
					value="${perro.apadrinado}" />
			</div>
		</div>
	</fieldset>
	<fieldset>
		<legend>Chip</legend>
		<div class="form-group">
			<label for="identificacion" class="col-sm-2 control-label">Identificación</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="identificacion" name="identificacion"
					placeholder="Formato dd-dddd-aaaa" pattern="\d{2}-\d{4}-[12]\d{3}" 
					value="${perro.chip.identificacion}" />
				<span class="text-danger">${perro.chip.errorIdentificacion}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="latitud" class="col-sm-2 control-label">Latitud</label>
			<div class="col-sm-10">
				<input type="number" step=".00001" class="form-control" id="latitud" name="latitud"
					placeholder="Latidud dd,ddddd"  
					value="${perro.chip.latitud}" />
				<span class="text-danger">${perro.chip.errorLatitud}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="longitud" class="col-sm-2 control-label">Longitud</label>
			<div class="col-sm-10">
				<input type="number" step=".00001" class="form-control" id="longitud" name="longitud"
					placeholder="Longitud dd,ddddd"
					value="${perro.chip.longitud}" />
				<span class="text-danger">${perro.chip.errorLongitud}</span>
			</div>
		</div>
	</fieldset>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>


<%@ include file="/WEB-INF/admin/includes/pie.jsp"%>
