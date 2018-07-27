<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ahorcado</title>
<link rel=StyleSheet href="index.css" />
</head>
<body>
<jsp:useBean id="ahorcado" scope="request"
		class="com.ipartek.formacion.javaee.servlets.Ahorcado" />
	<br>
	<div class="Bienvenido">
		<h2>Ahorcado</h2>
		<br>
		<br>
		<br>
		<br>
		<img src="img/Ahorcado_entero.png" class="miau" alt="ahorcado" />
		<br>
	</div>
</body>
</html>