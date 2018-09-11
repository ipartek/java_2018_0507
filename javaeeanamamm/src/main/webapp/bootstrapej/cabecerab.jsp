






<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Ej bootstrap ana</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estiloanab.css" />

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>

<!-- ENCABEZADO-->

	<header>
		<div class="row">
			<div class="col-sm-12">
				<div class="page-header">
					<h1>
						Libros <small>tu biblioteca online</small>
					</h1>
				</div>
			</div>
		</div>

	</header>


	<!-- NAV PRINCIPAL -->

	<div class="row">
		<div class="col-sm-12">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Todos los libros</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">inform�tica<span
									class="sr-only">(current)</span></a></li>
							<li><a href="#">historia</a></li>
							<li><a href="#">ensayos</a></li>

						</ul>



						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">Login</a></li>
							<li><a href="#">Editar</a></li>

						</ul>

					</div>


					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
	</div>

	<!-- DIV CENTRAL -->
	<!-- div central que envuelve la lista el hueco medio y el de la derecha -->
	<div class="row" id="envolvente">
		<div class="col-sm-12">

			<!-- lista -->

			<div class="col-sm-2" id="lista">

				<ul class="nav navbar-nav">
					<li class="active"><a href="#">inform�tica<span
							class="sr-only">(current)</span></a></li>
					</br>
					<li><a href="#">historia</a></li>
					</br>
					<li><a href="#">ensayos</a></li>

				</ul>

			</div>



			<!-- hueco grande otras pag html -->

			<div class="col-sm-8" id="huecogrande"></div>



			<!-- hueco peque�o derecha -->


			<div class="col-sm-2" id="hueco"></div>


		</div>
	</div>

<section id="principal">
