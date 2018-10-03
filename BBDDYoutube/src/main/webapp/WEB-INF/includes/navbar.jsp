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
				<a class="navbar-brand" href="#"> 
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<form action="anadirContenido" method="post" class="navbar-form navbar-left">
				            <input name="idVideo" class="form-control" type="text" placeholder="ID 11 caracteres" title="11 caracteres" required pattern=".{11,11}">
				            <input name="nombreVideo" class="form-control" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
				            <button class="btn btn-success navbar-btn" type="submit">Añadir</button>
				         </form>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%-- <c:if test="${user.rol == 1}">
						<li>
							<a href="administrarUsers">Administrar</a>
						</li>
					</c:if> --%>
					<li><p class="navbar-text">
							<span class="glyphicon glyphicon-user" aria-hidden="true">
								Bienvenido ${user.nombre}</span>
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