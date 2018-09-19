<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<meta charset="UTF-8">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no" />
<title>PaginaPrincipal</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<!-- Debe poderse ver en cualquier tamaÃ±o -->

<body>

	<!-- Jumbotron -->
	<div class="jumbotron jumbotron-fluid text-center" id="Jumbo">
		<div class="container">
			<h1 class="display-4">Supermercado Tarari</h1>
		</div>
	</div>
	<!--Fin jumbotron -->
	<!-- Barra de navegacion - Enlaces a login - tabla - Registro de producto -->

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
				<a class="navbar-brand" href="paginaPrincipal.jsp" id="brand"><img
					src="imgs/supermercado.png"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#"></a></li>
					<li><a href="tabla.jsp">Listado Productos</a></li>
					<li><a href="Editor.jsp">Editar producto</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- fin barra navegacion -->
	<!-- Visor: colecciÃ³n de 12 productos, ordenados en filas de 5 en 5.  -->
	<div class="container-fluid" id="margenVisor">
		<div class="row">
			<div class="col-xs-12 container">
				<div class="row center-block">
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail primer">
						<!--<div class="col-xs-1 segundo"><p>20%</p></div>-->
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn">
								<button type="button" class="btn btn-danger btn-number btnMenos"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">
							<span class="price--line-through">0,50â¬ </span> 0,25â¬
						</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>

						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
					<div
						class="col-xs-6 col-sm-4 col-md-2  text-center tamanioVisor thumbnail">
						<div class="row">
							<img src="imgs/100x140.png">
						</div>
						<div class="row precio">0,50â¬</div>
						<div class="row precioxq">1â¬/litro</div>
						<div class="row nombre">1/2 Leche</div>
						<div class="input-group">
							<span class="input-group-btn btnMenos">
								<button type="button" class="btn btn-danger btn-number"
									data-type="minus" data-field="quant[2]">
									<span class="glyphicon glyphicon-minus"></span>
								</button>
							</span> <input type="text" name="quant[2]"
								class="form-control input-number" value="0" min="1" max="100">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-number"
									data-type="plus" data-field="quant[2]">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</div>
						<div class="row text-center">
							<button type="button" class="btn btn-success aniadir">A&ntilde;adir</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin de Visor -->
	<!-- boton TOP para ir a la parte superior de la pagina. -->
	<div class="container">
		<div class="row text-right top">
			<a href="paginaPrincipal.jsp"><button type="button"
					class="btn btn-info">Top</button></a>
		</div>
	</div>
	<footer>
		<!--
            Iconos para facebook, twitter, enlaces a politica de privacidad, contacto , LocalizaciÃ³n y logo de copyright con aÃ±o actual.
             -->
             	
		<div class="container-fluid"></div>
		<div class="row" id="pie">
			<div class="col-xs-1 container"></div>
			<div class="col-xs-1 container twit">
				<a href="https://twitter.com/?lang=es"><img
					src="imgs/twitter.png" class="imageFooter"></a>
			</div>
			<div class="col-xs-1 container">
				<a href="https://es-es.facebook.com/"> <img class="imageFooter"
					src="imgs/facebook.png"></a>
			</div>

			<div class="col-xs-2 container"></div>
			<div class="col-xs-2 container"></div>
			<div class="col-xs-4 container" id="footerDerecha">
				<p>
					 <a href="#">Politica de privacidad</a> 
				</p>
				<jsp:useBean id="login" scope="request"
			class="com.ipartek.formacion.javaee.modelo.LoginForm" />
				<p><span class="error"><jsp:getProperty
		property="mensajeError" name="login" /></span>
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
