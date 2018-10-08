<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/includes/header.jsp"%>
<br />
<div>
	<h1>Listado de perros</h1>
	<div class="table-responsive">
		<table class="table table-hover">
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Raza</th>
				<th>Peso (kg)</th>
				<th>Apadrinado</th>
				<th>Nº de chip</th>
				<th>Última localización</th>
				<th><a href="perros" class="btn btn-default">Añadir...</a></th>
			</tr>

			<c:forEach items="${perros}" var="perros">

				<tr>
					<td>${perros.id}</td>
					<td>${perros.nombre}</td>
					<td>${perros.edad} años</td>
					<c:choose>
						<c:when test="${perros.raza==''}">
							<td>Milrazas</td>
						</c:when>
						<c:otherwise>
							<td>${perros.raza}</td>
						</c:otherwise>
					</c:choose>
					<td>${perros.peso}kg</td>
					<c:choose>
						<c:when test="${perros.apadrinado=='true'}">
							<td>Sí</td>
						</c:when>
						<c:otherwise>
							<td>No</td>
						</c:otherwise>
					</c:choose>

					<td>${perros.chip}</td>
					<td>${perros.latitud}-${perros.longitud}</td>

				</tr>
			</c:forEach>

		</table>
	</div>
</div>

<%@ include file="WEB-INF/includes/footer.jsp"%>
