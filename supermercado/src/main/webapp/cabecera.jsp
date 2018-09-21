<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">

<head>
<title>Supermercado</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Montserrat:600"
	rel="stylesheet">
</head>

<body class="container-fluid">

	<jsp:useBean id="login" scope="request"
		class="com.ipartek.formacion.supermercado.modelos.LoginForm" />

	<header id="cabecera" class="v-center p-2">
		<h1>Supermercado</h1>
	</header>

	<nav class="navbar navbar-inverse noborder">
		<div class="container-fluid">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"><img
					src="imgs/logo.png" alt="logo" width="40px"></a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Inicio <span
							class="sr-only">(current)</span></a></li>
					<c:if test="${usuario != null}"><li><a href="listado.jsp">Listado</a></li></c:if>
					<c:if test="${usuario != null}"><li><a href="edicion.jsp">Modificar</a></li></c:if>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Buscar">
					</div>
					<button type="submit" class="btn btn-default">Buscar</button>
				</form>
				<ul class="nav navbar-nav pull-right">
					<c:if test="${usuario != null}">
						<li><a class="pull-right">${usuario.nombre}</a></li>
						<li><a href="logout.jsp" class="pull-right verde"> Log
								out</a></li>

					</c:if>
					<c:if test="${usuario == null}">
						<li><a href="login.jsp" class="pull-right verde">Login</a></li>
					</c:if>

				</ul>
			</div>

		</div>
	</nav>

	<div class="row">

		<section id="principal" class="col-12">