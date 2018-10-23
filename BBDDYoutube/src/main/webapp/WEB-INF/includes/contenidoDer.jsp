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
		<form action="puntuar" method="post">
			<input type="hidden" name="id" value="${video.id}" />
			<fieldset class="rating">
				<input type="radio" id="star5" name="rating" value="5" onclick="submit()"/>
				<label class="full" for="star5" title="Awesome - 5 stars"></label> 
				<input type="radio" id="star4" name="rating" value="4" onclick="submit()"/>
				<label class="full" for="star4" title="Pretty good - 4 stars"></label> 
				<input type="radio" id="star3" name="rating" value="3" onclick="submit()"/>
				<label class="full" for="star3" title="Meh - 3 stars"></label> 
				<input type="radio" id="star2" name="rating" value="2" onclick="submit()"/>
				<label class="full" for="star2" title="Kinda bad - 2 stars"></label> 
				<input type="radio" id="star1" name="rating" value="1" onclick="submit()"/>
				<label class="full" for="star1" title="Sucks big time - 1 star"></label>
			</fieldset>
		</form>
		<span class="text-warning"  style="float: right;">
		Media: 
			<c:forEach begin="1" end="5" var="index">
				<c:choose>
					<c:when test="${puntos >= index}">
				       &#9733;
				    </c:when>
				    <c:otherwise>
				    	&#9734;
				    </c:otherwise>
				</c:choose>
			</c:forEach>
			${puntos} stars
		</span>
		<br /><br />
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
			<button type="submit" class="btn btn-success">Enviar comentario</button>
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