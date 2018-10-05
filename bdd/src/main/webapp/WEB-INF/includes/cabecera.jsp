<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Carrefour</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />

<script src="js/jquery-1.12.4.min.js"></script>

<script src="js/bootstrap.min.js"></script>

<style>
	.error {
		color: red;
		font-weight: bold;
	}
	#mini{
	width:20px;
	
	}
	#minisss{
	width:100px;
	}
	tbody{
	
	border:1px;}
</style>

</head>
<body>

<header>

<h1 align="center">Libreria</h1>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      
      <a class="navbar-brand" href="principal">LB</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Principal">Principal <span class="sr-only">(current)</span></a></li>
        <li><c:choose>
				<c:when test="${sessionScope.user != null}">
					<li><a href="anadir.jsp">Añadir Libros</a></li>
				</c:when>
				
			</c:choose></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li>
        
            
 
            <li><c:choose>
				<c:when test="${sessionScope.user == null}">
					<li><a href="login.jsp">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="desconectar">Logout</a></li>
				</c:otherwise>
			</c:choose>
			            <li><small>${sessionScope.user.nombre}</small></li>
			
            
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</header>





	

