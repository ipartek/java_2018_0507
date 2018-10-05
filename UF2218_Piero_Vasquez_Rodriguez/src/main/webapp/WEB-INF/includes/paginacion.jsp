<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${pagina.numero > 1 }">
	<a href="index?pagina=${pagina.numero - 1 }">Anterior</a>
</c:if>
<c:if test="${pagina.numero < numeroPaginas }">
	<a href="index?pagina=${pagina.numero + 1 }">Siguiente</a>
</c:if>