<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>

<title>Libro Electronico</title>
</head>
<body>

		<a href="#">Escribir pagina</a>
		<p>
		<form action="escritura" method="post">
		<Label>Ir a pagina </Label> <input type="text"> <button>Ir</button>
		</form>
		</p>
		<p>
		<a href="#">Anterior</a> <a href="#">Siguiente</a>
		</p>
		
		
		<small>${sessionScope.user.nombre}</small>
		<c:choose>
				 <c:when test="${sessionScope.user == null}">
					<a href="login">Iniciar Sesion</a>
				</c:when>
				<c:otherwise>
					<a href="desconectar">Cerrar Sesion</a>
				</c:otherwise>
			</c:choose>
		
		<p> </p>
		
		
		
<main>