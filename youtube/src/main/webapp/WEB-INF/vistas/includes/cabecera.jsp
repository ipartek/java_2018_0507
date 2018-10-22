<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.model.Video"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<base href="${pageContext.request.contextPath}/">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Youtube Video PlayList</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/estilos.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Youtube PlayList</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" href="video">Añadir
							video</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
						<form action="login" method="post"
							class="form-inline mt-2 mt-md-0">
							<input name="email" class="form-control mr-sm-2" type="email"
								placeholder="Email" title="Email" required /> <input
								name="password" class="form-control mr-sm-2" type="password"
								placeholder="Password" title="Password" required />
							<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Login</button>
						</form>
					</li>
				</ul>



			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<c:if test="${alertatexto != null}">
			<div class="alert alert-${alertatipo} alert-dismissible fade show"
				role="alert">
				${alertatexto}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>