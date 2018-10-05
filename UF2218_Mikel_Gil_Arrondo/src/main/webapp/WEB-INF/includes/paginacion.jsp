<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- ANTERIOR -->
<c:choose>
    <c:when test="${pagina.id > 1}">
      <a href="index?page=${pagina.id - 1}">&lt; Anterior </a>
    </c:when>
    <c:otherwise>
    	<a href="index">&lt; Anterior </a>
    </c:otherwise>
</c:choose>

<!-- SIGUIENTE -->
<c:choose>
    <c:when test="${pagina.id < numeroPaginas}">
      <a href="index?page=${pagina.id + 1}"> Siguiente &gt;</a>
    </c:when>
    <c:otherwise>
    	<a href="index"> Siguiente &gt;</a>
    </c:otherwise>
</c:choose>

