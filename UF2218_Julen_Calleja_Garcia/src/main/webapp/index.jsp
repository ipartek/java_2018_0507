<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/cabezaPagina.jsp"%>


<main> 

<c:if test="${sessionScope.usuario != null}">
	<a href="edicion">Escribir página</a>
</c:if>
<form action="index">
	Ir a página <input type="number" name="pagina" />
</form>

<%@ include file="/WEB-INF/paginacion.jsp" %>

<c:forEach items="${paginas}" var="pagina">
	<article>

		<Label>Pagina</Label> ${pagina.id}
		<div>${pagina.texto}></div>

	</article>
</c:forEach>
<p>
	<label>Pagina</label>
</p>

	<%@ include file="/WEB-INF/paginacion.jsp" %>
<p>
	<label>Autor</label>${sessionScope.user.nombre}
</p>

<ul>
	<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
		<li><a href="index?pagina=${paginaResultado}">${paginaResultado}</a>
	</c:forEach>
	</ul>
</main>
<%@ include file="/WEB-INF/Pie.jsp"%>