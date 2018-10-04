<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1 class="text-center">LIBRO</h1>
</header>


<form class="form-inline justify-content-center" action="index">
	<div class="form-group ">
		<span class="mr-1">Ir a la página</span> <input type="number"
			class="form-control" name="pagina">
	</div>
</form>


<div class="row">
	<div class="box text-center col-md-5 col-sm-7 col-xs-12">

		<div class="m-2">
			<c:if test="${pagina.numero > 1}">
				<a href="index?pagina=${pagina.numero - 1}"><i class="fa fa-arrow-left"></i> Anterior</a>
			</c:if>

			Página ${pagina.numero} / ${numeroPaginas}

			<c:if test="${pagina.numero < numeroPaginas}">
				<a href="index?pagina=${pagina.numero + 1}">Siguiente <i class="fa fa-arrow-right"></i></a>
			</c:if>
		</div>

		<div class="m-2">${pagina.contenido}</div>
		<div class="m-2">${pagina.autor}</div>

	</div>
</div>


<form class="form-inline justify-content-center" action="buscarPalabra"
	method="post">
	<div class="form-group">
		<span class="mr-1"><i class="fa fa-search"></i> Buscar palabra</span> <input type="search"
			class="form-control" name="palabra" />
	</div>
</form>

<div class="text-center mb-5">
	<ul class="list-inline">
		<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
			<li class="list-inline-item"><a
				href="index?pagina=${paginaResultado}">${paginaResultado}</a></li>
		</c:forEach>
	</ul>
</div>
</br>
</br>

<%@ include file="/WEB-INF/includes/pie.jsp"%>