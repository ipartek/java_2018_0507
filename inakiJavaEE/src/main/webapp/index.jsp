<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="index.css" />
    <script src="index.j"></script>
</head>
<body> 
<div class="container">
<div id="cabeza" class="cabeza">
<p><img class="img" alt="logo" src="miCoca.png" align="top"></p>
	<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.javaee.modelos.Persona"></jsp:useBean>
	
	<p id="miP" class="mia" >introduce tus <span class="destacado">credenciales </span></p>
	</div>
</div>
<div>
	<form action="login" method="post">
		<fieldset>
			<legend class="lab">Login</legend>
			<p>
				<label for="nombre" class="lab">nombre</label>
				<input type="text" name="nombre" id="nombre" value='<jsp:getProperty property="nombre" name="login"/>'/><jsp:getProperty property="mensajeErrorNombre" name="login"/>
			</p>
			<p>
				<label for="password" class="lab">contraseña</label>
				<input type="password" name="password" id="password"/><jsp:getProperty property="mensajeErrorPass" name="login"/>
			</p>
			<p>
				<button id="passwordBot">Login</button>
			<span class="errorTexto"><jsp:getProperty property="mensajeError" name="login"/></span>
			<a class="btn" href="registro.jsp" id="passwordBot" >registro</a>

			</p>
		</fieldset>
	</form>
</div>
</body>
</html>