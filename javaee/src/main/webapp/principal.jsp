<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<jsp:useBean id="usuario" scope="session" class="com.ipartek.formacion.javaee.modelos.LoginForm" />

	<h1>Principal</h1>
	<h2>Bienvenido <jsp:getProperty property="nombre" name="usuario"/> </h2>
</body>
</html>