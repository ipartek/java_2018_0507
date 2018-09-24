<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Supermercado Javier</title>

<style>
	.error {
		color: red;
		font-weight: bold;
	}
</style>

</head>
<body>
	<header>
		<h1>Supermercado Javier <small>${sessionScope.user.email}</small></h1>
		<p>
			
		</p>
	</header>
	<nav>
		<ul>
<<<<<<< HEAD
			<li><a href="principal">Principal</a>
			<li><a href="carrito.jsp">Carrito</a>
			<li><a href="login.jsp">Login</a>
			<li><a href="admin">Administración</a>
=======
			<li><a href="principal">Principal</a></li>
			<li><a href="carrito">Carrito</a></li>
			
			<li><a href="admin">Administración</a></li>
			<c:choose>
				<c:when test="${sessionScope.user == null}">
					<li><a href="login">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="desconectar">Logout</a></li>
				</c:otherwise>
			</c:choose>
				
			
>>>>>>> branch 'master' of https://github.com/ipartek/java_2018_0507.git
		</ul>
	</nav>

	<main>