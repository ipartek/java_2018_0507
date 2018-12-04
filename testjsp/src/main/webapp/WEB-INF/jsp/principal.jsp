<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo JSP y JSTL con Spring Boot</title>
</head>
<body>

	<h1>${informacion}</h1>
	<c:forTokens items="Uno,Dos,Tres,Cuatro" delims="," var="dato">
		<h2>${dato}</h2>
	</c:forTokens>
</body>
</html>