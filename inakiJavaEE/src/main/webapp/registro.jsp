<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h1>Formulario de registro</h1>
	<p>introduce tus datos para registro</p>
	<form action="registro" method="post">
		<fieldset>
			<legend>Login</legend>
			<p>
				<label for="nombre">nombre</label>
				<input type="text" name="nombre" id="nombre" value=""/>
				<label for="apellidos">apellidos</label>
				<input type="text" name="nombre" id="nombre" value=""/>
				<label for="dni">dni</label>
				<input type="text" name="nombre" id="nombre" value=""/>
				
			</p>
			<p>
				<label for="password">contraseña</label>
				<input type="password" name="password" id="password"/>
				<label for="repCont">repite contraseña</label>
				<input type="text" name="nombre" id="nombre" value=""/>
			</p>
			<p>
				<button>registrate</button>
			<span class="errorTexto"></span>
			
			</p>
		</fieldset>
	</form>
</body>
</html>