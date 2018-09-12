<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Principal</title>
</head>
<body>
	<jsp:useBean id="usuario" scope="session" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
	<%@ include file="cabecera.jsp" %>
	
		<div class="jumbotron">
		  <h1>Bienvenido a Préstamo de libros</h1>
		  <p><a class="btn btn-primary btn-lg" href="login" role="button">Boton
		</a></p>
		
		</div>
	
	<%@ include file="pie.jsp" %>
</body>
</html>