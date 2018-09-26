<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<div class="row">
	<div class="col-md-4"></div>

	<div class="col-md-4">
		<div class="well bs-component">
			<header>
				<h1>Escribir en nueva página</h1>
			</header>

			<form action="editarLibro" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="autor" class="col-sm-2 control-label">Autor</label><br />
					<div class="col-sm-12">
						<input type="text" class="form-control" id="autor" name="autor"
							placeholder="Autor" value="${user.nombre}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label for="texto" class="col-sm-2 control-label">Texto</label><br />
					<div class="col-sm-12">
						<textarea class="form-control" id="texto" name="texto"
							placeholder="texto" rows="4" cols="20">
					</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" class="btn btn-default">Enviar</button>
						<button class="btn btn-primary">
							<a href="index.jsp" alt="Cancelar" class="botonCancelar">Cancelar</a>
						</button>
						<span class="error">${errores}</span>
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