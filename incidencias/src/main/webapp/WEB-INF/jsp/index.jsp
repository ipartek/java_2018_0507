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
<title>Incidencias Piero</title>

<link href="https://bootswatch.com/4/sketchy/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarToggler03" aria-controls="navbarToggler03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="/home.jsp"> <i class="fas fa-home"></i>
		</a>
		<div class="collapse navbar-collapse" id="navbarToggler03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="/home.jsp"><i class="fas fa-bolt"></i>&nbsp;Mis
						incidencias<span class="sr-only">(current)</span> </a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="/" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-cog"></i>&nbsp;&nbsp;Administrador</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" id="btnAdminUsuarios"><i
							class="fas fa-users"></i>&nbsp;&nbsp;Usuarios</a> <a
							class="dropdown-item" id="btnAdminIncidencias"><i
							class="fas fa-bolt"></i>&nbsp;&nbsp;Incidencias</a>
						<div class="dropdown-divider"></div>
					</div></li>
			</ul>

			<form action="logout" method="post" class="form-inline my-2 my-lg-0">
				<span class="navbar-text"> <i class="fas fa-user"></i>
					&nbsp;Welcome ${user.nombre}&nbsp;
				</span>
				<button class="btn btn-warning" type="submit">&nbsp;Logout
				</button>
			</form>
		</div>
	</nav>

</body>
</html>