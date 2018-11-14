<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro compartido</title>
</head>
<body>
	<header>
		<p>${sessionScope.usuario.nick}</p>
		<c:choose>
			<c:when test="${sessionScope.usuario == null}">
				<a href="login">Iniciar sesión</a>
			</c:when>
			<c:otherwise>
				<a href="desconectar">Desconectar</a>
			</c:otherwise>
		</c:choose>
	</header>