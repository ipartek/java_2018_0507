<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="index.css"/>
    <script src="index.js"></script>
</head>
<body>

	<h1>Login</h1>
	<p id="mensaje">Introduce tus <span class="destacado">credenciales para iniciar sesion</span></p>

	<form action="login" method="post">
		<fieldset>
			<legend>Login</legend>
			<p>
				<label for="nombre">Nombre</label>
				<input type="text" name="nombre" id="nombre">
			</p>
			<p>
				<label for="password">ContraseÃ±a</label>
				<input type="text" name="password" id="password">
			</p>
			<p>
				<button>Login</button>
				<span class="errorTexto">
					<jsp:getProperty property="mensajeError" name="login"/>	
				</span>
			</p>
		</fieldset>
	</form>

</body>
</html>