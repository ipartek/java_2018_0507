<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel=StyleSheet href="index.css" />
<!-- <script src="index.js"></script> -->
</head>
<body>
	<jsp:useBean id="login" scope="request"
		class="com.ipartek.formacion.javaee.servlets.LoginForm" />
	<br>
	<div class="Saludo">
		<h2>Login</h2>
		<a href="https://www.youtube.com/watch?v=WHGFVe-xSGM"><img
			src="img/gato.jpg" class="miau" alt="gato" /></a>
	</div>
	<br>
	<p id="mensaje">
		Introduce <i>tus</i> <span class="destacado"> credenciales </span>para
		iniciar sesion
	</p>
	<form action="login" method="post">
		<fieldset>
			<legend>login</legend>
			<p>
				<label for="nombre">Nombre</label> <br> <input type="text"
					name="nombre" id="nombre"
					value='<jsp:getProperty property="nombre" name="login"/>'>
				<span class="errorNombre"> <jsp:getProperty
					 property="mensajeErrorUsuario" name="login"/></span>
			</p>
			<p>
				<label for="password">Contraseña</label> <br> <input
					type="password" name="password" id="password"> 
					
						<span class="errorClave"> <jsp:getProperty
					 property="mensajeErrorClave" name="login"/></span>
			</p>
			<div>
			<p>
				<button>Login</button>
				<span class="errorTexto"> <jsp:getProperty
						property="mensajeError" name="login" />
				</span>
				<a href="registro.jsp" id="registroEnlace">Registro</a>
			</p>
			</div>
		</fieldset>
	</form>

</body>
</html>
