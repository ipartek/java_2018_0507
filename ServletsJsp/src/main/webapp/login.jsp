<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no" />
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron jumbotron-fluid text-center" id="Jumbo">
		<div class="container">
			<h1 class="display-4">Supermercado Tarari</h1>
		</div>
	</div>
	<!--Fin jumbotron -->
	<!-- Barra de navegacion - Enlaces a login - editor - tabla - Registro de producto -->

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="paginaPrincipal.html" id="brand"><img
					src="imgs/supermercado.png"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="tabla.html">Listado Productos</a></li>
					<li><a href="Editor.html">Editar producto</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.html">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- fin barra navegacion -->

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="login.html" class="active" id="login-form-link">Login</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<jsp:useBean id="login" scope="request"
									class="com.ipartek.formacion.javaee.supermercado.pojo.Login" />
								<form id="login-form" action="login" method="post" role="form"
									style="display: block;">
									<div class="form-group">
										<label>Usuario</label>
										<!-- El value del input nos sirve para poder recordar el nombre
									si no seintroduce el usuarioy contraseña adecuados -->
										<input type="text" name="username" id="username" tabindex="1"
											class="form-control" placeholder="Usuario"
											value='<jsp:getProperty property="nombre" name="login"/>'>
											<!-- Usamos span y el get property para enviar el mensaje de error -->
											<span class="errorNombre"> <jsp:getProperty
												property="mensajeErrorUsuario" name="login" /></span>
									</div>
									<div class="form-group">
										<label>Contrase&ntilde;a</label> <input type="password"
											name="password" id="password" tabindex="2"
											class="form-control" placeholder="Clave" value='<jsp:getProperty 
											property="clave" name="login"/>'>
											<span class="errorClave"> <jsp:getProperty
												property="mensajeErrorClave" name="login" /></span>
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember"
											id="remember"/>
											  <label for="remember">
											Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- boton TOP para ir a la parte superior de la pagina. -->
	<div class="container">
		<div class="row text-center top">
			<a href="login.html"><button type="button" class="btn btn-info">Top</button></a>
		</div>
	</div>
	<footer>
		<!--
            Iconos para facebook, twitter, enlaces a politica de privacidad, contacto , LocalizaciÃ³n y logo de copyright con aÃ±o actual.
             -->
		<div class="container-fluid"></div>
		<div class="row" id="pie">
			<div class="col-xs-1 container"></div>
			<div class="col-xs-1 container">
				<a href="https://twitter.com/?lang=es"><img
					src="imgs/twitter.png" class="imageFooter"></a>
			</div>
			<div class="col-xs-1 container">
				<a href="https://es-es.facebook.com/"> <img class="imageFooter"
					src="imgs/facebook.png"></a>
			</div>
			<div class="col-xs-1 container"></div>
			<div class="col-xs-2 container"></div>
			<div class="col-xs-2 container"></div>
			<div class="col-xs-4 container" id="footerDerecha">
				<p>
					<a href="#">Politica de privacidad</a>
				</p>
				<p>
					<a href="#">Bilbao</a>
				</p>
				<p>
					<a href="#">@2018</a>
				</p>
			</div>
		</div>
	</footer>
</body>
</html>