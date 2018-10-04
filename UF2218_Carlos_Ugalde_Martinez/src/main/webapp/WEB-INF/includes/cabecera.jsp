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

		<h1>Libro electronico colaborativo</h1>
		<h4>${sessionScope.user.nombre}</h4>
	</header>
	<nav>
		<ul>
			<c:if test="${sessionScope.user != null}">
				<li><a href="nueva">Escribir Pagina</a></li>
			</c:if>
			
			<c:if test="${sessionScope.user != null}">
			<form action="index" >
				<li><button>Ir a pagina</button> <input type="number"
				 name="pagina"></li>
				</form>
			</c:if>
		</ul>
		<ul>
			<c:if test="${sessionScope.user == null}">
				<li><a href="login">Iniciar sesion</a></li>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				<li><a href="desconectar">Cerrar sesion</a></li>
			</c:if>
		</ul>
	</nav>

	<main>