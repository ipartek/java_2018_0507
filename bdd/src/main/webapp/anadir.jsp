<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


	<h1>Añadir</h1>

<div class="col-sm-3"></div>
<div class="col-sm-6" style="padding:50px 0">
<form action="Edicion" method="post">
	<p>
		<label for="text">Nombre</label>
		<input type="text" name="nombre"   />
	</p>
	
	<p>
		<button name="tipo" value="anadir">añadir</button>
	</p>
	
</form>
</div>
<div class="col-sm-3"></div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>