<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.MF0967_3.pojo.User"%>
<%@page import="com.ipartek.formacion.MF0967_3.pojo.Dog"%>
<%@page import="java.util.ArrayList"%>

<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Perrera</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Jumbotron -->
	<div class="jumbotron jumbotron-fluid text-center" id="Jumbo">
		<div class="container">
			<h1 class="display-4">ONG TXAKUR-ETXE</h1>
		</div>
	</div>
	<!-- Jumbotron -->
	<!-- Barra de navegacion -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Perritos!!!</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:if test="${sessionScope.usuario == null}">
					
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
					<li><a href="data.jsp" >Añadir</a></li>
					</c:if>
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<main> <!--  -->