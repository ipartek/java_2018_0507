<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/cabezaPagina.jsp"%>

<section id="paginacion">

	<c:forEach items="${paginas}" var="pagina">
		<article>

			<Label>Pagina</Label> ${paginas.id}

			<div>${paginas.texto}></div>

		</article>
	</c:forEach>
	<p>
	<label>Pagina</label> 
	</p>
	<p>
	<form action="escritura" method="post">
	<input type="text" name="texto" value="${paginas.text}">
	<button>Agregar texto</button>
	</form>
	</p>
	<p>
		<label>Autor</label>${usuario.nombre}
	</p>
</section>
<%@ include file="/WEB-INF/Pie.jsp"%>