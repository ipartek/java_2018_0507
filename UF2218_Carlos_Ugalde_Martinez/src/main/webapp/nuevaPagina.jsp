<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>Nueva Pagina</h1>
</header>

<p>Ultima pagina ${numPaginas}, nueva pagina: ${numPaginas + 1}</p>

<form action="nueva" method="post">
<label name="id" id="id" value="5"></label>
	<textarea rows="15" cols="40" name="texto" id="texto">${texto}</textarea>
	<p></p>
	<input type="text" name="nombre" id="nombre" readOnly
	 value="Autor: ${sessionScope.user.nombre}">

<p></p>
<p>
	<input type="submit" value="Aceptar">
</form>
</p>
