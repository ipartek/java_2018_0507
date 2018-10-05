<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<form action="login" method="post">
	<p>
		<label for="nick">Nick</label>
		<input type="text" name="nick" id="nick"/>
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" name="password" id="password"/>
		
	</p>
	<p>
		<button>Login</button>
		<span class="error">${errores}</span>
	</p>
</form>

<%@ include file="/WEB-INF/includes/pie.jsp" %>