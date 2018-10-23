<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">

	<div class="col-lg-3">
		<h1 class="my-4">Lista Reproduccion</h1>
		<div class="list-group">

			<div class="accordion" id="listavideos">

				<c:forEach items="${usuarios}" var="usuario">

					<div class="card">
						<div class="card-header" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link" type="button"
									data-toggle="collapse" data-target="#usuario${usuario.id}"
									aria-expanded="true" aria-controls="collapseOne">${usuario.email}</button>
							</h5>
						</div>

						<div id="usuario${usuario.id}" class="collapse"
							aria-labelledby="headingOne" data-parent="#listavideos">
							<div class="card-body">
								<c:forEach items="${usuario.videos}" var="v">
									<a href="?idver=${v.id}" class="list-group-item">${v.nombre}</a>
									<a href="gestionvideos?id=${v.id}&accion=delete"> <i
										style="color: red;" class="float-right fas fa-trash-alt"></i>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>

				</c:forEach>


			</div>
		</div>
	</div>
	<!-- /.col-lg-3 -->

	<div class="col-lg-9">

		<div class="card mt-4">

			<iframe id="iframe" width="823" height="415"
				src="https://www.youtube.com/embed/${videoInicio.idVideo}"
				frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>

			<div class="card-body">
				<h3 class="card-title">${videoInicio.nombre}</h3>

				<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
					&#9734;</span> 4.0 stars
			</div>
		</div>
		<!-- /.card -->

		<div class="card card-outline-secondary my-4">
			<div class="card-header">Comentarios</div>
			<div class="card-body">
				<form action="enviarcomentario" method="post">
					<input type="hidden" name="id" value="${videoInicio.id}" />
					
					<div class="form-group row">
						<label for="texto" class="col-sm-2 col-form-label">Comentario</label>
						<div class="col-sm-10">
							<textarea class="form-control" id="texto" name="texto"
								placeholder="Texto del comentario"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<div class="offset-sm-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Enviar comentario</button>
						</div>
					</div>
				</form>

				<jsp:useBean id="hoy" class="java.util.Date" scope="page" />
				
				<small class="text-muted">Escrito por
					${usuario.email} el <fmt:formatDate value="${hoy}" pattern="yyyy-MM-dd" /></small>
				<hr>
				<c:forEach items="${videoInicio.comentarios}" var="comentario">
					<p>${comentario.texto}</p>
					<small class="text-muted">Escrito por
						${comentario.usuario.email} el ${comentario.fecha}</small>
					<hr>
				</c:forEach>
			</div>
		</div>
		<!-- /.card -->

	</div>
	<!-- /.col-lg-9 -->

</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>