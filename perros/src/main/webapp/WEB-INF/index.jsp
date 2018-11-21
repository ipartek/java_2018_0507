<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header class="jumbotron">
	<h1>Perros, perros, perros</h1>
</header>

<div class="row">

	<c:forEach items="${perros}" var="perro">

		<div class="col-sm-6 col-md-4 col-lg-3">
			<div class="thumbnail">
				<img
					src="imagenesperros/${perro.id}.jpg"
					alt="Foto del perro">
				<div class="caption">
					<h3>${perro.nombre}</h3>
					<p>${perro.raza}</p>
					<p>${perro.peso} kg</p>
					<p>${perro.edad} años</p>
					<p>${perro.apadrinado ? "Apadrinado" : "No apadrinado"}</p>
					
					<div class="chip">
						<p>Datos del chip</p>
						<p>${perro.chip.identificacion}</p>
						<p>
							<fmt:formatNumber pattern="##0.00000" value="${perro.chip.latitud}"/>, 
							<fmt:formatNumber pattern="##0.00000" value="${perro.chip.longitud}"/>
						</p>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>
