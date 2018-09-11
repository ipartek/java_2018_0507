<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversor</title>
</head>
<body>
	
	<h1>Conversor</h1>
	
	<form action="conversor" method="get">
		<label for="unidad">Km => Millas</label> 
		<input type="text"name="unidad" value="">
		<input type="hidden" name="formulario"value=""> 
		<input type="submit" value="Convertir">
	</form>

	<form action="conversor" method="get">
		<label for="unidad">Millas => Km</label> 
		<input type="text" name="unidad" value=""> 
		<input type="hidden"name="formulario" value=">">
		<input type="submit" value="Convertir">
	</form>

	<p>${mensaje}</p>


</body>
</html>