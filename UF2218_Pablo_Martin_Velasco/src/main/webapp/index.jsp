<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1 class="text-center">El libro comunitario</h1>
</header>


<form class="form-inline justify-content-center" action="index">
	<div class="form-group ">
		<span class="mr-1">Ir a la página:</span> <input type="number"
			class="form-control" name="pagina">
	</div>
</form>


<div class="row">
	<div class="box text-center">

		<div class="m-2">
			<c:if test="${pagina.numero > 1}">
				<a href="index?pagina=${pagina.numero - 1}"><i class="fa fa-arrow-left"></i>Pagina Anterior</a>
			</c:if>

			Página ${pagina.numero} / ${numeroPaginas}

			<c:if test="${pagina.numero < numeroPaginas}">
				<a href="index?pagina=${pagina.numero + 1}">Siguiente Pagina <i class="fa fa-arrow-right"></i></a>
			</c:if>
		</div>

		<div class="m-2">${pagina.contenido}</div>
		<div class="m-2">${pagina.autor}</div>

	</div>
</div>

</br>
</br>

<%@ include file="/WEB-INF/includes/pie.jsp"%>