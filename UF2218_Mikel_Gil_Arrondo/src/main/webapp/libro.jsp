<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<c:if test="${not empty user.nombre}">
			<p>
				<a href="escribirPagina.jsp">Escribir página</a>
			</p>
		</c:if>
		<p>
		<form action="index" method="get">
			<input type="number" value="1" min="1" name="page">
			<button type="submit" class="btn btn-default">Ir a página</button>
		</form>
		</p>
		<p>
			<c:choose>
				<c:when test="${not empty libro.id}">
				
					<a href="index?page=${libro.id-1}">&lt; Anterior </a>
					<a href="index?page=${libro.id+1}"> Siguiente &gt;</a>
				</c:when>
				<c:otherwise>
					<a href="index?page=1">&lt; Anterior </a>
					<a href="index?page=1">Siguiente &gt;</a>
				</c:otherwise>
			</c:choose>
		</p>
		<div class="well bs-component">
			<div id="tituloLibro">
				<c:choose>
					<c:when test="${not empty libro.id}">
					Página ${libro.id} / ${libro.totalid}
				</c:when>
					<c:otherwise>
					Página 1/1
				</c:otherwise>
				</c:choose>
			</div>
			<div id="contenidoLibro">
				<c:choose>
					<c:when test="${not empty libro.texto}">
        			${libro.texto}
    			</c:when>
					<c:otherwise>
						<p>Erase una vez... Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Fusce interdum neque a purus pulvinar, vel
							dapibus lorem cursus. Fusce purus turpis, pretium ac arcu eu,
							laoreet pretium lectus. Pellentesque ut massa nec orci viverra
							vulputate. Pellentesque ut nibh augue. Maecenas ultrices
							fermentum convallis.</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="pieLibro">
				<c:choose>
					<c:when test="${not empty libro.autor}">
					Autor: ${libro.autor}
				</c:when>
					<c:otherwise>
					Autor: Pablo
				</c:otherwise>
				</c:choose>
			</div>
		</div>
		<p>
			<c:choose>
				<c:when test="${not empty libro.id}">
					<a href="index?page=${libro.id-1}">&lt; Anterior </a>
					<a href="index?page=${libro.id+1}"> Siguiente &gt;</a>
				</c:when>
				<c:otherwise>
					<a href="index?page=1">&lt; Anterior </a>
					<a href="index?page=1">Siguiente &gt;</a>
				</c:otherwise>
			</c:choose>
		</p>
	</div>