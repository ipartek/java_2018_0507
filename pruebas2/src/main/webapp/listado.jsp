<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Préstamo de libros</title>

    <link rel="stylesheet" href="css/estilos.css" />
    </head>
<body id="wat">

	<header>

		<h1 align="center">Carrefour</h1>
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
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="index.html" id="logoa"><img
								src="imgs/carrefour_logo.jpg" id="logo"></a></li>
						<li><a href="listado.html">Listado de artículos <span
								class="sr-only">(current)</span>
						</a></li>
						<li><a href="formulario.html">Registrar artículo</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="login.html">Login</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

	</header>



	<!-- cont central -->
	<section>
		<div class="container">
			<div class="row" id="listado">

				<div class="row">
					<input type="text" />
					<button>buscar</button>

				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>IDproducto</th>
							<th>Nombre</th>
							<th>Stock(Uds)</th>
							<th>Precio(€)</th>
							<th>editar</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Larios</td>
							<td>9</td>
							<td>21,9</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Bitterkas</td>
							<td>56</td>
							<td>4,3</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Jack Daniels</td>
							<td>3</td>
							<td>34,8</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
						<tr>
							<th scope="row">4</th>
							<td>JONNYE WALKER</td>
							<td>12</td>
							<td>40</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
						<tr>
							<th scope="row">5</th>
							<td>Barcelo</td>
							<td>5</td>
							<td>15,2</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
						<tr>
							<th scope="row">6</th>
							<td>Malibu</td>
							<td>7</td>
							<td>12</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
						<tr>
							<th scope="row">7</th>
							<td>Kolroff</td>
							<td>3</td>
							<td>3,5</td>
							<td><a href="formulario.html"><input type="submit"
									value="editar" class="btn btn-info btn-block"></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<footer class="page-footer font-small blue pt-4">

		<!-- Footer Links -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">

					<!-- Content -->
					<img alt="" src="imgs/carre.png" id="footerlogoizq">
					<p>Tu supermercado de confianza</p>
				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none pb-3">

				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<!-- Links -->
					<h5 class="text-uppercase">Siguenos</h5>

					<ul class="list-unstyled">
						<li><a href="#" class="fa fa-twitter" id="rss"></a></li>
						<li><a href="#" class="fa fa-facebook" id="rss"></a></li>


					</ul>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<!-- Links -->
					<h5 class="text-uppercase">Links</h5>

					<ul class="list-unstyled">
						<li><a href="#!">Política de privacidad</a></li>
						<li><a href="#!">Contacto</a></li>
						<li><a href="#!">Localización </a></li>

					</ul>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Links -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3" id="copy">
			<img alt="" src="imgs/carre.png" id="logofooter">© 2018
			Copyright: <a href="https://mdbootstrap.com/bootstrap-tutorial/">
				Carrefú.com</a>
		</div>
		<!-- Copyright -->

	</footer>
</body>
</html>
