<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<header>
	<h1>Libro compartido</h1>
</header>

<main>
	<a href="edicion">Escribir página</a>
	<form action="index">
		Ir a página <input type="number" name="pagina" />
	</form>
	
	<c:if test="${pagina.numero > 1}">
		<a href="index?pagina=${pagina.numero - 1}">Anterior</a>
	</c:if>
	<c:if test="${pagina.numero <= numeroPaginas}">
		<a href="index?pagina=${pagina.numero + 1}">Siguiente</a>
	</c:if>
	
	<p>Página ${pagina.numero} / ${numeroPaginas}</p>
	<p>${pagina.contenido}</p>
	<p>${pagina.autor}</p>
	
	<c:if test="${pagina.numero > 1}">
		<a href="index?pagina=${pagina.numero - 1}">Anterior</a>
	</c:if>
	<c:if test="${pagina.numero != numeroPaginas}">
		<a href="index?pagina=${pagina.numero + 1}">Siguiente</a>
	</c:if>
	
	<form action="buscarPalabra" method="post">
		Buscar palabra <input type="search" name="palabra" />
	</form>
</main>

<%@ include file="/WEB-INF/includes/pie.jsp" %>
