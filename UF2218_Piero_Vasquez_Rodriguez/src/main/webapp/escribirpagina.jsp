<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Libro electronico Piero</title>

</head>
<body>
<h1>Autor : ${sessionScope.user.nombre}</h1>
<form action="escribirpagina" method="post">
	<legend>Escribir el texto de la pagina</legend>
	<p>
	<label for="id">Id </label>
	<input type="number" name="id" required/><p>
	<label for="texto">Texto  </label>
	<input type="text" name="texto" id="texto" required/><p>
	<input type="hidden" name="autor" id="autor" value="${sessionScope.user.nombre}"/>
	<input type="submit" name="enviado" value="Enviar"/>
</form>
</body>
</html>