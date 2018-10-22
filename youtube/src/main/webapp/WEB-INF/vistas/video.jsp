<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="gestionvideos" method="post" class="mt-2 mt-md-0">

	<input type="hidden" name="accion" value="insert" />

	<div class="form-group row">
		<label for="idvideo" class="col-sm-3 col-form-label">ID del
			video en Youtube</label>
		<div class="col-sm-9">
			<input id="idvideo" name="idvideo" class="form-control mr-sm-2"
				type="text" placeholder="ID 11 caracteres" title="11 caracteres"
				required pattern=".{11}">
		</div>
	</div>

	<div class="form-group row">
		<label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
		<div class="col-sm-9">
			<input name="nombre" class="form-control mr-sm-2" type="text"
				placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
		</div>
	</div>

	<div class="form-group row">
		<div class="offset-sm-3 col-sm-9">
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">AÃ±adir</button>
		</div>
	</div>

</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
