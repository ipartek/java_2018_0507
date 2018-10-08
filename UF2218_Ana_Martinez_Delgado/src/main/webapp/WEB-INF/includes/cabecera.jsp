<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<meta charset="UTF-8">

<title>Libro compartido</title>
</head>
<body>
	<header>
		
		<c:choose>
			<c:when test="${sessionScope.usuario == null}">
				<a href="login" class="btn btn-primary">Iniciar sesión</a>
			</c:when>
			<c:otherwise>
				Bienvenido ${sessionScope.usuario.nick}  &nbsp;
				<a href="desconectar" class="btn btn-primary">Desconectar</a>
				<br>
			</c:otherwise>
		</c:choose>
		
	</header>