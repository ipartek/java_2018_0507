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
	
	<section>
		<h1>Esta es la pagina principal</h1>
		<h3>a la que se accede despues de iniciar sesion</h3>
	</section>
	
	<%@ include file="pie.jsp" %>
</body>
</html>