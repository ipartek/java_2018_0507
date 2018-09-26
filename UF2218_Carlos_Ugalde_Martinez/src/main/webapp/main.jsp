<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>Libro</h1>
</header>
<p>
	<a href="#">Anterior</a><a href="#">Siguiente</a>
</p>

<c:if test="${sessionScope.user == null}">
	<textarea disabled>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente laudantium, at natus ullam inventore sunt accusantium reprehenderit, quisquam delectus laborum nisi quia ratione voluptatum, accusamus mollitia autem deserunt quibusdam repudiandae.
</textarea>
</c:if>

<c:if test="${sessionScope.user != null}">

	<textarea>${paginas.texto}</textarea><p></p>
	<input type="text" disabled value="Autor: ${sessionScope.user.nombre}">
</c:if>	
<p></p>
<p>
	<a href="#">Anterior</a><a href="#">Siguiente</a>
</p>
<%@ include file="/WEB-INF/includes/pie.jsp"%>