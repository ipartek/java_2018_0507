<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

  <head>

	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	
    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">

  </head>

  <body>
  
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="index.jsp"><img src="imgs/logo.png"
			alt="logo" width="50px"> </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<c:if test="${not empty user.nombre}">
					<li class="nav-item"><i class="fa fa-pencil"></i><a class="btn btn-outline-light" href="edicion.jsp">Escribir pagina</a></li>
				</c:if>
			</ul>
			<ul  class="navbar-nav float-right">
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li class="nav-item"><a class="btn btn-primary" href="login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link">
								<span class="fa fa-user mr-1"></span>${sessionScope.user.nombre}
							</a>
						</li>
						<li><a class="btn btn-danger" href="desconectar">Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>