<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<div class="well bs-component">
			<form class="form-horizontal" action="login" method="post">
				<div class="form-group">
					<label for="nombre" class="col-sm-2 control-label">Nick</label>
					<div class="col-sm-10">
						<input type=text class="form-control" id="nombre"
							placeholder="Nick">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Contraseña</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							placeholder="Contraseña">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button type="submit" class="btn btn-default">Sign in</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>