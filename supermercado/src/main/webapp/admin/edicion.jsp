<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp"%>

<header>
	<h1>Administración Edición</h1>
</header>

<form action="edicion.jsp">
	<p>
		<label for="id">Id</label>
		<input type="number" name="id" id="id" />
	</p>	
	<p>
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre" id="nombre" />
	</p>
	<p>
		<label for="precio">Precio</label>
		<input type="number" step=".01" name="precio" id="precio" />
	</p>
	<p>
		<button>Aceptar</button>
	</p>
</form>


<%@ include file="/WEB-INF/includes/pie.jsp"%>