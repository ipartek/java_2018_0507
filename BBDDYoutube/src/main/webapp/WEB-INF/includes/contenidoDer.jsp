<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-8">
	<div class="well well-lg">
		<h2 class="text-center">Videos</h2>
		<br />
		<iframe id="visionarYoutube" width="823" height="415"
			src="https://www.youtube.com/embed/${video.idVideo}" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
		<h3>${video.nombre }</h3>
		<p>${video.descripcion}</p>
	</div>
	<div class="well well-lg">
		<h3 class="text-center">Comentarios</h3>
		<form class="form-horizontal" action="anadirComentario" method="post">
			<div class="form-group">
				<input type="hidden" name="idVideo" value="${video.id}"> <label
					for="comentario">Comentario:</label>
				<textarea class="form-control" rows="4" name="textoComentario"></textarea>
			</div>
			<button type="submit" class="btn btn-success">Enviar
				comentario</button>
		</form>
		<br />
		<c:forEach items="${comentarios}" var="comentario">
			<div class="panel panel-default">
				<div class="panel-heading">
					<p class="text-left">
						${comentario.nombre} <span style="float: right;"> <fmt:formatDate
								value="${comentario.fecha}" pattern="yyyy-MM-dd HH:mm:ss" />
						</span>

					</p>
				</div>
				<div class="panel-body panel-body-comment">
					<p>${comentario.texto}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</div>