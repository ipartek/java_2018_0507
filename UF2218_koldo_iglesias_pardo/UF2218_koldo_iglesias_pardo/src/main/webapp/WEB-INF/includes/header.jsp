<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Página web principal</title>
</head>

<body>

	<header>
		<h1>Bookgenerator</h1>
		<nav>
			<ul>
				<li><a href="index.jsp">Inicio</a></li>
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li><a href="login">🧒 Iniciar sesión</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="desconectar">🧒 Desconectar</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>

	<section>