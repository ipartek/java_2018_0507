<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabezapagina.jsp"%>

<form action="login" method="post">
	<p>
		<label for="nombre">Nombre</label> <input type="text" name="text"
			id="text" />
	</p>
	<p>
		<label for="password">Contraseña</label> <input type="password"
			name="password" id="password" />
	</p>
	<p>
		<button>Entrar</button>
	</p>

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
			<th><a class="btn btn-primary" href="gestion?accion=insert">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${perros}" var="perro">
		<tr>
			<th>${perro.id}</th>
			<th>${perro.nombre}</th>
			<th>${perro.raza}</th>
			<th>${perro.peso }</th>
			<th>${perro.apadrinado}</th>
			<th>${perro.chipIdentificador }</th>
			<th>${perro.latitud }</th>
			<th>${perro.longitud}</th>
			<td><a class="btn btn-primary" href="gestion?accion=update&id=?">Editar</a>
				<a class="btn btn-danger" href="gestion?accion=delete&id=?">Borrar</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>


<%@ include file="/WEB-INF/includes/piepagina.jsp"%>