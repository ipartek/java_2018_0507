<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo básico</title>
</head>
<body>

<form action="Usuario" method="post">
	<p>
		<label for="nombre">Nombre</label>
		<input id="nombre" name="nombre" />
	</p>
	<p>
		<label for="apellido">Apellido</label>
		<input type="password" id="apellido" name="apellido" />
	</p>
	<p>
                <button type="submit" value="login" name="login" class="btn btn-default">login</button>
	</p>
</form>

</body>
</html>