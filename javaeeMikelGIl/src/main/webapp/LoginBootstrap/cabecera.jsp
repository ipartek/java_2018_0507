<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="cabecera" scope="request" class="com.ipartek.formacion.javaee.libros.modelos.Cabecera" />

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Plantilla</title>

    <!--  <link rel="stylesheet" href="css/bootstrap.min.css" /> -->
    <link rel="stylesheet" href="css/bootstraptheme.min.css" />
    <link rel="stylesheet" href="css/estilos.css" />

    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
   
   <script>
	   $(document).ready(function(){
		    $("#btnEditar").on("click", function(){
		        $("#div_contenido").empty();
		        $("#div_contenido").load("editar.jsp");
		   });
		    $("#btnListado").on("click", function(){
		    	$("#div_contenido").empty();
		    	$("#div_contenido").load("libros.jsp");
		    });
		    $("#btnVerLibros").on("click", function(){
		    	$("#div_contenido").empty();
		    	$("#div_contenido").load("librosBonito.jsp");
		    });
	   });
    </script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="jumbotron">
                <div class="container">
                    <h1 class="display-4">Libros</h1>
                   	<p class="lead">Bienvenido a préstamo de libros</p>
  
                </div>
            </div>
        </div>


  