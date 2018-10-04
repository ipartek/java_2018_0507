<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${pagina.id > 1}">
	<a href="index?page=${pagina.id - 1}">&lt; Anterior </a>
</c:if>
<c:if test="${pagina.id < numeroPaginas}">
	<a href="index?page=${pagina.id + 1}"> Siguiente &gt;</a>
</c:if>