<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabeceraContenido.jsp" %>

<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="row">
	<div class="col-md-12">
		<table class="table table-striped table-hover">
			<thead>
				<tr class="success">
					<th>ID VIDEO</th>
					<th>ID YOUTUBE</th>
					<th>NOMBRE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videos}" var="video">
					<tr>
						<td>${video.id}</td>
						<td>${video.idVideo}</td>
						<td>${video.nombre}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>