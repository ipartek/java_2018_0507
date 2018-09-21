<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabeceraAdmin.jsp"%>
<header>
	<h1>Bienvenido</h1>
</header>
<table>
	<thead>
		<tr>
			<th>id</th><th>nombre</th><th> precio</th>
			<td><a href="edicion.jsp?accion=add">añadir</a></td>
		</tr>
	</thead>
	<tbody>
	<tr>
			<th>1</th><td>algo</td><td> 12.34</td>
			<a href="edicion.jsp?accion=editar">Editar</a>
			<a href="edicion.jsp?accion=borrar">borrar</a>
	</tr>
	<tr>
			<th>1</th><td>algo</td><td> 12.34</td>
	</tr>
	</tbody>
</table>
<%@ include file="/WEB-INF/includes/pie.jsp"%>