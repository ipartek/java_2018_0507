<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<div class="row">
	<div class="col-md-4"></div>

	<div class="col-md-4">
		<div class="well bs-component">
			<header>
				<h1>Login</h1>
			</header>

			<form action="login" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nombre</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nombre" name="nombre"
							placeholder="Nombre" value="${user.nombre}" /> <span class="error">${user.errorNombre}</span>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Contraseña</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Login</button>
						<span class="error">${errores}</span>
						<br><span>Usuario: William Pass: Shakespeare</span>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>
</div>
</body>
</html>