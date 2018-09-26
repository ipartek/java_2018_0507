<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/cabezaPagina.jsp" %>

<div>
	<label>Pagina</label>
</div>
<section id="paginacion">

	<c:forEach items="${paginas}" var="pagina">
		<article>
			
				<Label>Pagina</Label> ${paginas.id}
				
				<div>${paginas.texto}></div>
		
				
			
		</article>
	</c:forEach>
	<label>Autor</label>${usuario.nombre}
</section>
<%@ include file="/WEB-INF/Pie.jsp" %>