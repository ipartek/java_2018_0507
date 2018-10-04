<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>Nueva Pagina</h1>
</header>
<p>
</p>
<form action="nueva" method="post">
<label name="id" id="id" value="5"></label>
	<textarea name="texto" id="texto"></textarea><p></p>
	<input type="text" name="nombre" id="nombre"
	 value="Autor: ${sessionScope.user.nombre}">

<p></p>
<p>
	<input type="button" value="Incluir"></button>
</form>
</p>
<%@ include file="/WEB-INF/includes/pie.jsp"%>