<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="index.css" />
    
</head>
<body>
	<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.javaee.modelos.Persona"></jsp:useBean>
	<p><h1>Login</h1></p>
	<p><img alt="logo" src="miCoca.png" align="right"></p>
	<p id="miP">introduce tus <span class="destacado">credenciales </span>para <span class="destacado">iniciar </span> sesión</p>
	<form action="login" method="post">
		<fieldset>
			<legend class="lab">Login</legend>
			<p>
				<label for="nombre" class="lab">nombre</label>
				<input type="text" name="nombre" id="nombre" value='<jsp:getProperty property="nombre" name="login"/>'/><jsp:getProperty property="mensajeErrorNombre" name="login"/>
			</p>
			<p>
				<label for="password" class="lab">contraseña</label>
				<input type="password" name="password" id="password" /><jsp:getProperty property="mensajeErrorPass" name="login"/>
			</p>
			<p>
				<button class="btn">Login</button>
			<span class="errorTexto"><jsp:getProperty property="mensajeError" name="login"/></span>
			<a class="btn" href="registro.jsp" >registro</a>

			</p>
		</fieldset>
	</form>
</body>
</html>