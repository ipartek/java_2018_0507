<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<header>
	<h1>Login</h1>
</header>

<form action="principal.jsp">
	<p>
		<label for="email">Email</label>
		<input type="email" name="email" id="email" />
	</p>
	<p>
		<label for="password">Contraseña</label>
		<input type="password" name="password" id="password" />
	</p>
	<p>
		<button>Login</button>
	</p>
	
</form>

<%@ include file="/WEB-INF/includes/pie.jsp" %>