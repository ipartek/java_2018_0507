<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ONG</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	
	<script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand active" href="index">ONG TXAKUR-ETXE</a>
    </div>
    <c:choose>
    	<c:when test="${sessionScope.usuario == null}">
	    	<ul class="nav navbar-nav navbar-right">
	    		<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    	</ul>
    	</c:when>
	    <c:otherwise>
	    	<ul class="nav navbar-nav">
	    		<li><a href="agregar">Añadir Perro</a>
	    	</ul>
	    	<ul class="nav navbar-nav navbar-right">
	    		<li><a href="desconectar"><span></span>Cerrar sesión</a></li>
	    	</ul>
	    </c:otherwise>

</c:choose>
  </div>
</nav>