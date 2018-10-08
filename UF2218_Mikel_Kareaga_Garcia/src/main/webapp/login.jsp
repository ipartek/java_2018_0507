<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

    <form action="login" method="post">
    	<p>
    	<label for="nombre">Nombre</label>
		<input type="text" name="nombre" id="nombre" />
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" name="password" id="password" />
	</p>
	<p>
		<button>Login</button>
	</p>
</form>
<%@ include file="/WEB-INF/includes/pie.jsp" %>