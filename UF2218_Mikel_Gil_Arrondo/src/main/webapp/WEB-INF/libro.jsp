<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<c:if test="${not empty sessionScope.user}">
			<p>
				<a href="editarLibro">Escribir página</a>
			</p>
		</c:if>
		<form action="index" method="get">
			<input type="number" value="1" min="1" name="page">
			<button type="submit" class="btn btn-default">Ir a página</button>
		</form>
		<p>
			<%@ include file="/WEB-INF/includes/paginacion.jsp" %>
		</p>
		<div class="well bs-component">
			<div id="tituloLibro">
				<p>Página ${pagina.id} / ${numeroPaginas}</p>
			</div>
			<div id="contenidoLibro">
				<p>${pagina.texto}</p>
			</div>
			<div id="pieLibro">
				<p>Autor: ${pagina.autor}</p>
			</div>
		</div>
		<p>
			<%@ include file="/WEB-INF/includes/paginacion.jsp" %>
		</p>
	</div>