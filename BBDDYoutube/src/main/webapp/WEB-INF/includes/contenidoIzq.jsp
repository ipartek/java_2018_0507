<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-4">
		<div class="well">
			<h2 class="text-center">Listado videos</h2>
			<div class="list-group">
			<p>
				<c:forEach items="${videos}" var="video">
					
				    <a href="#" onclick="reproducir('${video.idVideo}')" class="list-group-item">
				    	<span class="glyphicon glyphicon-play" aria-hidden="true"></span>
				    	${video.nombre}
				    </a>
          	  		<a href="?id=${video.idVideo}"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
				</c:forEach>
			</p>
          </div>
		</div>
	</div>
