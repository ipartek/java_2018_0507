<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Productos</h1>
</header>

<section id="listado">

	<form action="principal" method="post">
	<p>
		<label for="id">Id</label>
		<input type="number" name="id" id="id" value="${producto.id}" />
	</p>
	<p>
		<label for="nombre">nombre</label>
		<input type="text" name="nombre" id="nombre" />
	</p>
	<p>
		<label for="precio">precio</label>
		<input type="number" name="precio" id="precio" />
	</p>
	<p>
		<button>Login</button>
	</p>
	
</form>
	
</section>

<%@ include file="/WEB-INF/includes/pie.jsp"%>