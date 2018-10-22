<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
logueado

<%=session.getAttribute("email") %>
<%=session.getAttribute("pass") %>

<form action="logout" method="post"><button>Logout</button></form>
</body>
</html>