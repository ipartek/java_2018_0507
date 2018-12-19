<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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

	<input type="hidden" id="userID" value="${user.id}">
	<input type="hidden" id="userNombre" value="${user.nombre}">
	<input type="hidden" id="userEmail" value="${user.email}">
	<input type="hidden" id="userRol" value="${user.rol}">
	
	<!-- SECTION NAVIGATION BAR -->
	<section id="navigation_bar">
		<c:choose>
			<c:when test="${user.rol == 'ADMINISTRADOR'}">
      			<%@ include file="/WEB-INF/jsp/includes/navbarAdmin.jsp"%>
    		</c:when>
			<c:otherwise>
        		<%@ include file="/WEB-INF/jsp/includes/navbarUser.jsp"%>
			</c:otherwise>
		</c:choose>
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
						<label for="inputUsuarioAsignado">Usuario asignado</label> <select
							id="inputUsuarioAsignado" class="form-control">
							<option value="0" selected>Usuario asignado...</option>
						</select>
					</div>
					<div class="form-group">
						<label for="inputDescripcion">Descripción</label>
						<textarea class="form-control" id="inputDescripcion" rows="4"></textarea>
					</div>
					<button type="submit" class="btn btn-primary offset-md-5">Crear
						incidencia</button>
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
				
				<form id="formNuevoUsuario" class="col-md-6 offset-md-3">
					<div class="form-group">
						<label for="inputNombre">Nombre</label> <input type="text"
							class="form-control" id="inputNombre" placeholder="Nombre">
					</div>
					<div class="form-group">
						<label for="inputEmail">Email</label> <input type="email"
							class="form-control" id="inputEmail" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="inputPassword">Password</label> <input type="password"
							class="form-control" id="inputPassword" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="inputRol">Rol</label> <select
							id="inputRol" class="form-control">
							<option value="USUARIO" selected>Usuario</option>
							<option value="ADMINISTRADOR">Administrador</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary offset-md-4">Crear
						usuario</button>
					<input id="btnCancelarNuevoUsuario" type="button" class="btn btn-danger" value="Cancelar">
				</form>
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