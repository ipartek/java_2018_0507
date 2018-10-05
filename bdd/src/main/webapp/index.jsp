<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Paginas</h1>
</header>

<div id="container-fluid">





	<table>

		<tr>
			<th>idlibro</th>
			<th>nombre</th>
			<c:choose>
				<c:when test="${sessionScope.user != null}">


					<th>editar</th>
					<th>borrar</th>
				</c:when>

			</c:choose>
		</tr>
		<c:forEach items="${libros}" var="libro">
			<tr>

				<td>${libro.idLibro}</td>
				<td>${libro.nombre}</td>
				<td>
				<c:choose>
				<c:when test="${sessionScope.user != null}">
				<td><a href="edicion.jsp?id=${libro.idLibro }&nombre=${libro.nombre}"><button>editar</button></a></td>
				<td><a href="borrar.jsp?id=${libro.idLibro }"><button>borrar</button></a></td>
			
				</c:when>

			</c:choose>
			</tr>
		</c:forEach>


	</table>


</div>


</div>



<%@ include file="/WEB-INF/includes/pie.jsp"%>