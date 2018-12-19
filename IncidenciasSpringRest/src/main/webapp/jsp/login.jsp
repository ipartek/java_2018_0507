<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">


</head>
<body>
	<div class="d-flex justify-content-center align-items-center container ">  
	<h2>Incidencias</h2>

	<br>

	<form action="/" method="post" id="login">
		<div class="container-fluid">
			<div class="col-lg-4" id="userFormColumn1">
				<div class="form-group">
					<label for="user">Usuario: </label> 
					<input name="user" id="user" class="form-control input-normal">
				</div>
			</div>
			<div class="col-lg-4" id="userFormColumn2">
				<div class="form-group">
					<label for="password">Password:</label> 
					<input name="password" id="password" class="form-control input-normal">
				</div>
			</div>
		</div>
			<center>
				<button class="btn btn-secondary">LogIn</button>
			</center>
	</form>
	
	</div>
</body>
</html>