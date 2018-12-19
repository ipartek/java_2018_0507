<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymelife.org">
<head>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+TC" rel="stylesheet">
<link href="/css/estilos.css"rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<%if(session.getAttribute("email")!=null){ %>
<%=session.getAttribute("email") %>
<%}%>
<div class="container-fluid">
	<div class="row">
		
		<img src="img/portada.png" class="fototitulo" >
		
	</div>
	<div class="row">
		<!--<div class="col-xs-2 col-sm-4 col-md-4 col-lg-3"><img src="img/portada.png" class=""></div>-->
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"><h1 class="titulo">INCIDENCIAS</h1></div>
	</div>
</div>
<div class="row">
<form action="/Login" class="form-horizontal" method="get" >
      <div class="header">
         <p>Login</p>
      </div>
      <div class="form-group">
        <input type="text" class="button form-control" id="email" name="email" placeholder="email">
       </div>
       <div class="form-group">
        <input type="password" class="button form-control" id="pass" name="pass" placeholder="password">
        </div>
        <div class="form-group">
        <button type="submit" class="button" id="submit">Login</button>
      	</div>
    </form>
    </div>
</html>