<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"  %>
<fmt:setLocale value="es_ES"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Supermercado Mikel</title>
<style>
	.error {
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
	<header>
		<h1>Supermercado Mikel</h1>
	</header>
	<nav>
		<ul>
			<li><a href="principal">Principal</a></li>
			<li><a href="carrito.jsp">Carrito</a></li>
			<li><a href="login.jsp">Login</a></li>
			<li><a href="admin">Administración</a></li>
		</ul>
	</nav>
	<main>