<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro Electronico</title>
</head>
<body>

		
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
		
		
		
