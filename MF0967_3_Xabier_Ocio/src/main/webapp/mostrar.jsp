<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="modelo.Perro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
<link rel="icon" href="img/huella.png" type="image/x-icon"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>mostrar</title>
</head>
<body>
<%Perro a=new Perro(); a=(Perro)request.getAttribute("perro"); %>
<table class="table table-striped ">
		<tr><th>nombre</th><th>edad</th><th>raza</th><th>peso</th><th>id</th><th>latitud</th><th>longitud</th><th>foto</th></tr>
		<tr><td><%=a.getNombre() %></td><td><%=a.getEdad() %></td><td><%=a.getRaza() %></td><td><%=a.getPeso() %></td><td><%=a.getPojoChip().getId() %></td><td><%=a.getPojoChip().getLatitud() %></td><td><%=a.getPojoChip().getLongitud() %></td><td><img src="img/perro1.png" height="42" width="42"> </tr>
<a href="index.jsp">regresar</a>
</body>
</html>