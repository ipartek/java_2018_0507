<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro compartido</title>
</head>
<body>
<header>
	<p>${usuario.nick}</p>
	<a href="login">Iniciar sesión</a>
	<a href="desconectar">Desconectar</a>
</header>