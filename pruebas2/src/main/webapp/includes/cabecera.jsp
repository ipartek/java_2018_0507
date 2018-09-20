<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="es">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>prueba</title>
        <link rel="stylesheet" href="http://localhost:8080/pruebas/css/estilos.css"/>
    <link rel="stylesheet" href="http://localhost:8080/pruebas/css/bootstrap.min.css" />
    
        <script src="http://localhost:8080/pruebas/js/jquery-1.12.4.min.js"></script>

    <script src="http://localhost:8080/pruebas/js/bootstrap.min.js"></script> 
</head>
<body id="wat">

<header>

<h1 align="center">LIBROSWEB</h1>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">LB</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">añadir producto <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Ver lista productos</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
         
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><c:if test="${usuario == null}">
		<h1>¡¡¡¿¿¿Cómo narices has llegado aquí????!!!</h1>
	</c:if>Cerrar sesion</a></li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</header>


<div class="row" id="centro">
<nav class="col-md-2" id="menuizq">
			<ul class="nav nav-pills nav-stacked" id="barra">
				<li role="presentation" class="active"><a href="subseccion?id=1&sub=1">Home</a></li>
				<li role="presentation"><a href="subseccion?id=1&sub=2">Profile</a></li>
				<li role="presentation"><a href="subseccion?id=1&sub=3">Messages</a></li>
				<li role="presentation"><a href="subseccion?id=1&sub=2">Profile</a></li>
				<li role="presentation"><a href="subseccion?id=1&sub=3">Messages</a></li><li role="presentation"><a href="subseccion?id=1&sub=2">Profile</a></li>
				<li role="presentation"><a href="subseccion?id=1&sub=3">Messages</a></li><li role="presentation"><a href="subseccion?id=1&sub=2">Profile</a></li>
	
			</ul>
		</nav>
		

<section id="principal">



		
		
		











