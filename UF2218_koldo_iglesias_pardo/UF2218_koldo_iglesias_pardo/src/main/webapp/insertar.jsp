<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="WEB-INF/includes/header.jsp"%>
<div>
	<h3>Inicie sesión en la plataforma</h3>

	<form action="insertarpagina" id="insertarpagina" method="POST">
		<p>
			<label for="insertar">Escriba el contenido de la página a continuación: </label><br /> 
				 <textarea name="pagina" rows="10" cols="50" placeholder="Escriba la página aquí..."></textarea>
				 
				 <br /><input type="submit" value="Guardar cambios" />
		</p>
	</form>
</div>
<%@ include file="WEB-INF/includes/footer.jsp"%>