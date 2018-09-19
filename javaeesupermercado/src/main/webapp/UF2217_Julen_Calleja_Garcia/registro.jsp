<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro/Edicion</title>

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
				<li><a href="login.jsp">Login</a></li>
				<li><a href="registro.jsp">Registrar Producto</a></li>
				<li><a href="listado.jsp">Lista de Prodcutos</a></li>
			</ul>
		</nav>
		
		<header>
		<h2>Rellene los datos necesarios</h2>
	</header>
	<div class="row">

		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-3">
                    <form action="registroproducto" method="post">
                     <div class="form-group">
                        <label for="id">ID</label>
                        <input type="text" class="form-control" name="id"  placeholder="Id"  required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nombre del Producto</label>
                        <input type="text" class="form-control" name="nombre"   placeholder="Producto"  required>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Tipo</label>
                        <input type="text" class="form-control" name="tipo"  placeholder="Tipo: Ron, Vodka...">
                      </div>
                       <div class="form-group">
                        <label for="exampleInputPassword1">Precio</label>
                        <input type="number" class="form-control" name="precio"  placeholder="14,5..."  required>
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