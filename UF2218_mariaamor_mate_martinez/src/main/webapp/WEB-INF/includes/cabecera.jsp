<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/estilos.css" />



    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">

    <script src="js/jquery-1.12.4.min.js"></script>
    
    <script src="js/bootstrap.min.js"></script>

    <title>Principal</title>
</head>

<body>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>

            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="principal">Principal</a></li>


                </ul>
                <form class="navbar-form navbar-right">

                    <c:if test="${sessionScope.usuario!=null}">
                        <i class="fas fa-user"></i> ${sessionScope.usuario.nombre}

                        <a href="salir" class="btn btn-default">Cerrar Sesion</a>
                    </c:if>

                    <c:if test="${sessionScope.usuario==null}">

                        <a href="login.jsp" class="btn btn-default">Iniciar Sesion</a>

                    </c:if>

                </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</header>
<section id="principal" >