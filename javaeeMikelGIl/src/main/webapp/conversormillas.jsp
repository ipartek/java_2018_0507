<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Conversor millas/kms</title>
	<link rel="stylesheet" href="index.css">
</head>
<body>
	<jsp:useBean id="conversor" scope="request" class="com.ipartek.formacion.javaee.modelos.ConversorForm" /> 
	<h1>Conversor kilometros y millas</h1>
	<p id="mensaje">
		Introduce los kilometros o millas para convertir
	</p>
	<form action="conversor" method="post">
		<fieldset>
			<legend>Conversor KMs a millas</legend>
			<p>
				<label for="kms">KMs</label>
				<input type="number" name="kms" id="kms" min="0" step=".01"
					value='<jsp:getProperty property="kms" name="conversor"/>' />
				<span class="errorTexto">
					<label for="millas">Millas:</label>
					<input type="text" name="kmsaMillas" id="kmsaMillas"
						value='<jsp:getProperty property="kmsaMillas" name="conversor"/>' />
				</span>
			</p>
			<p>
				<button id="btnConvertirKmsAMillas" name="button">Convertir</button>
			</p>
		</fieldset>
	</form>
	<form action="conversor" method="post">
		<fieldset>
			<legend>Conversor Millas a KMs</legend>
			<p>
				<label for="millas">Millas</label>
				<input type="number" name="millas" id="millas" min="0" step=".01"/>
				<span class="errorTexto">
					<label for="kms">KMs:</label>
					<input type="text" name="millasaKms" id="millasaKms"
						value='<jsp:getProperty property="millasaKms" name="conversor"/>' />
				</span>
			</p>
			<p>
				<button id="btnConvertirMillasAKms" name="button">Convertir</button>
			</p>
		</fieldset>
	</form>
</body>
</html>