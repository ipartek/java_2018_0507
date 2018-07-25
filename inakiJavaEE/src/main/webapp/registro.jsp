<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registrate</title>
</head>
<body>
<jsp:useBean id="registro" scope="session" class="com.ipartek.formacion.javaee.modelos.Persona"></jsp:useBean>
	<h1>Formulario de registro</h1>
	<p>introduce tus datos para registro</p>
	<form action="registro" method="post">
		<fieldset>
			<legend>Registro</legend>
			<p>
				<label for="nombre">nombre</label>
				<input type="text" name="nombre"  value=""/><jsp:getProperty property="mensajeErrorNombre" name="registro"/>
			</p>
				<label for="apellidos">apellidos</label>
				<input type="text" name="apellido" value=""/><jsp:getProperty property="apellidoE" name="registro"/>
				<p>
				<label for="dni">dni</label>
				<input type="text" name="dni"  value=""/><jsp:getProperty property="dniError" name="registro"/>
				</p>					
			<p>
				<label for="password">contraseña</label>
				<input type="password" name="password"/><jsp:getProperty property="mensajeErrorPass" name="registro"/>
			</p>
			<p>
				<label for="repCont">repite contraseña</label>
				<input type="text" name="repPass" value=""/><jsp:getProperty property="errorCompPass" name="registro"/>
			</p>
			<p>
				<button>registrate</button>
			<span class="errorTexto"></span>
			
			</p>
		</fieldset>
	</form>
</body>
</html>