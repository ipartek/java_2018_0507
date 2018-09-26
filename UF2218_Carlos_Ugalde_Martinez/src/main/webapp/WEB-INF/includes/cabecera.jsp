<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Libro Electronico Colaborativo</title>
</head>
<body>
	<header>

		<h1>
			Libro electronico colaborativo <small>v0.1</small>
		</h1>
		<p></p>
	</header>
	<nav>
		<ul>
			<c:if test="${sessionScope.user != null}">
				<li><a href="nueva">Escribir Pagina</a></li>
			</c:if>
			
			<li><button>Ir a pagina</button>
				<input type="number"></li>

		</ul>
		<ul>
			<li>${sessionScope.user.nombre}</li>
			<li><a href="login">Iniciar sesion</a></li>
			<li><a href="desconectar">Cerrar sesion</a></li>
		</ul>
	</nav>

	<main>