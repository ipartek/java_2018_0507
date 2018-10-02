<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Registro</title>

<link rel="stylesheet" href="css/all.css">

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/shop-item.css" rel="stylesheet">
</head>
<body>

<h2>Rellene los datos necesarios</h2>
	
	<div class="row">

		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-3">
                    <form action="registro" method="post">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="text" class="form-control" name="email" required  >
                      </div>
                       <div class="form-group">
                        <label for="exampleInputPassword1">Contraseña</label>
                        <input type="text" class="form-control" name="password" required>
                      </div>
                      <div class="form-check"> 
                        <button type="submit" class="btn btn-primary">Registrar</button>
                      </div>
                      </form>
                    
		</div>		
	</div>
	
</body>
</html>