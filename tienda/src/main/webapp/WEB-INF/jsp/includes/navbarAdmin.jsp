<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="/"> <i class="fas fa-home"></i>
	</a>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link" href="/"><i
					class="fas fa-bolt"></i>&nbsp;Principal<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="/" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-cog"></i>&nbsp;&nbsp;Admin</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" id="btnAdminMantenimientoProductos">
						<i class="fas fa-users"></i>
					&nbsp;&nbsp;Mantenimiento productos </a> 
					<a class="dropdown-item" id="btnAdminMantenimientoRemotos">
						<i class="fas fa-bolt"></i>&nbsp;&nbsp;Mantenimiento productos remotos</a>
				</div>
			</li>
		</ul>

 		<form action="logout" method="post" class="form-inline my-2 my-lg-0">
 			<span class="navbar-text"> <i class="fas fa-user"></i> 
				&nbsp;Bienvenido ${user.nombre}&nbsp; 
 			</span>
 			<button class="btn btn-warning" type="submit"> 
				<i class="fas fa-sign-out-alt"></i>&nbsp;Logout 
 			</button> 
		</form>
	</div>
</nav>