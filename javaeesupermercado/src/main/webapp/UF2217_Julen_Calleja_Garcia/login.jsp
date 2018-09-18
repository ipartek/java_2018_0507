<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilos.css" type="text/css">

<script src="js/bootsrap.min.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
</head>
<body id="bodyPr">

<div class="container">	

		<div class="row">
			<div class="col-xs-3 col-md-4 logo">
				<img class="logo" src="IMG/logo.png" alt="logo">
			</div>
			<div class="col-xs-6 col-md-8 titulo">Supermercados Julen</div>
		</div>


		<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="Principal.html">Bienvenido a Supermercados BM</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="login.html">Login</a></li>
				<li><a href="registro.html">Registrar Producto</a></li>
				<li><a href="listado.html">Lista de Prodcutos</a></li>
			</ul>
		</nav>
		<header>
	<h1>Buenos dias, introduzca sus datos de usuario para acceder</h1>
		</header>
	<div class="row">

		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-3">
		<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.controladores.LoginServlet" />
                    <form action="login" method="post">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email de Usuario</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email de registro"  required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password"  required>
                      </div>
                      <div class="form-check"> 
                        <button type="submit" class="btn btn-primary">Aceptar</button>
                      </div>
                      </form>
                    
		</div>		
	</div>
</div>	
</body>
</html>