<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<header>
	<h1>Login</h1>
</header>
<form action="login" method="post">
	<p>
		<label for="email">Email</label>
		<input type="email" name="email" id="email"/>
	<!-- 	<span class="error">${user.errorEmail}</span> -->
	</p>
	<p>
		<label for="password">Contraseña</label>
		<input type="password" name="password" id="password" />
	</p>
	<p>
		<button>Login</button>
		<!-- <span class="error">${errores}</span> -->
	</p>
	
</form>
</body>
</html>