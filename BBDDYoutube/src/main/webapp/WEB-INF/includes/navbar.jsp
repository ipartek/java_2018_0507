<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<!-- Navigation -->    
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="contenido"> 
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<c:if test="${sessionScope != null}">
						<li>
							<a href="administrar?accion=users" class="btn btn-success navbar-btn">Administrar usuarios</a>
						</li>
						<li>
							<a href="administrar?accion=videos" class="btn btn-success navbar-btn">Administrar videos</a>
						</li>
					</c:if>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><p class="navbar-text">
							<span class="glyphicon glyphicon-user" aria-hidden="true">
								Bienvenido ${sessionScope.user.nombre}</span>
						</p></li>
					<li>
						<form action="logout">
							<button type="submit" class="btn btn-danger navbar-btn">Log
								out  <span class="glyphicon glyphicon-off" aria-hidden="true"></span></button>
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>