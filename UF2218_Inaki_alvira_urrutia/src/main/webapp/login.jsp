<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>login</h1>
</header>
<form action="login" method="post">
	<p>
		<label for="email">nick</label>
		<input type="email" name="email" id="email"><span>${usuario.errorEmail}</span>
	</p>
	<p>
		<label for="password">contraseña</label>
		<input type="password" name="password" id="password"><span>${usuario.errorPassword}</span>
		</p>
		<p>
	<button> Login</button>
	</p>
	
</form>
<%@ include file="WEB-INF/includes/pie.jsp"%>