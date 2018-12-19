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
	<form action="/LoginController" class="form-horizontal" method="post" name="sign up for beta form">
      <div class="header">
         <p>Login</p>
      </div>
      <div class="form-group">
        <input type="text" class="button form-control" id="email" name="email" placeholder="email">
       </div>
       <div class="form-group">
        <input type="password" class="button form-control" id="pass" name="pass" placeholder="password">
        </div>
        <div class="form-group">
        <input type="submit" class="button" id="submit">
      	</div>
    </form>
</body>
</html>