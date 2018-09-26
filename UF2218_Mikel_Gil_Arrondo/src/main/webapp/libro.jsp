<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<c:if test="${not empty user.nombre}">
			<p>
				<a href="escribirPagina.jsp">Escribir página</a>
			</p>
		</c:if>

		<p>
			<a href="ir_a_pagina">Ir a página</a> <input type="number" value="1"
				min="1">
		</p>
		<p>
			<a href="anterior">&lt; Anterior </a> <a href="anterior">
				Siguiente &gt;</a>
		</p>
		<div class="well bs-component">
			<div id="tituloLibro">Página 1/1</div>
			<div id="contenidoLibro">
				<p>Erase una vez... Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Fusce interdum neque a purus pulvinar, vel dapibus
					lorem cursus. Fusce purus turpis, pretium ac arcu eu, laoreet
					pretium lectus. Pellentesque ut massa nec orci viverra vulputate.
					Pellentesque ut nibh augue. Maecenas ultrices fermentum convallis.
				</p>
			</div>
			<div id="pieLibro">Autor: Pablo</div>
		</div>
		<p>
			<a href="anterior">&lt; Anterior </a> <a href="anterior">
				Siguiente &gt;</a>
		</p>
	</div>