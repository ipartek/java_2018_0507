<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<a href="#">Página anterior</a>
<p>
	<a href="#">Siguiente página</a>
	<%
		String n = request.getParameter("id");

		if (n == null) {
	%>
	<section id="prueba">
		<c:forEach items="${paginas}" var="pagina">
			<a href="principal.jsp?id=${pagina.id}">${pagina.id}</a>
		</c:forEach>
	</section>
	<%
		} else {
	%>
	<section id="prueba">
		<c:forEach items="${paginas}" var="pagina">
			<a href="principal.jsp?id=${pagina.id}">${pagina.id}</a>
		</c:forEach>
	</section>
		<%
			}
		%>


		<%@ include file="/WEB-INF/includes/pie.jsp"%>