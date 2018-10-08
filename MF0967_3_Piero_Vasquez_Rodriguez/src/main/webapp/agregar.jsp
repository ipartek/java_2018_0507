<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/cabecera.jsp"%>

<div class="container-fluid">
<div class="col-lg-6 col-lg-offset-3">
<h2>Añadir nuevo perro</h2>
<form action="agregar" method="post">
	<div class="form-group">
		<label for="id">Id</label> 
		<input type="number" name="id" id="id" class="form-control" required/>
	</div>
	<div class="form-group">
		<label for="chip">Chip</label> 
		<input type="number" name="chip" id="chip" class="form-control" pattern="[1-9]{2}-[1-9]{4}-[1-9]{4}" required/>
	</div>
	<div class="form-group">
		<label for="nombre">Nombre</label> 
		<input type="text" name="nombre" id="nombre" class="form-control" required/>
	</div>
	<div class="form-group">
		<label for="raza">Raza</label> 
		<input type="text" name="raza" id="raza" class="form-control" />
	</div>
	<div class="form-group">
		<label for="edad">Edad</label> 
		<input type="number" placeholder="Años" name="edad" id="edad" class="form-control" required/>
	</div>
	<div class="form-group">
		<label for="peso">Peso</label> 
		<input type="number" placeholder="Kg..." name="peso" id="peso" class="form-control" required/>
	</div>
	<div class="form-group">
		<label for="apadrinado">Apadrinado</label> 
		<input type="text" placeholder="Si, no" name="apadrinado" id="apadrinado" class="form-control" required/>
	</div>
	<div class="form-group">
		<label for="longitud">Longitud</label> 
		<input type="number" name="longitud" id="longitud" class="form-control" required/>
	</div>
	<div class="form-group">
		<label for="latitud">Latitud</label> 
		<input type="number" name="latitud" id="latitud" class="form-control" required/>
	</div>
	<input type="submit" class="btn btn-primary" value="Añadir"/>
	<span class="error">${errores}</span>
</form>
</div>
</div>

<%@ include file="/WEB-INF/include/pie.jsp"%>