<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/estilos.css" type="text/css"></link>

<%@ include file="/WEB-INF/admin/includes/cabeceraLogin.jsp" %>

<form class="login" action="login" method="post">
<h1 class="login-title">Login</h1>
	
		<label for="nombre">Nombre</label>
		<input class="login-input" placeholder="Nombre" type="nombre" name="nombre" id="nombre" value="${user.nombre}" autofocus/>
		<span class="error">${user.errorNombre}</span>


		<label for="password">Contraseña</label>
		<input class="login-input" placeholder="Password" type="password" name="password" id="password" />

	
		 <input type="submit" value="Login" class="login-button">
		<span class="error">${errores}</span>
	
	
	
</form>

<%@ include file="/WEB-INF/admin/includes/pieLogin.jsp" %>