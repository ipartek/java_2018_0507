<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estiloanab.css" />
<link rel="stylesheet" href="css/formb.css" />

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>

<body>

	<%@ include file="cabecerab.jsp"%>
	<%@ include file="huecoizqb.jsp"%>

	<!-- LOGIN FORM -->





	<!-- LOGIN FORM -->
	
	
		
	
	
	<div class="text-center" style="padding: 50px 0">
		<div class="logo">login</div>
		<!-- Main Form -->
		
		
		<div class="col-sm-8">
		
		
		<div class="login-form-1">
			<form id="login-form" class="text-left">
				<div class="login-form-main-message"></div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<label for="lg_username" class="sr-only">Username</label> <input
								type="text" class="form-control" id="lg_username"
								name="lg_username" placeholder="username">
						</div>
						<div class="form-group">
							<label for="lg_password" class="sr-only">Password</label> <input
								type="password" class="form-control" id="lg_password"
								name="lg_password" placeholder="password">
						</div>
						<div class="form-group login-group-checkbox">
							<input type="checkbox" id="lg_remember" name="lg_remember">
							<label for="lg_remember">remember</label>
						</div>
					</div>
					<button type="submit" class="login-button">
						<i class="fa fa-chevron-right"></i>
					</button>
				</div>
				<div class="etc-login-form">
					<p>
						forgot your password? <a href="#">click here</a>
					</p>
					<p>
						new user? <a href="#">create new account</a>
					</p>
				</div>
			</form>
			</div>
		</div>
		<!-- end:Main Form -->


		<%@ include file="pieb.jsp"%>
</body>

</html>