<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/cabecera.jsp"%>
<div class="container-fluid">
<div class="col-lg-6 col-lg-offset-3">
<form action="login" method="post">
	<div class="form-group">
		<label for="nick">Usuario</label> 
		<input type="text" name="nick" id="nick" class="form-control" />
	</div>
	<div class="form-group">
		<label for="password">Contraseña:</label> 
		<input type="password" class="form-control" id="password" name="password" />
	</div>
	<input type="submit" class="btn btn-primary" value="Login"/>
	<span class="error">${errores}</span>
</form>
</div>
</div>
<%@ include file="/WEB-INF/include/pie.jsp"%>