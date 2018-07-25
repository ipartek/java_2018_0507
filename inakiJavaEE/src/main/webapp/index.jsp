<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="index.css" />
    <script src="index.js"></script>
</head>
<body>
	<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.javaee.modelos.LoginForm.java"></jsp:useBean>
	<h1>Login</h1>
	<p id="miP">introduce tus <span class="destacado">credenciales </span>para <span class="destacado">iniciar </span> sesión</p>
	<form action="login" method="post">
		<fieldset>
			<legend>Login</legend>
			<p>
				<label for="nombre">nombre</label>
				<input type="text" name="nombre" id="nombre"/>
			</p>
			<p>
				<label for="password">contraseña</label>
				<input type="text" name="password" id="password"/>
			</p>
			<p>
				<button>Login</button>
			<span class="errorTexto"><jsp:getProperty property="mensajeError" name="login"/></span>
			</p>
		</fieldset>
	</form>
</body>
</html>