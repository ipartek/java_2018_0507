<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TXAKURETXE</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="http://localhost:8080/MF0967_3_Borja_Miranda_Azpiazu/css/estilos.css" />
<link rel="stylesheet" href="http://localhost:8080/MF0967_3_Borja_Miranda_Azpiazu/css/bootstrap.min.css" />

<script src="http://localhost:8080/MF0967_3_Borja_Miranda_Azpiazu/js/jquery-1.12.4.min.js"></script>

<script src="http://localhost:8080/MF0967_3_Borja_Miranda_Azpiazu/js/bootstrap.min.js"></script>

<style>
	#jumb{
	body-background:red;
	padding: 0;
	    margin: 0;
	}
	#doge{
	width:281px;
	}

	
	#h1{
	width:300px;
	
	}
	#hd{
	padding-top: 0;
	}
	#nombre{
	padding-left:20px;
	}
	#imgperro{
	
	width:100px;}
	tr{
	height: 30px;}
	footer{
	margin-top:700px;
	
	}
</style>

</head>
<body>

<header id="cabecera">
 <div class="bg">
    <div class="jumbotron" id="jumb">
        <div class="row">
            <div class="col-lg-4">
                <img src="imgs/logo.png" class="img-rounded" id="doge">
            </div>
            <div class="col-lg-8">
                <div class="page-header" id="hd">
                    <h1 id="nombre">Txakuretxe</h1>
                     <h2 id="desc"> <small>La mejor web para adoptar </small> </h2> 
                </div>
            </div>
        </div>
    </div>
    </div>
    <div id="container-fluid">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
<img src="imgs/boxer-mix-mongrel-from-cdc6-diaporama.jpg" width="80">      
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Principal">Principal <span class="sr-only">(current)</span></a></li>
        <li><c:choose>
				<c:when test="${sessionScope.user != null}">
					<li><a href="anadir.jsp">Añadir Perros</a></li>
				</c:when>
				
			</c:choose></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        
            
 
            <li><c:choose>
				<c:when test="${sessionScope.user == null}">
					<li><a href="login.jsp">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="desconectar">Logout</a></li>
				</c:otherwise>
			</c:choose>
			            <li><small>${sessionScope.user.nombre}</small></li>
			
            
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
</header>





	

