<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-4">
		<div class="well well-success">
			<h2 class="text-center">Listado videos</h2><br/>
			<div class="list-group list-group-mine">
				<c:forEach items="${videos}" var="video">
				    <a href="#" onclick="reproducir('${video.idVideo}')" class="list-group-item">
				    	${video.nombre}
				    	<span class="glyphicon glyphicon-play badge"> </span>
				    </a>
          	  		<a href="?id=${video.idVideo}"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
				</c:forEach>
          </div>
		</div>
	</div>
