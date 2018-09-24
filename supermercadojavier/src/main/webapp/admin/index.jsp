<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp"%>

<header>
	<h1>Administración</h1>
</header>

<div class="mensaje">
	${mensaje}
</div>

<table id="adminlistado">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
<<<<<<< HEAD
			<td><a href="edicion.jsp?accion=add">Añadir</a></td>
=======
			<td><a href="edicion?accion=add">Añadir</a></td>
>>>>>>> branch 'master' of https://github.com/ipartek/java_2018_0507.git
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<th>${producto.id}</th>
				<td>${producto.nombre}</td>
				<td><fmt:formatNumber value="${producto.precio}" type="currency" /></td>
<<<<<<< HEAD
				<td><a href="edicion.jsp?id=${producto.id}&accion=update">Editar</a> <a
					href="edicion.jsp?id=${producto.id}&accion=delete">Borrar</a></td>
=======
				<td><a href="edicion?id=${producto.id}&accion=update">Editar</a> <a
					href="edicion?id=${producto.id}&accion=delete">Borrar</a></td>
>>>>>>> branch 'master' of https://github.com/ipartek/java_2018_0507.git
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp"%>