<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<h2>Edición de registro</h2>

<form class="form-horizontal" action="listado">
	<div class="form-group">
		<label for="id" class="col-sm-offset-1 col-sm-2 control-label">Id</label>
		<div class="col-sm-8">
			<input type="number" class="form-control" id="id" name="id"
				required="required" min="1" value="1" placeholder="Id numérico">
		</div>
	</div>
	<div class="form-group">
		<label for="titulo" class="col-sm-offset-1 col-sm-2 control-label">Título</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="titulo" name="titulo"
				required="required" maxlength="100"
				pattern="[A-Za-z0-9ñÑáéíóúçàèìòù ]{3,100}" value="Título1"
				placeholder="Título de mínimo 3 caracteres y máximo 10">
		</div>
	</div>

	<div class="form-group">
		<label for="editorial" class="col-sm-offset-1 col-sm-2 control-label">Editorial</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="editorial"
				name="editorial" maxlength="20" pattern="\w{3,20}"
				placeholder="Editorial de mínimo 3 caracteres y máximo 20">
		</div>
	</div>

	<div class="form-group">
		<label for="precio" class="col-sm-offset-1 col-sm-2 control-label">Precio</label>
		<div class="col-sm-8">
			<div class="input-group">
				<input type="number" class="form-control" id="precio" name="precio"
					min="0" step="0.01" placeholder="Precio del libro">
				<div class="input-group-addon">€</div>
			</div>
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
			<a class="btn btn-danger" href="listado">Cancelar</a>
		</div>
	</div>
</form>


<%@ include file="includes/pie.jsp"%>
