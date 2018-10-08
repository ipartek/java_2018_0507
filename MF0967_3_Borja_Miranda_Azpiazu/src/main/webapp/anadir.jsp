<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


	<h1>Añadir</h1>

<div id="row">
<div id="col-xm-6">
<form action="Edicion" method="post">
	<p>
		<label for="text">Nombre</label>
		<input type="text" name="nombre"   />
	</p>
	
	
	<p>
		<label for="text">edad</label>
		<input type="number" name="edad"   />
	</p>
	<p>
		<label for="text">raza</label>
		<input type="text" name="raza"   />
	</p>
	<p>
		<label for="text">kg</label>
		<input type="number" name="kg"   />
	</p>
	
	<p>
		<label for="text">apadrinado</label>
		<input type="radio" name="apadrinado" value="true" checked> si<br>
  <input type="radio" name="apadrinado" value="false"> no<br>
	</p>
	<p>
		<label for="text">nidentificacion</label>
		<input type="number" name="nidentificacion"   />
	</p>
	
		<p>
		<label for="text">latitud</label>
		<input type="number" name="latitud"   />
	</p>
	
		<p>
		<label for="text">longitud</label>
		<input type="number" name="longitud"   />
	</p>
	
	
	
	
	
	
	
	<p>
		<button name="tipo" value="anadir">añadir</button>
	</p>
</form>
</div>
</div>
<%@ include file="/WEB-INF/includes/pie.jsp" %>