<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp"%>
<%@ include file="includes/nav.jsp"%>

<header>
	<h1 class="text-center">Login</h1>
</header>

<div class="row">

	<div class="col-md-4"></div>

	<section id="formulario" class="col-md-4 well">

		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label for="nombre" class=" control-label">Nombre</label> <input
					type="text" class="form-control" id="nombre" name="nombre"
					required="required" placeholder="Nombre" value="${user.nombre}">
				<span class="error"></span>  <!-- user. viene de LoginServlet -->

			</div>
			<div class="form-group">
				<label for="password" class="control-label">Contraseña</label> <input
					type="password" class="form-control" id="password" name="password"
					required="required" placeholder="Contraseña">

			</div>
			<div class="form-group">
				<div class="">
					<button class="btn btn-primary">Entrar</button>
					<span class="error"></span>
				</div>
			</div>
		</form>

	</section>

	<div class="col-md-4"></div>

</div>

<%@ include file="includes/footer.jsp"%>