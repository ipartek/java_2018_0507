<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<jsp:useBean id="usuario" scope="session" class="com.ipartek.formacion.javaee.servlets.LoginForm"/>
	<h1>Principal</h1>
<p>こんにちは<br>مرحبا<br>你好<br>Сайн байна уу</p>
<h2>Bienvenido <jsp:getProperty property="nombre" name="usuario"/></h2>
</body>
</html>