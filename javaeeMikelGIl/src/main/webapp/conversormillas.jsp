<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Conversor millas/kms</title>
	<link rel="stylesheet" href="index.css">
</head>
<body>
	<%-- <jsp:useBean id="conversor" scope="request" class="com.ipartek.formacion.javaee.modelos.ConversorForm" /> --%>
	<h1>Conversor kilometros y millas</h1>
	<p id="mensaje">
		Introduce los kilometros o millas para convertir
	</p>
	<form action="conversor" method="post">
		<fieldset>
			<legend>Conversor KMs a millas</legend>
			<p>
				<label for="kms">KMs</label>
				<input type="text" name="kms" id="kms"/>
				<span class="errorTexto">
					<label for="millas">Millas:</label>
					<input type="text" name="kmsaMillas" id="kmsaMillas" />	
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
				<input type="text" name="millas" id="millas"/>
				<span class="errorTexto">
					<label for="kms">KMs:</label>
					<input type="text" name="millasaKms" id="millasaKms" />	
				</span>
			</p>
			<p>
				<button id="btnConvertirMillasAKms" name="button">Convertir</button>
			</p>
		</fieldset>
	</form>
</body>
</html>