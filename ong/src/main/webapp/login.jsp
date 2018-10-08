<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>



<div class="row">

	<section class="box justify-content-center col-lg-4 col-md-5 col-sm-7 col-xs-12">
	
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
					<span class="text-danger">${errores}</span>
				</div>
			</div>
		</form>

	</section>
</div>

<%@ include file="includes/footer.jsp"%>