<%@page import="modelo.Perro" %>
<%@page import="modelo.ListaPerros" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>TXAKUR-ETXE</title>
	<!--bootstrap-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
	<!--mis ficheros css js -->
    <link rel="stylesheet" href="css/estilos.css" />
    <script src="js/index.js"></script>
	<link rel="icon" href="img/huella.png" type="image/x-icon"/>
	<link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet">
	</head>

<body>

<div class="pos-f-t">
  <div class="collapse" id="navbarToggleExternalContent">
    <div class="bg-dark p-4">
      <a href="Admin.jsp"><h4 class="text-white">entrar como administrador</h4></a>
    </div>
  </div>
  
  <nav class="navbar navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span  class="navbar-toggler-icon"></span>
    </button>
  </nav>
</div>
<form action="busqueda" method="get">
        <input name="busqueda" type="busqueda" >
        <input type="submit"value="buscar"></form>
<div class="container-fluid">
	<div class="row" >
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"><img src="img/banner.png" id="banner">
		</div>
	</div>
</div>

<h1 id="titulo">TXAKUR-ETXE</h1>
<div class="container">
	<% java.util.List<Perro> lista = ListaPerros.getListaPerros(); %>
	<table class="table table-striped "><tr>
		<th>nombre</th><th>edad</th><th>raza</th><th>peso</th><th>id</th><th>latitud</th><th>longitud</th><th>foto</th></tr>
		<% for(Perro a:lista){ %>
		<tr><td><%=a.getNombre() %></td><td><%=a.getEdad() %></td><td><%=a.getRaza() %></td><td><%=a.getPeso() %></td><td><%=a.getPojoChip().getId() %></td><td><%=a.getPojoChip().getLatitud() %></td><td><%=a.getPojoChip().getLongitud() %></td><td><img src="img/perro1.png" height="42" width="42"> </tr><%} %>
		
	</table>
</div>

<footer>
</footer>
</body>

</html>
