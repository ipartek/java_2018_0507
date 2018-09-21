<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabeceraAdmin.jsp"%>
<header>
	<h1>Administracion Edicion</h1>
</header>
<form action="edicion.jsp">
	<p>
	<label for="id">id</label>
	<input type="number" name="id" id="id" />
	</p>
	<p>
	<label for="nombre">nombre</label>
	<input type="text" name="nombre" id="nombre" />
	</p>
	<p>
	<label for="precio">precio</label>
	<input type="number" name="precio" id="precio" />
	</p>
</form>
<%@ include file="/WEB-INF/includes/pie.jsp"%>