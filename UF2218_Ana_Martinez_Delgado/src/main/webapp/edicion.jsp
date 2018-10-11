<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/includes/cabecera.jsp" %>

<form action="edicion" method="post">
	<textarea name="textarea" id="textarea" rows="15" cols="40" name="texto" maxlength="254">${texto}</textarea>
	<button>Aceptar</button>
	<span class="error">${error}</span>
</form>
<%@ include file="WEB-INF/includes/pie.jsp" %>