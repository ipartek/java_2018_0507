<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/cabezaPagina.jsp" %>

<form action="escritura" method="post">
	<textarea rows="15" cols="40" name="texto">${texto}</textarea>
	<button>Aceptar</button>
	<span class="error">${error}</span>
</form>

<%@ include file="/WEB-INF/Pie.jsp" %>