<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/cabecera.jsp"%>

<form action="usuarios" method="get" class="form-horizontal">
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email"
				placeholder="Email"> <span class="text-danger">Error
				en el email</span>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password"
				name="password" placeholder="Password"> <span
				class="text-danger">Error en la password</span>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
			<a class="btn btn-danger" href="index">Cancelar</a>
		</div>
	</div>
</form>

<%@ include file="includes/pie.jsp"%>