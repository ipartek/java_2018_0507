<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap-litera-theme.min.css" rel="stylesheet">

<!-- Icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

<!-- SCRIPTS -->
<!-- Optional JavaScript -->
<!-- JQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<!-- Custom scripts -->
<script src="/js/index.js"></script>
<!-- Custom css -->
<link href="/css/estilos.css" rel="stylesheet">


<title>Gestión de incidencias</title>
</head>
<body>


	<!-- SECTION NAVIGATION BAR -->
	<section id="navigation_bar">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="/"> <i class="fas fa-home"></i>
			</a>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link" href="/"><i
							class="fas fa-bolt"></i>&nbsp;Mis incidencias<span
							class="sr-only">(current)</span> </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="/" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><i class="fas fa-cog"></i>&nbsp;&nbsp;Admin</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" id="btnAdminUsuarios"><i
								class="fas fa-users"></i>&nbsp;&nbsp;Usuarios</a> <a
								class="dropdown-item" id="btnAdminIncidencias"><i
								class="fas fa-bolt"></i>&nbsp;&nbsp;Incidencias</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" id="btnAdminHistorico"><i
								class="far fa-chart-bar"></i>&nbsp;&nbsp;Históricos</a>
						</div></li>
				</ul>

				<form action="logout" class="form-inline my-2 my-lg-0">
					<span class="navbar-text"> <i class="fas fa-user"></i>
						&nbsp;Bienvenido Antxon&nbsp;
					</span>
					<button class="btn btn-warning" type="submit">
						<i class="fas fa-sign-out-alt"></i>&nbsp;Logout
					</button>
				</form>
			</div>
		</nav>
	</section>
	<!-- END SECTION NAVIGATION BAR -->
	<div class="container-fluid">
		<!-- SECTION INCIDENCIAS -->
		<section id="seccionMisIncidencias">
			<div class="row">
				<h2>Mis Incidencias</h2>
				<div class="col-md-12">
					<div class="table-responsive">
						<table id="tablaMisIncidencias" name="tablaMisIncidencias"
							class="table table-sm table-striped table-light table-hover">
							<thead>
								<tr class="table-success">
									<th scope="col">ID</th>
									<th scope="col">Fecha</th>
									<th scope="col">Usuario creado</th>
									<th scope="col">Título</th>
									<th scope="col">Descripción</th>
									<th scope="col">Usuario Asignado</th>
									<th scope="col"><a href="javascript:nuevaIncidencia()"
										class="btn btn-primary"><i class="fas fa-plus"></i>&nbsp;Nueva
											incidencia</a></th>
								</tr>
							</thead>
							<tbody id="tbodyMisIncidencias">
							</tbody>
						</table>
					</div>
				</div>

				<form id="formNuevaIncidencia" class="col-md-6 offset-md-3">
					<div class="form-group">
						<label for="inputTitulo">Título</label> <input type="text"
							class="form-control" id="inputTitulo" placeholder="Titulo">
					</div>
					<div class="form-group">
						<label for="inputUsuarioAsignado">Usuario asignado</label> 
						<select id="inputUsuarioAsignado" class="form-control">
							<option value="0" selected>Usuario asignado...</option>
						</select>
					</div>
					<div class="form-group">
						<label for="inputDescripcion">Descripción</label>
						<textarea class="form-control" id="inputDescripcion"
							rows="4"></textarea>
					</div>
					<button type="submit" class="btn btn-primary offset-md-5">Crear incidencia</button>
				</form>
			</div>
		</section>
		<!-- END SECTION INCIDENCIAS -->

		<!-- SECTION ADMIN USUARIOS -->
		<section id="seccionUsuarios">
			<div class="row">
				<h2>Gestión usuarios</h2>
				<div class="col-md-12">
					<div class="table-responsive">
						<table id="tablaUsuarios" name="tablaUsuarios"
							class="table table-sm table-striped table-light table-hover">
							<thead>
								<tr class="table-info">
									<th scope="col">ID</th>
									<th scope="col">Nombre</th>
									<th scope="col">Email</th>
									<th scope="col">Password</th>
									<th scope="col">Rol</th>
									<th scope="col"><a href="javascript:crearUsuario()"
										class="btn btn-primary"><i class="fas fa-plus"></i>&nbsp;Nuevo
											usuario</a></th>
								</tr>
							</thead>
							<tbody id="tbodyUsuarios">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		<!-- END SECTION ADMIN USUARIOS -->

		<!-- SECTION FOOTER -->
		<div class="row">
			<footer class="footer">
				<div class="container">
					<span class="text-muted">Copyright &copy; 2018 Mikel Gil</span>
				</div>
			</footer>
		</div>
		<!-- END SECTION FOOTER -->
	</div>
</body>
</html>