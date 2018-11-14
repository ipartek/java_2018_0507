<%@ include file="/WEB-INF/include/cabecera.jsp" %>

<div class="container-fluid">
<c:if test="${sessionScope.usuario != null}">
	<h2>Usuario:  ${sessionScope.usuario.nick}</h2>
</c:if>
	<div class="table-responsive">
	<span class="error">${errores}</span>
	<table class="table table-striped table-responsive">
		<thead>
			<tr>
				<th>ID</th>
				<th>Chip</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Raza</th>
				<th>Peso</th>
				<th>Apadrinado</th>
				<th>Latitud</th>
				<th>Longitud</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perros}" var="perro">
				<tr>
					<td>${perro.id }</td>
					<td>${perro.chip }</td>
					<td>${perro.nombre }</td>
					<td>${perro.edad }</td>
					<td>${perro.raza }</td>
					<td>${perro.peso }</td>
					<td>${perro.apadrinado}</td>
					<td>${perro.latitud }</td>
					<td>${perro.longitud }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>

<%@ include file="/WEB-INF/include/pie.jsp" %>