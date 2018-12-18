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
	
	<h2>Busquedas</h2>
	<div class="row">
	
	<%@ include file="/jsp/busquedas.jsp" %>
		  
	  </div>
	  
	  <h2>Listado de Incidencias</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">&nbsp;&nbsp;ID</th>
				<th scope="col">Fecha Creacion</th>
				<th scope="col">Usuario Creador</th>
				<th scope="col">Titulo</th>
				<th scope="col">Descripcion</th>
				<th scope="col">Equipo</th>
				<th scope="col">Usuario Asignado</th>
				<th scope="col">Estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaincidencia}" var="incidencia">
			
				<tr>
				<form action="/modifIncidencia">
					<td class="col-lg-1"><input name="id" type="text" value="${incidencia.id}" readonly class="form-control  input-sm" /></td>
					<td><input name="fecha" type="text" value="${incidencia.fecha}" readonly class="form-control" /></td>
					<td class="col-lg-1"><input name="usuario_creador" type=text value="${incidencia.usuario_creador}" class="form-control"></td>
					<td><input name="titulo" type=text value="${incidencia.titulo}" class="form-control"></td>
					<td><input name="descripcion" type=text value="${incidencia.descripcion}" class="form-control"></td>
					<td class="col-lg-1"><input name="equipo" type=text value="${incidencia.equipo}" class="form-control"></td>
					<td>
						<select name="usuario_asignado" id="usuario_asignado" class="form-control input-normal">
						 <c:forEach var = "usuario" items="${listausuarios}">
	        				 <option  
	        				 	<c:if test="${usuario.email == incidencia.usuario_asignado}">
		        					selected
		        				</c:if>
		        				value="${usuario.email}">${usuario.email}
	        				 </option>
	     				 </c:forEach>
	     				 </select>
	     
	     			</td>
	     			
	     			<td> 
						<select name="estado" id="estado" class="form-control input-normal">
						 <c:forEach var = "estado" items="${listaestados}">
	        				 <option  
	        				 	<c:if test="${estado.estado == incidencia.estado}">
		        					selected
		        				</c:if>
		        				value="${estado.estado}">${estado.estado}
	        				 </option>
	     				 </c:forEach>
	     				 </select>
					</td>
					<td><button class="btn btn-default">Guardar</button></td>
				</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
