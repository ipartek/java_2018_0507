<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>



<header>
	<h1 class="text-center">LIBRO</h1>
</header>

<c:if test="${not empty user.nombre}">

	<div class="btn btn-default">
		<a href="escribirPagina.jsp">Escribir página</a>
	</div>

</c:if>
</br>

<!-- <div class="row">
	<div class="well col-md-8 col-md-offset-2 ">

		<div class="well">
			<p>Erase una vez...</p>
		</div>

		<div id="pieLibro">Autor: Unkown</div>

	</div>
</div>

 -->
<table border="1" width="60%">

	<thead>
		<tr>
			<th>texto</th>
			<th>autor</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${paginas}" var="pagina">
			<tr>
				<td>${pagina.texto}</td>
				<td>${pagina.autor}</td>
			</tr>
		</c:forEach>

	</tbody>

</table>


</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>

