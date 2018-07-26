<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro</title>
<link rel="Stylesheet" href="index.css" />
</head>
<body>
	<jsp:useBean id="registro" scope="request"
		class="com.ipartek.formacion.javaee.servlets.RegistroForm" />
	<br>
	<div class="Bienvenido">
		<h2>Registro</h2>
		<a href="https://www.youtube.com/watch?v=WHGFVe-xSGM"><img
			src="img/gato.jpg" class="miau" alt="gato" /></a>
	</div>
	<br>
	<p id="mensaje">
		Introduce <i>tus</i> <span class="destacado"> datos </span>para crear
		una cuenta nueva.
	</p>
	<form action="registro" method="post">
		<fieldset id="registroField">
			<legend id="banderaRegistro">Registro</legend>
			<div id="colIzquierda">
				<p>
					<label for="nombre">Nombre</label> <br> <input type="text"
						name="nombre" id="nombre"
						value='<jsp:getProperty property="nombre" name="registro"/>'>
					<span class="errorNombre"> <jsp:getProperty
							property="mensajeErrorNombre" name="registro" /></span>
				</p>
				<p>
					<label for="apellido">Apellido</label> <br> <input type="text"
						name="apellido" id="apellido"
						value='<jsp:getProperty property="apellido" name="registro"/>'>
					<span class="errorApellido"> <jsp:getProperty
							property="mensajeErrorApellido" name="registro" /></span>
				</p>
				<p>
					<label for="dni">DNI</label> <br> <input type="text"
						name="dni" id="dni"
						value='<jsp:getProperty property="dni" name="registro"/>'>
					<span class="errorDNI"> <jsp:getProperty
							property="mensajeErrorDni" name="registro" /></span>
				</p>
				<div id="registrar">
					<button id="btnRegistrar">Registrar</button>
					
				</div>
			</div>
			<div id="colDerecha">
				<p>
					<label for="clave" id="labelClave">Contraseña</label> <br> <input
						type="text" name="clave" id="clave"
						value='<jsp:getProperty property="clave" name="registro"/>'>
					<span class="errorClave"> <jsp:getProperty
							property="mensajeErrorClave" name="registro" /></span>
				</p>
				<p>
					<label for="repiteClave" id="labelRepite">Repite la
						contraseña</label> <br> <input type="text" name="repiteClave"
						id="repiteclave"
						value='<jsp:getProperty property="repiteClave" name="registro"/>'>
					<span class="errorRepiteClave"> <jsp:getProperty
							property="mensajeErrorRepiteClave" name="registro" /></span>
				</p>
			</div>
		</fieldset>
	</form>
</body>
</html>