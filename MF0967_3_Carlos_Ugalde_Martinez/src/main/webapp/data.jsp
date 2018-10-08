<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-6">
									<a href="" class="active" id="login-form-link">Nuevo
										perro</a>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="data-management-form" action="insert" method="post"
								role="form" style="display: block;">
								<input type="hidden" name="id" value="${dog.id}" />
								<div class="form-group">
									<label>Nombre</label> <input type="text" required
										value="${dog.nombre}" name="nombre" id="nombre" tabindex="1"
										class="form-control" placeholder="Nombre...">
								</div>
								<div class="form-group">
									<label>Edad</label> <input type="number" required
										value="${dog.edad}" name="edad" id="edad"
										tabindex="2" maxlength="2" min="1" max="99" class="form-control"
										placeholder="Edad...">
								</div>
								<div class="form-group">
									<label>Raza</label> <input type="text" value="${dog.raza}" 
										name="raza" id="raza" tabindex="3" class="form-control"
										placeholder="Raza...">
								</div>
								<div class="form-group">
									<label>Peso</label> <input type="text" value="${dog.peso}" required
										name="peso" id="peso" max="99" tabindex="4" class="form-control"
										placeholder="Peso...">
								</div>
								<div class="form-group">
									<label>Apadrinado</label> <input type="number" maxlength="1" value="${dog.apadrinado}" 
										name="apadrinado" id="apadrinado" tabindex="5" class="form-control" required
										placeholder="1 para apadrinado, otro valor no apadrinado...">
								</div>
								<div class="form-group">
									<label>Chip</label> <input type="text" value="${dog.chip}" required
										name="chip" id="chip" maxlength="12" tabindex="6" class="form-control"
										placeholder="Chip...">
								</div>
								<div class="form-group">
									<label>Latitud</label> <input type="text" value="${dog.latitud}" required
										name="latitud" id="latitud" maxlength="8" tabindex="7" class="form-control"
										placeholder="Latitud...">
								</div>
								<div class="form-group">
									<label>Longitud</label> <input type="text" value="${dog.longitud}" required
										name="longitud" id="longitud" maxlength="8" tabindex="8" class="form-control"
										placeholder="Latitud...">
								</div>
								<div><label>${dog.errorChip}</label></div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<button type="submit" class="btn btn-primary" tabindex="9">Continuar
											</button>
											<a href="index" tabindex="10" class="btn btn-danger">Cancelar</a>
										</div>
									</div>
									</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>