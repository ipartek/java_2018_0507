<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ahorcado</title>
<link rel=StyleSheet href="index.css" />
</head>
<body id="cuerpoAhorcado">
	<jsp:useBean id="ahorcado" scope="request"
		class="com.ipartek.formacion.javaee.servlets.AhorcadoClass" />
	<br>
	<form action="ahorcado" method="post">
		<div id="divImgAhorcado">
			<h2 class="colorAhorcado">Ahorcado</h2>
			<br> <br> <img src="img/Ahorcado_entero.png" class="miau"
				alt="ahorcado" id="imgAhorcado" />
			<div id="palabra">
				<label class="colorAhorcado" contenteditable="true" value='<jsp_getProperty
				 property="palabraX" name="ahorcado"/>'>_ _ _ _ _ _ _ _</label>
			</div>
		</div>
		<div id="txtAhorcado">
			<p class="colorAhorcado">Introduzca la letra</p>
			<br> <input type="text" style="font-size: 25px;" id="intrLetras"
				name="letra" class="colorAhorcado" maxlength="1"
				value='<jsp:getProperty property="letra" name="ahorcado"/>'>
			<span class="errorLetra"> <jsp:getProperty
					property="mensajeErrorLetra" name="ahorcado" /></span>

		</div>
		<button>Go! Go! Go!</button>
	</form>
</body>
</html>