<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-4">
		<div class="well well-success">
			<h2 class="text-center">Listado videos</h2>
			<br />
			<%-- <div class="list-group list-group-mine">
				<c:forEach items="${videos}" var="video">
					<a href="#" onclick="reproducir('${video.idVideo}')"
						class="list-group-item"> ${video.nombre} <span>
							(${video.nombreUsuario}) </span> <span
						class="glyphicon glyphicon-play badge"> </span>
					</a>
					<a href="?id=${video.idVideo}"><i style="color: red;"
						class="float-right fas fa-trash-alt"></i></a>
				</c:forEach>
			</div> --%>
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<c:forEach items="${usuarios}" var="usuario">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading${usuario.id}">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapse${usuario.id}" aria-expanded="true"
									aria-controls="collapse${usuario.id}">${usuario.nombre}</a>
							</h4>
						</div>
						<c:choose>
							<c:when test="${usuario.nombre eq sessionScope.user.nombre}">
								<div id="collapse${usuario.id}" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="heading${usuario.id}">
							</c:when>
							<c:otherwise>
								<div id="collapse${usuario.id}" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading${usuario.id}">
							</c:otherwise>
						</c:choose>
							<div class="panel-body panel-body-mine">
								<div class="list-group list-group-mine">
									<c:forEach items="${videos}" var="video">
										<c:if test="${video.idUsuario eq usuario.id}">
											<a href="#" onclick="reproducir('${video.idVideo}'); return false;"
												class="list-group-item"> ${video.nombre}<span
												class="glyphicon glyphicon-play badge"> </span>
											</a>
											<a href="?id=${video.idVideo}"><i style="color: red;"
												class="float-right fas fa-trash-alt"></i></a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>