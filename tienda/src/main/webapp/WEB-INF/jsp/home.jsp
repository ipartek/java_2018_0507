<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tienda</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

<!-- Optional JavaScript -->
<!-- JQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script src="/js/index.js"></script>
<link href="/css/estilos.css" rel="stylesheet">

</head>
<body>
	<input type="hidden" id="localizacionDefault"
		name="localizacionDefault" value="1">
	<!-- SECTION NAVIGATION BAR -->
	<section id="sectionNavigationBar">
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

	<!-- SECTION CONTENT USER-->
	<section id="sectionContentUser">
		<div id="containerProductos" class="container-fluid card-columns"></div>
	</section>
	<!-- END SECTION CONTENT USER-->

	<!-- SECTION CONTENT MANTENIMIENTO PRODUCTOS -->
	<section id="sectionContentMantenimientoProductos">
		<div class="container-fluid">
			<div class="row">
				<h2>Todos los Productos</h2>
				<div class="col-md-12">
					<div class="table-responsive">
						<table id="tablaTodosLosProductos" name="tablaTodosLosProductos"
							class="table table-sm table-striped table-light table-hover">
							<thead>
								<tr class="table-success">
									<th scope="col">ID</th>
									<th scope="col">Nombre</th>
									<th scope="col">Descripcion</th>
									<th scope="col">Precio</th>
									<th scope="col">Imagen</th>
									<th scope="col"><a href="javascript:nuevoProducto()"
										class="btn btn-primary"><i class="fas fa-plus"></i>&nbsp;Nuevo
											producto</a></th>
								</tr>
							</thead>
							<tbody id="tbodyTodosLosProductos">
							</tbody>
						</table>

						<form id="formProducto" class="col-md-6 offset-md-3">
							<input type="hidden" id="inputProductoId" value="0">
							<div class="form-group">
								<label for="inputProductoNombre">Nombre</label> <input
									type="text" class="form-control" id="inputProductoNombre"
									placeholder="Nombre">
							</div>
							<div class="form-group">
								<label for="inputProductoDescripcion">Descripción</label>
								<textarea class="form-control" id="inputProductoDescripcion"
									rows="4" maxlength="200"></textarea>
							</div>
							<div class="form-group">
								<label for="inputProductoPrecio">Precio</label> <input
									type="number" class="form-control" id="inputProductoPrecio"
									placeholder="Precio" min="0" step="0.05">
							</div>
							<button type="submit" class="btn btn-primary offset-md-5">Crear
								producto</button>
							<input id="btnCancelarCrearProducto" type="button"
								class="btn btn-danger" value="Cancelar">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- END SECTION CONTENT MANTENIMIENTO PRODUCTOS -->

	<!-- SECTION CONTENT MANTENIMIENTO PRODUCTOS REMOTOS-->
	<section id="sectionContentMantenimientoProductosRemotos">
		<div class="container-fluid">
			<div class="row">
				<h2>Productos por almacen</h2>
				<div class="row col-md-12">
					<div id="capaBuscador" class="input-group col-md-4">
						<select id="inputBuscarPorUbicacion" class="form-control"
							aria-label="Estado">
						</select>
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button"
								id="btnBuscarPorUbicacion">Buscar por Ubicacion</button>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="table-responsive">
						<table id="tablaProductosRemotos" name="tablaProductosRemotos"
							class="table table-sm table-striped table-light table-hover">
							<thead>
								<tr class="table-success">
									<th scope="col">ID</th>
									<th scope="col">Nombre</th>
									<th scope="col">Descripcion</th>
									<th scope="col">Precio</th>
									<th scope="col">Imagen</th>
									<th scope="col">Almacen</th>
									<th scope="col">Stock</th>
									<th scope="col"><a
										href="javascript:nuevoProductoCompleto()"
										class="btn btn-primary"><i class="fas fa-plus"></i>&nbsp;Nuevo
											producto</a></th>
								</tr>
							</thead>
							<tbody id="tbodyProductosRemotos">
							</tbody>
						</table>

						<form id="formProductoCompleto" class="col-md-6 offset-md-3">
							<input type="hidden" id="inputProductoCompletoId" value="0">
							<div class="form-group">
								<label for="inputProductoCompletoNombre">Nombre</label> <input
									type="text" class="form-control"
									id="inputProductoCompletoNombre" placeholder="Nombre">
							</div>
							<div class="form-group">
								<label for="inputProductoCompletoDescripcion">Descripción</label>
								<textarea class="form-control"
									id="inputProductoCompletoDescripcion" rows="4" maxlength="200"></textarea>
							</div>
							<div class="form-group">
								<label for="inputProductoCompletoPrecio">Precio</label> <input
									type="number" class="form-control"
									id="inputProductoCompletoPrecio" placeholder="Precio" min="0"
									step="0.05">
							</div>
							<div class="form-group">
								<label for="inputProductoCompletoAlmacen">Almacen</label> <select id="inputProductoCompletoAlmacen"
									class="form-control">
								</select>
							</div>
							<div class="form-group">
								<label for="inputProductoCompletoStock">Stock</label> <input
									type="number" class="form-control"
									id="inputProductoCompletoStock" placeholder="Precio" min="0">
							</div>
							<button type="submit" class="btn btn-primary offset-md-5">Crear
								producto</button>
							<input id="btnCancelarCrearProductoCompleto" type="button"
								class="btn btn-danger" value="Cancelar">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- END SECTION CONTENT MANTENIMIENTO PRODUCTOS REMOTOS-->

	<!-- SECTION FOOTER -->
	<section id="sectionFooter">
		<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
	</section>
	<!-- END SECTION FOOTER -->
</body>
</html>