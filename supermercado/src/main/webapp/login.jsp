<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@include file="cabecera.jsp"%>


<section id="formulario" class="col-12">

	<form class="form-horizontal" action="login" method="post">
		<div class="form-group">
			<label for="inputUsuario3"
				class="col-sm-offset-1 col-sm-2 control-label">Usuario</label>
			<div class="col-sm-7">
				<input class="form-control" required="required" type="text"
					name="nombre" id="nombre"
					value='<jsp:getProperty property="nombre" name="login"/>' /> <span
					class="errorTexto"> <jsp:getProperty property="errorNombre"
						name="login" />
				</span>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3"
				class="col-sm-offset-1 col-sm-2 control-label">Contraseña</label>
			<div class="col-sm-7">
				<input type="password" class="form-control" name="password"
					id="password" required="required" placeholder="Contraseña">
				<span class="errorTexto"> <jsp:getProperty
						property="errorPassword" name="login" />
				</span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-7">
				<div class="checkbox">
					<label> <input type="checkbox"> Recordar
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-8">
				<button class="btn btn-success">Entrar</button>
			</div>
			<span class="errorTexto"> <jsp:getProperty
					property="mensajeError" name="login" />
			</span>
		</div>
	</form>

	<%@ include file="pie.jsp"%>