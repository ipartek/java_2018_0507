<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang=es>

<head>
<meta name="viewport" content="width=device-width, user-scalable=no" />
<title>Editar</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:useBean id="editor" scope="request"
		class="com.ipartek.formacion.javaee.supermercado.pojo.Producto" />
	<div class="jumbotron jumbotron-fluid text-center" id="Jumbo">
		<div class="container">
			<h1 class="display-4">Supermercado Tarari</h1>
		</div>
	</div>
	<!-- Barra de navegacion - Enlaces a login - editor - tabla - Registro de producto -->

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="paginaPrincipal.html" id="brand"><img
					src="imgs/supermercado.png"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="tabla.html">Listado Productos</a></li>
					<li><a href="Editor.html">Editar producto</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.html">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- fin barra navegacion -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12">
								<h1 class="text-center mod">Modificar/A&ntilde;adir</h1>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form id="login-form" action="editor" method="post" role="form"
									style="display: block;">
									<div class="row  editar"></div>
									<div class="form-group">
										<div class="col-md-2 etiquetas">Id</div>
										<div class="col-md-9">
											<input type="text" name="ID" id="id" tabindex="1"
												class="form-control  text-right" placeholder="Introduzca Id..." 
												value='<jsp:getProperty property="id" name="editor"/>'
												required>
										</div>
									</div>
									<div class="row editar"></div>
									<div class="form-group">
										<div class="col-md-2 etiquetas">Producto</div>
										<div class="col-md-9">
											<input type="text" name="Producto" id="producto" tabindex="2"
												class="form-control  text-right" placeholder="Introduzca producto..."
												value='<jsp:getProperty property="nombre" name="editor"/>' required>
										</div>
									</div>
									<div class="row  editar"></div>
									<div class="form-group">
										<div class="col-md-2 etiquetas">Precio</div>
										<div class="col-md-9">
											<input type="text" name="Precio" id="precio" tabindex="2"
												class="form-control  text-right" placeholder="Introduzca precio..."
												value='<jsp:getProperty property="precio" name="editor"/>' required>
										</div>
									</div>
									<div class="row editar"></div>
									<div class="form-group">
										<div class="col-md-2 etiquetas">Precio/Um</div>
										<div class="col-md-9">
											<input type="text" name="PrecioUm" id="precio/um"
												tabindex="4" class="form-control  text-right"
												placeholder="Introduzca precio * unidad de medida..."
												value='<jsp:getProperty property="precioUm" name="editor"/>'>
										</div>
									</div>
									<div class="row editar"></div>
									<div class="form-group">
										<div class="col-md-2 etiquetas">Descuento</div>
										<div class="col-md-9">
											<input type="text" name="Descuento" id="descuento"
												tabindex="4" class="form-control text-right"
												placeholder="Introduzca descuento..." 
												value='<jsp:getProperty property="descuento" name="editor"/>'>
										</div>
									</div>
									<div class="row editar">
										<div class="form-group">
											<div class="col-md-8 etiquetas aniadir">Introduzca
												imagen producto</div>
											<div class="col-md-4">
											<input type="file" name="Ruta" id="ruta" tabindex=5 
											value='<jsp:getProperty property="ruta" name="editor"/>'/>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-md-6 etiquetas">
												<input type="submit" name="Aceptar-submit"
													id="aceptar-submit" tabindex="4"
													class="form-control btn btn-primary" value="Aceptar">
											</div>
											<div class="col-md-6 etiquetas boton">
												<input type="submit" name="Cancelar-submit"
													id="cancelar-submit" tabindex="4"
													class="form-control btn btn-primary" value="Cancelar">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- boton TOP para ir a la parte superior de la pagina. -->
	<div class="container">
		<div class="row col-xs-12 text-center top">
			<div></div>
			<a href="Editor.html"><button type="button" class="btn btn-info ">Top</button></a>
		</div>
	</div>
	<footer>
		<!--
            Iconos para facebook, twitter, enlaces a politica de privacidad, contacto , LocalizaciÃ³n y logo de copyright con aÃ±o actual.
             -->
		<div class="container-fluid"></div>
		<div class="row" id="pie">
			<div class="col-xs-1 container"></div>
			<div class="col-xs-1 container">
				<a href="https://twitter.com/?lang=es"><img
					src="imgs/twitter.png" class="imageFooter"></a>
			</div>
			<div class="col-xs-1 container">
				<a href="https://es-es.facebook.com/"> <img class="imageFooter"
					src="imgs/facebook.png"></a>
			</div>
			<div class="col-xs-1 container"></div>
			<div class="col-xs-2 container"></div>
			<div class="col-xs-2 container"></div>
			<div class="col-xs-4 container" id="footerDerecha">
				<p>
					<a href="#">Politica de privacidad</a>
				</p>
				<p>
					<a href="#">Bilbao</a>
				</p>
				<p>
					<a href="#">@2018</a>
				</p>
			</div>
		</div>
	</footer>
</body>

</html>
