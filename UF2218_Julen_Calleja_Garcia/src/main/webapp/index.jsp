<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/cabezaPagina.jsp"%>


<main> 

<c:if test="${sessionScope.usuario != null}">
	<a href="escritura">Escribir página</a>
</c:if>
<form action="index">
	Ir a página <input type="number" name="pagina" />
</form>

<%@ include file="/WEB-INF/paginacion.jsp"%>

	<p>Página ${pagina.numero} / ${numeroPaginas}</p>
	<p>${pagina.contenido}</p>
	<p>${pagina.autor}</p>

<%@ include file="/WEB-INF/paginacion.jsp"%>
	

	<form action="buscarPalabra" method="post">
		Buscar palabra <input type="search" name="palabra" />
	</form>

<ul>
	<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
		<li><a href="index?pagina=${paginaResultado}">${paginaResultado}</a>
	</c:forEach>
	</ul>
</main>
<%@ include file="/WEB-INF/Pie.jsp"%>