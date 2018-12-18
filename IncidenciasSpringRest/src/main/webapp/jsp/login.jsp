<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>login</title>
<script src="jquery/jquery.js"></script>
<script src="js/bootstrap3.7.min.js"></script>
<script src="js/login.js"></script>


<!-- Bootstrap core CSS -->

<link href="css/bootstrap4.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">

</head>
<body class="container-fluid">

	<div id="formWrapper">
		
			<div id="form">
			<form action="/">
			
				<div class="logo">
					<h1 class="text-center head">Incidencias</h1>
				</div>
				<div class="form-item">
					<p class="formLabel">usuario</p>
					<input type="text" name="email" id="email" class="form-style"
						autocomplete="off" />
				</div>
				<div class="form-item">
					<p class="formLabel">Password</p>
					<input type="password" name="password" id="password"
						class="form-style" />
					<!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->
				</div>
				<div class="form-item">
					<p class="pull-left">
						${error}
					</p>
					<button class="btn btn-secondary">Entrar</button>
					<div class="clear-fix"></div>
				</div>
		</form>
	</div>
	</div>
</body>
</html>