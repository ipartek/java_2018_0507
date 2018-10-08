<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

	<h1 align="center">Perros Disponibles</h1>




<div class="container-fluid">
<div class="col-md-12" id="centro" style="    height: 400px;">
  <table class="table table-bordred table-striped" id="tdss">

		<tr>
		<th>Imagen</th>
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


					<th>borrar</th>
				</c:when>

			</c:choose>
		</tr>
		<c:forEach items="${perros}" var="perro">
			<tr>
				<td><img src="imgs/${perro.idPerro}.jpg" id="imgperro"></td>
				<td>${perro.nombre}</td>
				<td>${perro.edad}</td>
				<td>${perro.raza}</td>
				<td>${perro.kg}</td>
				<c:choose>
				<c:when test="${perro.apadrinado==true}">
				<td>Si</td></c:when>
				<c:otherwise>
				<td>no</td>
				</c:otherwise>
				</c:choose>
				<td>${perro.getChip().nidentificacion}</td>
				<td>${perro.getChip().getLongitud()}</td>
				<td>${perro.getChip().getLatitud()}</td>


				
				
				
				
				<c:choose>
				<c:when test="${sessionScope.user != null}">
				<td><a href="borrar.jsp?id=${perro.idPerro }"><button>borrar</button></a></td>
			
				</c:when>

			</c:choose>
			</tr>
		</c:forEach>


	</table>


</div>
</div>




<%@ include file="/WEB-INF/includes/pie.jsp"%>