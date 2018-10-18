<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">

  <head>

	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<script>
		function reproducir(id) {
			
			console.info('reproducir video ' + id);
			var iframe = document.getElementById('iframe');
			iframe.src = "https://www.youtube.com/embed/" + id;
			
		}	
	
	</script>
    <title>Youtube Video Play List</title>

	<link rel="stylesheet" href="css/all.css">
	
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">

 

            <li class="nav-item active">
              <form action="inicio" method="post" class="form-inline mt-2 mt-md-0">
	           
	           <c:choose>
				<c:when test="${sessionScope.user != null}">
				
	          	            <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11,11}">
	            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit" name="anadir" value="si">Añadir</button>
				<span name="idusuario" value="${user.id}"></span>
				</c:when>
	           </c:choose>
	           
	          
	          </form>
            </li>     
            <c:choose>
				<c:when test="${sessionScope.user == null}">
					<li><a href="login.jsp">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="desconectar">Logout</a></li>
				</c:otherwise>
			</c:choose>       
			
          </ul>
          <ul><li>
          <small><font color="blue">${sessionScope.user.nombre}</font></small>
          </li>
</ul>
          
          
        </div>
      </div>
    </nav>