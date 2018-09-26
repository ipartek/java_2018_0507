<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Libro Electrónico Colaborativo</title>

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body class="container-fluid">


	<header>
		<h1>Libro Electrónico Colaborativo.</h1>

		<nav>

			<ul class="nav navbar-nav pull-right">

				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li><a href="login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a><span class="glyphicon glyphicon-user">
									${sessionScope.user.nombre} </span></a></li>
						<li><a href="desconectar">Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>

	<main>