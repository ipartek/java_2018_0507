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
    	<h4 class="text-white">	<% if(session.getAttribute("usuario")!=null){ %>
			Bienvenido <%=(String)session.getAttribute("usuario")%> 
			<%}%> 
		</h4>
    </div>
  </div>
  <div class="collapse" id="navbarToggleExternalContent">
    <div class="bg-dark p-4">
      <a href="LogOut"><h4 class="text-white">logout</h4></a>
    </div>
  </div>
  <nav class="navbar navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span  class="navbar-toggler-icon"></span>
    </button>
  </nav>
</div>

<h1 id="titulo">TXAKUR-ETXE</h1>

<form class="form-horizontal" role="form" action="guardar">
  <div class="form-group">
    <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre del perro</label>
    <div class="col-lg-10">
      <input class="form-control" name="nombre">
    </div>
  </div>
  <div class="form-group">
    <label class="col-lg-2 control-label">edad del perro</label>
    <div class="col-lg-10">
      <input class="form-control" name="edad" pattern="\d*">
    </div>
  </div>
    <div class="form-group">
    <label class="col-lg-2 control-label">raza del perro</label>
    <div class="col-lg-10">
      <input class="form-control" name="raza">
    </div>
  </div>
    <div class="form-group">
    <label class="col-lg-2 control-label">peso del perro</label>
    <div class="col-lg-10" pattern="\d">
      <input class="form-control" name="peso">
    </div>
  </div>
    <div class="form-group">
    <label class="col-lg-2 control-label">id chip</label>
    <div class="col-lg-10">
    
      <input class="form-control"name="id" pattern="[1-9]{2}-[1-9]{4}-[1-9]{4}">
    </div>
  </div>
      <div class="form-group">
    <label class="col-lg-2 control-label">latitud</label>
    <div class="col-lg-10">
      <input class="form-control"name="latitud" pattern="\d*">
    </div>
  </div>
      <div class="form-group">
    <label class="col-lg-2 control-label">longitud</label>
    <div class="col-lg-10">
      <input class="form-control" name="longitud" pattern="\d*">
    </div>
  </div>
  <div class="form-group">
    <div class="col-lg-offset-2 col-lg-10">
      <button type="submit" class="btn btn-default">Realizar registro</button>
    </div>
  </div>
</form>
<footer>
</footer>
</body>

</html>