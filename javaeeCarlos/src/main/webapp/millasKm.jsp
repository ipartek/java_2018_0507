<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Millas a Kilometros y viceversa</title>
<link rel="Stylesheet" href="index.css" />
</head>
<body>
<jsp:useBean id="millaskm" scope="request"
		class="com.ipartek.formacion.javaee.servlets.MillasKmForm" />
		
	<h1>Millas a Kilometros y viceversa</h1>
	<form action="millaskm" method="post">
	<fieldset>
	<legend>Millas a Kilometros, y veiceversa</legend>
	<p><label for="millas">Millas </label><input type="number" 
	name="millas" id="millas" value='<jsp:getProperty 
	property="millas" name="millaskm"/>'>
				<span class="errorTexto"> <jsp:getProperty
					 property="errorMillas" name="millaskm"/></span>              
					 </p>
					 
	<p><label for="km">Kilometros </label><input type="number" 
	name="km" id="km" value='<jsp:getProperty 
	property="km" name="millaskm"/>'>
				<span class="errorTexto"> <jsp:getProperty
					 property="errorKm" name="millaskm"/></span>
					 </p>
					 
	<p><button>Procesar</button><span class="errorTexto"> <jsp:getProperty
						property="error" name="millaskm" />
				</span></p>
	</fieldset>
	</form>
</body>
</html>