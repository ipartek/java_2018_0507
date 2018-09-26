<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>InakiAlvira</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="edicion">principal</a></li>
			<c:if test="${usuario ==null}">
				<li><a href="login">login</a></li>
			</c:if>

		</ul>
	</nav>
	<main>
</body>
</html>