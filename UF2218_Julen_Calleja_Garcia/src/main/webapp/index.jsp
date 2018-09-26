<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/cabezaPagina.jsp"%>

<section id="paginacion">

	<c:forEach items="${paginas}" var="pagina">
		<article>

			<Label>Pagina</Label> ${pagina.id}

			<div>${pagina.texto}></div>

		</article>
	</c:forEach>
	<p>
	<label>Pagina</label> 
	</p>
	<p>
	<form action="escritura" method="post">
	<input type="text" name="texto" value="${pagina.texto}">
	<button>Agregar texto</button>
	</form>
	</p>
	<p>
		<label>Autor</label>${sessionScope.user.nombre}
	</p>
</section>
<%@ include file="/WEB-INF/Pie.jsp"%>