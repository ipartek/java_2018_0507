<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>



	<header>
		<h1 class="text-center">Login</h1>
	</header>

	<div class="row">

		<section id="formulario" class="col-md-8 col-md-offset-2 well">

			<form class="form-horizontal" action="login" method="post">
				<div class="form-group">
					<label for="inputNombre3"
						class="col-sm-offset-1 col-sm-2 control-label">Nombre</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="nombre" name="nombre"
							required="required" placeholder="Nombre" value="${user.nombre}">
						<span class="error">${user.errornombre}</span>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3"
						class="col-sm-offset-1 col-sm-2 control-label">Contraseña</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="password"
							name="password" required="required" placeholder="Contraseña">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-8">
						<button class="btn btn-primary">Entrar</button>
						<span class="error">${errores}</span>
					</div>
				</div>
			</form>

		</section>

	</div>

	<%@ include file="/WEB-INF/includes/pie.jsp"%>