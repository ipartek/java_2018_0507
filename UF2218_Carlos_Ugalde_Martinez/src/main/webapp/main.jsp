<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>Libro</h1>
</header>


<p>Página ${pagina.id} / ${numPaginas}</p>

<!-- Paginacion -->
<c:if test="${pagina.id > 1}">
	<a href="index?pagina=${pagina.id - 1}">Anterior</a>
</c:if>
<c:if test="${pagina.id < numPaginas}">
	<a href="index?pagina=${pagina.id + 1}">Siguiente</a>
</c:if>
<!-- Fin Paginacion -->

<!-- <a href="#">Anterior</a><a href="#">Siguiente</a> -->
<p></p>
<c:if test="${sessionScope.user == null}">
	<textarea disabled rows="15" cols="40">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente laudantium, at natus ullam inventore sunt accusantium reprehenderit, quisquam delectus laborum nisi quia ratione voluptatum, accusamus mollitia autem deserunt quibusdam repudiandae.
</textarea>
</c:if>

<c:if test="${sessionScope.user != null}">

	<textarea rows="15" cols="40">${pagina.texto}</textarea>
	<p></p>
	<input type="text" disabled value="Autor: ${pagina.nombre}">
</c:if>
<p></p>
<p>
	<!-- PAginacion -->
	<c:if test="${pagina.id > 1}">
		<a href="index?pagina=${pagina.id - 1}">Anterior</a>
	</c:if>
	<c:if test="${pagina.id < numPaginas}">
		<a href="index?pagina=${pagina.id + 1}">Siguiente</a>
	</c:if>
	<!-- Aqui tenemos que añadir paginacion -->
</p>
<%@ include file="/WEB-INF/includes/pie.jsp"%>