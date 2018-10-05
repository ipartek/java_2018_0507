<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<header>
	<h1>Libro compartido</h1>
</header>

<main>
	<c:if test="${sessionScope.usuario != null}">
		<a href="edicion">Escribir página</a>
	</c:if>
	<form action="index">
		Ir a página <input type="number" name="pagina" /><input type="submit" name="buscar" id="buscar" value="Ir"/>
	</form>
	
	<%@ include file="/WEB-INF/includes/paginacion.jsp" %>
	
	<p>Página ${pagina.numero} / ${numeroPaginas}</p>
	<p>${pagina.contenido}</p>
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
