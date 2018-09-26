
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp"%>

<header>
	<h1>Listado de paginas</h1>
</header>

<div class="mensaje">
</div>
			<td><a href="edicion?accion=add"><H1 align="center">Añadir Pagina</H1></a></td>

<table id="adminlistado">
	<thead>
		<tr>
			<th>Id</th>
			<th>Texto</th>
			<th>Autor</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${paginas}" var="pagina">
			<tr>
				<th>${pagina.id}</th>
				<td><br><br>${pagina.texto}</td>
				<td>${pagina.nick}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp"%>