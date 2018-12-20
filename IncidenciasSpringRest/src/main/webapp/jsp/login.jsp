<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">


</head>
<body>
	<div class="d-flex justify-content-center align-items-center container ">  
	<h2>Incidencias Login</h2>

		<br>
	
		<div class="container">
		  <div class="row">
		    <div class="Absolute-Center is-Responsive">
		      <div class="col-sm-12 col-md-10 col-md-offset-1">
		      
		      
		      
				<form action="/" method="post" id="login">
				<div class="container-fluid">
					<div class="col-lg-4" id="userFormColumn1">
						<div class="form-group">
							<label for="user">Usuario: </label> 
							<input name="user" id="user" class="form-control input-normal">
						</div>
					</div>
					</div>
				<div class="container-fluid">
					<div class="col-lg-4" id="userFormColumn2">
						<div class="form-group">
							<label for="password">Password:</label> 
							<input name="password" id="password" class="form-control input-normal">
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="col-lg-4" id="userFormColumn2">
						<center>
							<button class="btn btn-primary btn-signin btn-default">LogIn</button>
						</center>
					</div>
				</div>
				</form>
				
				
			 </div>  
	   		 </div>    
	  		</div>
		</div>
	</div>
	
</body>
</html>