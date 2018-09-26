<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<%@ page import="datos.*" %>
<%@ page import="servlets.*" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% System.out.println("hola"); %>
		
		<c:forEach items="${lista}" var="pagina">
			<tr>
				<td>${pagina.autor}</td>
				<td>${pagina.contenido}</td>
			</tr>
		</c:forEach>
		<% Pagina pag = new Pagina();;
		
		System.out.println("lista"+pag.getLista()); %>
		<%=pag.getAutor() %>
		
</body>
</html>