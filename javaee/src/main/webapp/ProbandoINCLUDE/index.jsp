<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Ejemplo Bootstrap</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/estilos.css" type="text/css">
	
	<script src="js/bootsrap.min.js"></script>
	<script src="js/jquery-1.12.4.min.js"></script>
	
	
</head>
<body>
	<h1 class="cabecera">LIBROS JULEN</h1>
	
	 <nav class="navbar navbar-inverse">
      <div class="container">
    
        <div class="collapse navbar-collapse center-block" id="navbar-collapse-3" >
          <ul class="nav navbar-nav navbar-left">
            <li><a href="#">Historia</a></li>
            <li><a href="#">Fantasia</a></li>
            <li><a href="#">Programacion</a></li>
            <li><a href="#">Thrillers</a></li>
            <li><a href="#">Literatura erotica</a></li>  
          </ul>       
        </div>
      </div>
    </nav>

<%@ include file="login.jsp" %>    

<div class="tab-pane text-style" id="tab2">
  <h2>Listado de Libros</h2>
   <p></p>
    <hr>
          <img src="http://placehold.it/150x90" class="img-rounded pull-left">
</div>

<%@ include file="listado.jsp" %> 
</div>
    
</div>

<%@ include file="edicion.jsp" %> 
