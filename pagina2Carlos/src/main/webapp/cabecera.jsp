<jsp:useBean id="cabecera" scope="request" 
class="com.ipartek.formacion.javaee.libros.modelo.Cabecera" /> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    
    <title><jsp:getProperty property="titulo" name="cabecera"/></title>
    
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/estilos.css" />
    <link rel="stylesheet" href="css/estilosMain.css" />
    <link rel="stylesheet" href="css/estiloEditar.css" />
    <link rel="stylesheet" href="css/estiloTabla.css" />
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Jumbotron -->
    <div class="jumbotron jumbotron-fluid text-center">
        <div class="container">
            <h1 class="display-4">Libros</h1>
        </div>
    </div>
    <!-- Fin jumbotron -->
    <!-- Comienzo barra de navegacion -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed " data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="login.jsp">Libros</a>
            </div>

            <!-- Collect the nav links, forms, and other content for togglin2 -->
            <div class="Opcion 3-collapse" id="bs-example-navbar-collapse-1">
                <div class="col-md-3"></div>
                <ul class="nav navbar-nav">
                    <li><a href="#">Opcion 1 </a></li>
                    <li><a href="Editar.jsp" >Editar</a></li>
                    <li><a href="visor.jsp">Visor</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <!-- Fin barra navegacion -->
    <!-- Inicio barra navegacion vertical -->
    <div class="navbar">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 vertical">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false"><span class="sr-only">Toggle navigation</span>
                            
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">OPCIONES</a>
                    </div>
                    <div class="Opcion 3-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav  flex-column vertical">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Opcion 1</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="tabla.jsp">Lista</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="EtiquetaServlet?id=1">Opcion 3</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Opcion 4</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-10">
                <!-- Hay quecargar los otros JSP aqui -->
