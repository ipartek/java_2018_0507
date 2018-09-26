<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>coincidencias</title>
</head>
<body>
	<c:forEach items="${coincidencias}" var="item">
		<p><a href="edicion?move=barra&fromJsp=true&${item}"> ${item} </a></p>
	</c:forEach>
</body>
</html>