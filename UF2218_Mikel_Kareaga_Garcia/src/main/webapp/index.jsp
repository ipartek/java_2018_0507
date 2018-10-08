<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<header>
	<h1>Libro digital</h1>
</header>

<main>
<c:if test="${sessionScope.usuario != null}">
	<a href="editar">Introducir texto</a>
</c:if>
<form action = "index">
	Ir a la pagina:<input type="number" name="pagina">
</form>

<%@ include file="/WEB-INF/includes/paginacion.jsp" %>


<p>Pagina ${pagina.id}/${pagina.numeroHojas}</p>
<p>${pagina.texto}</p>
<p>${pagina.autor}</p>

	<%@ include file="/WEB-INF/includes/paginacion.jsp" %>
	
	<form action="buscarPalabra" method="post">
		Buscar palabra <input type="search" name="palabra" />
	</form>
	
	<ul>
	<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
		<li><a href="index?pagina=${paginaResultado}">${paginaResultado}</a>
	</c:forEach>
	</ul>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp" %>