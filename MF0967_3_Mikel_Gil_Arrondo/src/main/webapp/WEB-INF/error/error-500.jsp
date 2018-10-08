<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" 
isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Error Page</title>
	
	<link rel="stylesheet" href="css/bootstrap-superhero-theme.min.css" />
    <link rel="stylesheet" href="css/estilos.css" />
    <link rel="shortcut icon" href="#" />
    
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 text-center">
				<img src="imgs/500.jpg" style="width:600px">
			</div>
		</div>
		<div class="row">
		<div class="col-md-4"></div>
			<div class="col-md-4 text-center">
				<div class="well">
				<p>Error: <%=exception.getMessage() %></p>
				<p>Please go to <a href="index">Home page</a></p>
				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>
