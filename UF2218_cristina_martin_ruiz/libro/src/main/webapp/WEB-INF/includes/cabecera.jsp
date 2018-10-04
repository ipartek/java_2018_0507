
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Libro Electrónico Colaborativo</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link
	href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/estilos.css" />

<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>


	<header>
		<h1>Libro Electrónico Colaborativo</h1>
	</header>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp"><img src="imgs/logo.png"
			alt="logo" width="50px"> </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<c:if test="${not empty user.nombre}">
					<li class="nav-item"><i class="fa fa-pencil"></i><a class="btn btn-outline-light" href="edicion.jsp">Escribir pagina</a></li>
				</c:if>
			</ul>
			<ul  class="navbar-nav float-right">
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li class="nav-item"><a class="btn btn-primary" href="login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link">
								<span class="fa fa-user mr-1"></span>${sessionScope.user.nombre}
							</a>
						</li>
						<li><a class="btn btn-danger" href="desconectar">Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	
<div class="container-fluid">

	<main>