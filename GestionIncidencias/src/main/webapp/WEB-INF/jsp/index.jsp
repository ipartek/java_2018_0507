<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Incidencias</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">

<!-- Optional JavaScript -->
<!-- JQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/jquery-3.3.1.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

</head>
<body class="text-center">
	<form id="loginForm" class="form-signin" action="home" method="post">
		<c:if test="${error != null}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				${error}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<input type="hidden" name="accion" value="login">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="email" class="sr-only">Email</label> <input type="text"
			id="email" name="email" class="form-control" placeholder="Email"
			required autofocus> <label for="password" class="sr-only">Password</label>
		<input type="password" id="password" name="password"
			class="form-control" placeholder="Contraseña" required>
		<button class="btn btn-lg btn-success btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018 Mikel Gil</p>

		<div class="card">
			<div class="card-header">Usuarios</div>
			<div class="card-body text-left">
				<ul style="font-size: 12px">
					<li>Email: antxon@aa.com</li>
					<li>Pass: 123456</li>
					<li>Rol: Usuario normal</li>
				</ul>
				<ul style="font-size: 12px">
					<li>Email: joxepo@bb.com</li>
					<li>Pass: 654321</li>
					<li>Rol: Administrador</li>
				</ul>
			</div>
		</div>
		<br />
		<div class="card">
			<div class="card-header">Usuario normal</div>
			<div class="card-body text-left">
				<h5 style="font-size: 14px">Done</h5>
				<ul style="font-size: 12px">
					<li>Listar mis incidencias</li>
					<li>Ver incidencias completas</li>
					<li>Crear nueva incidencia</li>
					<li>Cerrar incidencia</li>
				</ul>
			</div>
			<div class="card-footer text-left">
				<h5 style="font-size: 14px">To do</h5>
				<ul style="font-size: 12px">
					<li>Modificar incidencia</li>
				</ul>
			</div>
		</div>
		<div class="card">
			<div class="card-header">Administrador</div>
			<div class="card-body text-left">
				<h5 style="font-size: 14px">Done</h5>
				<ul style="font-size: 12px">
					<li>Listar todas las incidencias</li>
					<li>Ver incidencias completas</li>
					<li>Cerrar incidencia</li>
					<li>Buscador incidencia por id</li>
					<li>Buscador incidencia por estado</li>
					<li>Buscador incidencia por usuario</li>
					<li>Listar usuarios</li>
					<li>Crear usuario</li>
				</ul>
			</div>
			<div class="card-footer text-left">
				<h5 style="font-size: 14px">To do</h5>
				<ul style="font-size: 12px">
					<li>Modificar incidencias</li>
					<li>Mostrar historicos?</li>
					<li>Modificar usuarios</li>
					<li>Borrar usuarios</li>
				</ul>
			</div>
		</div>
	</form>
</body>
</html>