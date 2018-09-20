
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Principal</title>
</head>
<body>

	<header>



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
					<img src="imgs/logo.png" alt="" id="logotipo" />
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a
							href="http://localhost:8080/pruebaServlet/listado.jsp">Listado
								de productos</a></li>
						<li><a
							href="http://localhost:8080/pruebaServlet/edicion.jsp">aÃ±adir
								producto</a></li>

					</ul>
					<form class="navbar-form navbar-right">
						<a
							href="http://localhost:8080/pruebaServlet/Login.jsp"
							class="btn btn-default">Registro</a>

					</form>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>


	<div class="center-block" id="contenedorproductos">
		<div class="row">
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row" id="row2">
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row" id="row3">
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2">
				<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">7-Keto DHEA 100 mg</h1>
				<h3 class="product-price">$12.99</h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				<button class="btn btn-success add-to-cart-button" rel="7_keto_dhea"
					product="7-Keto DHEA 100 mg" sel="12.99">aÃ±adir al carrito
				</button>

				<!-- END!! The Product Item -->
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-2"></div>
			<div class="col-md-2"></div>
			<div class="col-md-2"></div>
		</div>


	</div>


	<footer>
		<!-- Footer -->
		<section id="footer">
			<div class="container">
				<div
					class="row text-center text-xs-center text-sm-left text-md-left">
					<div class="col-xs-12 col-sm-12 col-md-12">

						<ul class="list-unstyled quick-links" id="listafooter">
							<li><a href="javascript:void();"><i
									class="fa fa-angle-double-right"></i>Politica de privacidad</a></li>
							<li><a href="javascript:void();"><i
									class="fa fa-angle-double-right"></i>Contacto</a></li>
							<li><a href="javascript:void();"><i
									class="fa fa-angle-double-right"></i>LocalizaciÃ³n</a></li>

						</ul>
					</div>

					<div>
						<i class="fab fa-twitter" id="twitter"></i> <i
							class="fab fa-facebook-f"></i>

					</div>

					<div class="row">
						<div
							class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">

							<p class="h6">
								&copy All right Reversed. 2018<a class="text-green ml-2"
									href="#" target="_blank">anamamm</a>
							</p>
						</div>
						</hr>
					</div>
				</div>
		</section>




		<!-- ./Footer -->
	</footer>

<a class="btn btn-default" href="http://localhost:8080/pruebaServlet/index.jsp" role="button" id="topb" style="display:none">TOP</a>
</body>
</html>


