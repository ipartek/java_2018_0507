<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>




<header>
	<h1 class="text-center">LIBRO</h1>
</header>


<form class="form-inline" action="index">
	<div class="form-group">
		<span class="mr-1">Ir a la página</span> <input type="number"
			class="form-control" name="pagina">
	</div>
</form>


<c:if test="${pagina.numero > 1}">
	<a href="index?pagina=${pagina.numero - 1}">Anterior</a>
</c:if>
<c:if test="${pagina.numero < numeroPaginas}">
	<a href="index?pagina=${pagina.numero + 1}">Siguiente</a>
</c:if>

<div class="row">
	<div id="login" class="justify-content-center col-md-5">

		<p class="text-center">Página ${pagina.numero} / ${numeroPaginas}</p>
		
		<p>${pagina.contenido}</p>
		<p>${pagina.autor}</p>		
		
	</div>
</div>

<form action="buscarPalabra" method="post">
	Buscar palabra <input type="search" name="palabra" />
</form>



<ul>
	<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
		<li><a href="index?pagina=${paginaResultado}">${paginaResultado}</a>
	</c:forEach>
</ul>


<%@ include file="/WEB-INF/includes/pie.jsp"%>

