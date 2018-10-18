<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-8">
	<div class="well well-lg">
		<h2 class="text-center">Videos</h2>
		<br />
		<iframe id="visionarYoutube" width="823" height="415"
			src="https://www.youtube.com/embed/${firstVideo.idVideo}"
			frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		<h3>${firstVideo.nombre }</h3>
		<p>${firstVideo.descripcion}</p>
	</div>
	<div class="well well-lg">
		<h3 class="text-center">Comentarios</h3>
		<c:forEach items="${comentarios}" var="comentario">
			<div class="panel panel-default">
				<div class="panel-heading">
					<p class="text-left">
						${comentario.nombre}
						<span style="float:right;">${comentario.fecha}</span>
					</p>
				</div>
				<div class="panel-body panel-body-comment"><p>${comentario.texto}</p></div>
			</div>
		</c:forEach>
	</div>
</div>
</div>