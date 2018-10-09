<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header class="jumbotron">
	<h1>Perros, perros, perros</h1>
</header>

<form action="login" method="post" class="form-horizontal">
	<div class="form-group">
		<label for="nick" class="col-sm-2 control-label">Nick</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nick" name="nick" required="required"
				placeholder="Introduce tu usuario" 
				value="${usuario.nick}"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password" required="required"
				placeholder="Introduce tu contraseña" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Login</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/includes/pie.jsp"%>
