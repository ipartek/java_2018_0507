<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Formulario de Contacto</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
	 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	  <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:useBean id="usuario" scope="session" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
	<section class="container">
		<div class="row">
		<h3 class="center-align">CONTACTO</h3>
			<article class="col s6 offset-s3">
				<form method="POST" action="login">
					<div class="input-field">
						<i class="material-icons prefix">perm_identity</i>
						<label for="nombre">Nombre</label>
						<input type="text" name="nombre" id="nombre" required>
					</div>
						<jsp:getProperty property="errorNombre" name="login"/>
					<div class="input-field">
						<i class="material-icons prefix">person_pin</i>
						<label for="password">Contraseña</label>
						<input type="password" name="password" required>
					</div>
							<jsp:getProperty property="errorPassword" name="login"/>
										
					<p class="center-align">
						<button class="waves-effect waves-light btn" type="submit"><i class="material-icons right">send</i>enviar</button>
						<jsp:getProperty property="mensajeError" name="login"/>
					</p>

				</form>

			</article>
		</div>
	</section>


	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>
</body>
</html>
  
 