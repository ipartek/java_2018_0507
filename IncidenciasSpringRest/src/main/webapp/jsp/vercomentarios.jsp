<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">

<meta charset="UTF-8">
</head>
<body class="container-fluid">
<%@ include file="/jsp/index.jsp" %>
	<h2>Comentarios sobre incidencias</h2>
	
	
	
	  
	  <div class="col-sm-3">
  
		   <form action="/buscarComentarioxIncidencia">
					Buscar comentario por incidencia:  &nbsp;
					<input type="text" name="incidencia_id" id="incidencia_id"  class="input-sm">
					<button class="btn btn-default">Buscar</button>
					
				</form>
		  
  		</div>
  		<div class="col-sm-3" >
		  <div class="row"><br>
			 	<a href="/ListadoComentarios" class="btn btn-default">Listadocomentarios</a>
		  </div>
	  </div>
	   
	  
	<table class="table">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">ID_Incidencia</th>
				<th scope="col">Usuario</th>
				<th scope="col">Fecha</th>
				<th scope="col">Comentario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listacomentarios}" var="comentario">
				<tr>
					<form>
					<td><input type="hidden" name="id" value="${comentario.id}" readonly class="form-control" /></td>
					<td><input type="text" name="id_incidencia" value="${comentario.id_incidencia}" readonly class="form-control" /></td>
					<td><input name="usuario" type="text" value="${comentario.usuario}" readonly class="form-control"></td>
					<td><input name="fecha" type="text" value="${comentario.fecha}" readonly class="form-control"></td>
					
					<td><input name="comentario" type="text" value="${comentario.comentario}" readonly class="form-control"></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
