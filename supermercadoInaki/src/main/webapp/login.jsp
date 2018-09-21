<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>login</h1>
</header>
<form action="Principal.jsp">
	<p>
		<label for="email">nick</label>
		<input type="email" name="email" id="email">
	</p>
	<p>
		<label for="nick">contraseña</label>
		<input type="text" name="nick" id="nick">
	</p>
	<p>
	<button> Login</button>
	</p>
</form>
<%@ include file="WEB-INF/includes/pie.jsp"%>