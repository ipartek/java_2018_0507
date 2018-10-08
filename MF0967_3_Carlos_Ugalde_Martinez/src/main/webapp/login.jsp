<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="login.jsp" class="active" id="login-form-link">Login</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<!-- Comienzo Formulario -->
								<form id="login-form" action="login" method="post" role="form"
									style="display: block;">
									<div class="form-group">
										<label>Usuario</label>
										<input type="text" name="nombre" id="username" tabindex="1"
											class="form-control" placeholder="Usuario"
											value=''>
											<!-- Usamos span y el get property para enviar el mensaje de error -->
											<span class="errorNombre"></span>
									</div>
									<div class="form-group">
										<label>Contrase&ntilde;a</label> 
										<input type="password" name="clave" id="password" tabindex="2"
											class="form-control" placeholder="Clave" value=''>
											<span class="errorClave"></span>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
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

<%@ include file="/WEB-INF/includes/pie.jsp" %>
