<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabezapagina.jsp"%>



<form action="login" method="post">

		
		<c:choose>
		<c:when test="${sessionScope.usuario == null}">
		<p>
			<label for="nombre">Nombre</label> <input type="text" name="nombre"
				id="text" />
		</p>
		<p>
			<label for="password">Contraseña</label> <input type="password"
				name="password" id="password" />
		</p>
		<p>
		</c:when>
		<c:otherwise>
			${sessionScope.usuario.nombre}
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${sessionScope.usuario == null}">
			<button>Entrar</button>
		</c:when>
		<c:otherwise>
			<a class="btn btn-danger" href="desconectar">Desconectar</a>
		</c:otherwise>
	</c:choose>
	

</form>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Raza</th>
			<th>Peso</th>
			<th>Apadrinado</th>
			<th>Numero Identificacion</th>
			<th>Latitud</th>
			<th>Longitud</th>
			<c:if test="${sessionScope.usuario != null}">
				<th><a class="btn btn-primary" href="anadir">Añadir</a></th>
			</c:if>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${perros}" var="perro">
			<tr>
				<th>${perro.id}</th>
				<th>${perro.nombre}</th>
				<th>${perro.raza}</th>
				<th>${perro.peso}</th>
				<th>${perro.apadrinado}</th>
				<th>${perro.chipIdentificador }</th>
				<th>${perro.latitud }</th>
				<th>${perro.longitud}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="/WEB-INF/includes/piepagina.jsp"%>