<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>E-BOOK</title>
</head>
<body>
	<header>
		<h1>Libro digital<small>${sessionScope.usuario.nombre}</small></h1>
		<p>
			
		</p>
	</header>
	<nav>
		<ul>
			<c:choose>
				<c:when test="${sessionScope.user == null}">
							<li><a href="login">Iniciar sesion</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="desconectar">Logout</a></li>
				</c:otherwise>
			</c:choose>
				
			
		</ul>
	</nav>

	<main>