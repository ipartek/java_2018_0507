<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/includes/cabeceraadmin.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="well well-sm">
					<form class="form-horizontal" action="procesaredicion" method="post">
						<fieldset>
							<legend class="text-center header">Nuevo producto</legend>

							<div class="form-group">
								<span class="col-md-1 col-md-offset-2 text-center"><i
									class="fa fa-user bigicon"></i></span>
								<div class="col-md-8">
									<input name="id" type="number" value="${prod.id}"
										placeholder="ID" class="form-control" 
											<c:if test="${param.accion == 'delete'}">
			readonly="readonly"
		</c:if> />
			</div>
							</div>
							<div class="form-group">
								<span class="col-md-1 col-md-offset-2 text-center"><i
									class="fa fa-user bigicon"></i></span>
								<div class="col-md-8">
									<input id="lname" name="nombre" type="text"value="${prod.nombre}"
										placeholder="Nombre" class="form-control" 	<c:if test="${param.accion == 'delete'}">
			disabled="disabled"
		</c:if> />
								</div>
								
							</div>
							
							<div class="form-group">
								<span class="col-md-1 col-md-offset-2 text-center"><i
									class="fa fa-user bigicon"></i></span>
								<div class="col-md-8">
									<input id="lname" name="precio" type="number" value="${prod.precio}"
										placeholder="Precio" class="form-control" 	<c:if test="${param.accion == 'delete'}">
			disabled="disabled"
		</c:if> />
								</div>
								
							</div>

							<!--  <div class="form-group">
								<span class="col-md-1 col-md-offset-2 text-center"><i
									class="fa fa-pencil-square-o bigicon"></i></span>
								<div class="col-md-8">
									<textarea class="form-control" id="message" name="message"
										placeholder="DescripciÃ³n del producto"
										rows="7" required></textarea>
								</div>
							</div>
							-->
<input type="hidden" name="accion" value="${param.accion}" />
							<div class="form-group">
								<div class="col-md-12 text-center">
									<button >${accion}</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	
<%@ include file="/WEB-INF/includes/pie.jsp" %>