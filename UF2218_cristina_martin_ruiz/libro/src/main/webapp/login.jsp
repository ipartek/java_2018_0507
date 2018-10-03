<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>



<div class="row">

	<section id="login" class="justify-content-center col-md-4">
	
	<h1 class="text-center">Login</h1>

		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label for="inputNombre"
					class="control-label">Nombre</label>
				<div class="">
					<input type="text" class="form-control"
						id="nombre" name="nombre" required="required" placeholder="Nombre">
					<span class="error">${user.errornombre}</span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword"
					class="control-label">Contraseña</label>
				<div class="">
					<input type="password" class="form-control" id="password"
						name="password" required="required" placeholder="Contraseña">
				</div>
			</div>
			<div class="form-group">
				<div class="">
					<button class="btn btn-primary btn-block">Entrar</button>
					<span class="error">${errores}</span>
				</div>
			</div>
		</form>

	</section>
</div>

	<%@ include file="/WEB-INF/includes/pie.jsp"%>