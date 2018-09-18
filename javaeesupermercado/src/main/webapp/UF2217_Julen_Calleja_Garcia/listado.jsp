<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado prodcutos</title>

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
	<div class="row">
	<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Tipo</th>
			<th>Precio</th>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>1</th>
			<td>Imperial</td>
			<td>Ron</td>
			<td>13,35€</td>
			<td><a class="btn btn-default" href="registro.html">Editar</a> <a
				class="btn btn-danger" href="registro.html">Borrar</a></td>
		</tr>
		<tr>
			<th>2</th>
			<td>Imperial</td>
			<td>Ron</td>
			<td>13,35€</td>
			<td><a class="btn btn-default" href="registro.html">Editar</a> <a
				class="btn btn-danger" href="registro.html">Borrar</a></td>
		</tr>
		<tr>
			<th>3</th>
			<td>Imperial</td>
			<td>Ron</td>
			<td>13,35€</td>
			<td><a class="btn btn-default" href="registro.html">Editar</a> <a
				class="btn btn-danger" href="registro.html">Borrar</a></td>
		</tr>
		<tr>
			<th>4</th>
			<td>Imperial</td>
			<td>Ron</td>
			<td>13,35€</td>
			<td><a class="btn btn-default" href="registro.html">Editar</a> <a
				class="btn btn-danger" href="registro.html">Borrar</a></td>
		</tr>
		
	</tbody>
	<tfoot>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>53,4€</td>
			<td><a class="btn btn-primary" href="registro.html">Añadir</a></td>
		</tr>
	</tfoot>
	</table>
	
	<form class="navbar-form navbar-left" role="search">
  	<div class="form-group">
    <input type="text" class="form-control" placeholder="Inserta el elemento">
 	</div>
  	<button type="submit" class="btn btn-default">Buscar</button>
	</form>
	</div>
</div>	
</body>
</html>