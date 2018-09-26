<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nuevo Articulo</title>
</head>
<body>
<form action="../edicion" method="get">
	<p>inserte el Texto de la nueva oja</p>
	<textarea cols="40" rows="5" name="texto"></textarea>
	<div>
		<label for="text">autor</label> <input type="text" name="autor"
			id="email"> <label for="id">id</label> <input
			type="id" name="id" id="email">
	</div>
	<button type="submit" name="insertarHoja" value="true">anadir </button> 
</form>
</body>
</html>