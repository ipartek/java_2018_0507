<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>Nueva Pagina</h1>
</header>
<p>
</p>

	<textarea></textarea><p></p>
	<input type="text" value="Autor: ${sessionScope.user.nombre}">

<p></p>
<p>
	<button>Incluir</button>
</p>
<%@ include file="/WEB-INF/includes/pie.jsp"%>