<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>ahorcado</title>
</head>
<body>
<jsp:useBean id="ahorcado" scope="request" class="com.ipartek.formacion.javaee.modelos.Ahorcado"></jsp:useBean>
	<h1>juego ahorcado</h1>
	<p id="miP">introduce tus <span class="destacado">credenciales </span>para <span class="destacado">iniciar </span> sesion</p>
	<form action="ahorcado" method="post">
		<fieldset>
		<%if(ahorcado.getVictoria()==1){  ahorcado.setReiniciar(); %>
		<a href="ahorcado.jsp">volver a empezar</a>
		<%} else{%>
			<legend>ahorcado</legend>
			<p>
				<label for="letraOpal"><jsp:getProperty property="palabraCod" name="ahorcado"/></label>
				<input type="text" name="letOpal" id="nombre"/>
				<button>enviar</button>
				<img class="img" alt="ahorca" src=<jsp:getProperty property="ruta" name="ahorcado"/> align="top">
				
			</p>
		<%}%>
		</fieldset>
	</form>
</body>
</html>