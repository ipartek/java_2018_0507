<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<c:if test="${pagina.numero > 1}">
	<a href="index?pagina=${pagina.numero - 1}">Anterior</a>
</c:if>
<c:if test="${pagina.numero < numeroPaginas}">
	<a href="index?pagina=${pagina.numero + 1}">Siguiente</a>
</c:if>