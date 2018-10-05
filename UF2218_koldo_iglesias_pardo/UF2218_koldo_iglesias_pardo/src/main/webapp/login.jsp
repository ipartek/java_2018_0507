<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="WEB-INF/includes/header.jsp"%>
<div>
	<h3>Inicie sesión en la plataforma</h3>

	<form action="login" id="login" method="POST">
		<p>
			<label for="user">Nombre de usuario: </label><br /> <input
				type="text" name="user" id="user" required="required"/><br /> <label for="pass">Contraseña:
			</label><br /> <input type="password" name="pass" id="pass" required="required" /><br /> <input
				type="submit" value="Iniciar sesión" />
		</p>
	</form>
</div>
<%@ include file="WEB-INF/includes/footer.jsp"%>