<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


	

<div class="col-sm-3"></div>
<div class="col-sm-6" style="padding:50px 0">
<h1 align="center">Login</h1>
	<div class="logo"></div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left" action="Login">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group"><div align="center">Nombre</div>
						<label for="lg_username" class="sr-only">nombre</label>
						<input type="text" class="form-control" id="lg_username" name="nombre" placeholder="nombre">
					</div>
					<div class="form-group"><div align="center">Contraseña</div>
						<label for="lg_password" class="sr-only">Contraseña</label>
						<input type="text" class="form-control" id="lg_password" name="password" placeholder="password">
					</div>
					
				</div>
				<button >Entrar</button>
			</div>
			<div class="col-sm-3"></div>
			
		</form>
	</div>
	<!-- end:Main Form -->
</div>
<%@ include file="/WEB-INF/includes/pie.jsp" %>