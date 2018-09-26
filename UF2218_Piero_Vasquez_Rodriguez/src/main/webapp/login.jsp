<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<header>
	<h1>Login</h1>
</header>

<form action="login" method="post">
	<p>
		<label for="nombre">Nombre de usuario</label>
		<input type="text" name="nombre" id="nombre" value="${user.nombre}" />
		<span class="error">${user.errorNombre}</span>
	</p>
	<p>
		<label for="password">Contraseña</label>
		<input type="password" name="password" id="password" />
	</p>
	<p>
		<button>Login</button>
		<span class="error">${errores}</span>
	</p>
	
</form>

<%@ include file="/WEB-INF/includes/pie.jsp" %>