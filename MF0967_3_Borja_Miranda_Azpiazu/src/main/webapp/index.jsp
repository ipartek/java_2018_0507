<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Perros</h1>
</header>

<div id="container-fluid">





	<table class="table table-striped">

		<tr>
			<th>idPerro</th>
			<th>nombre</th>
			<th>edad</th>
			<th>raza</th>
			<th>KG</th>
			<th>apadrinado</th>
			<th>nidentificacion</th>
			<th>latitud</th>
			<th>longitud</th>
			<c:choose>
				<c:when test="${sessionScope.user != null}">


					<th>editar</th>
					<th>borrar</th>
				</c:when>

			</c:choose>
		</tr>
		<c:forEach items="${perros}" var="perro">
			<tr>

				<td>${perro.idPerro}</td>
				<td>${perro.nombre}</td>
				<td>${perro.edad}</td>
				<td>${perro.raza}</td>
				<td>${perro.kg}</td>
				<td>${perro.apadrinado}</td>
				<td>${perro.getChip().nidentificacion}</td>
				<td>${perro.getChip().getLongitud()}</td>
				<td>${perro.getChip().getLatitud()}</td>


				
				
				
				
				<c:choose>
				<c:when test="${sessionScope.user != null}">
				<td><a href="edicion.jsp?id=${perro.idPerro }&nombre=${perro.nombre}"><button>editar</button></a></td>
				<td><a href="borrar.jsp?id=${perro.idPerro }"><button>borrar</button></a></td>
			
				</c:when>

			</c:choose>
			</tr>
		</c:forEach>


	</table>


</div>


</div>



<%@ include file="/WEB-INF/includes/pie.jsp"%>