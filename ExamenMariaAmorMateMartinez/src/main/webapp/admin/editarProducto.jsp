<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<div class="container">

	<div class="row" id="pwd-container">
		<div class="col-md-4"></div>

		<div class="col-md-4">
		
			<section class="login-form">
			
			<h3 id="tit">Editar perro</h3>
			<br/>
			
				<form method="post" action="editarprod">

					<input type="text" name="id" class="form-control input-lg"
						   id="password" required readonly   value="${productoId.id}"/>

					<input type="text" name="nombre" placeholder="nombre" value="${productoId.nombre}" required class="form-control input-lg"/>


					<input type="number" name="edad" placeholder="5" value="${productoId.edad}" required class="form-control input-lg"/>

					<input type="text" name="raza" placeholder="beagle" value="${productoId.raza}" required class="form-control input-lg"/>

					<input type="number" name="peso" placeholder="30" value="${productoId.peso}" required class="form-control input-lg"/>

					<!-- Default inline 1-->
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="defaultInline1" <c:if test="${productoId.apadrinado==true}">checked</c:if> value= "true" name="apadrinado">
						<label class="custom-control-label"  for="defaultInline1">Apadrinado</label>
					</div>

					<!-- Default inline 2-->
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="defaultInline2" <c:if test="${productoId.apadrinado!=true}">checked</c:if> value= "false" name="apadrinado">
						<label class="custom-control-label" for="defaultInline2">No apadrinado</label>
					</div>


					<input type="text" name="identificador" placeholder="identificador" value="${productoId.chip.identificador}" required class="form-control input-lg"/>
					<input type="text" name="latitud" placeholder="80.00" value="${productoId.chip.latitud}" required class="form-control input-lg"/>
					<input type="text" name="longitud" placeholder="45.00" value="${productoId.chip.longitud}" required class="form-control input-lg"/>








					<div class="pwstrength_viewport_progress"></div>

					<button type="submit" name="" value="login"
						class="btn btn-lg btn-primary btn-block" id="botonsub">Editar</button>

				</form>
			<div>${error}</div>
			</section>
		</div>
	

		<div class="col-md-4"></div>


	</div>


</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>