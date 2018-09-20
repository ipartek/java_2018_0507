<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel=stylesheet href="../css/bootstrap.min.css">
    <link rel=stylesheet href="../css/estilos.css">
    <link rel="stylesheet" href="css/fonts.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="shortcut icon" href="../imgs/favicon.ico" />
    <title>Supermercado Ana</title>
</head>

<body>
  
    <div class="jumbotron">
      <h1>Supermercado Ana</h1> 
    </div>
  
    <jsp:include page="menuprincipal.jsp" />
    
	  <div id="contenedor">
      
		  <div class="row">
			<div class="col-sm-2 col-sm-offset-1">
			<form id="aperitivos" action="../aniadiralcarrito"></form>
				  <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga.jpg" alt="Ron"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a1" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				   <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga2.jpg" alt="Cola"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a2" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
			  </div>
			  <div class="col-sm-2">
				  <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga.jpg" alt="Ron"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a3" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				   <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga2.jpg" alt="Cola"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a4" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
			  </div>
			  <div class="col-sm-2">
				  <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga.jpg" alt="Ron"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a5" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				   <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga2.jpg" alt="Cola"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a6" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				  
			  </div>
			  <div class="col-sm-2">
				  <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga.jpg" alt="Ron"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a7" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				   <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga2.jpg" alt="Cola"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a8" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				  
			  </div>
			  <div class="col-sm-2">
				  <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga.jpg" alt="Ron"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a9" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
				   <div class="aperitivo">
				 	<img class="aperitivofoto" src="../imgs/aperitivos/descarga2.jpg" alt="Cola"/> 
				  </div>
				  <div class="aperitivo">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <button type="submit" id="a10" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				  </div>
			  </div>
		</div>
</body>

<footer>
<br>
  <div id="pie">
       <i class="fas fa-envelope"></i>
        <p>Mail <a href="mailto:mail@mail.com"> mail@mail.com</a></p>
       <div id="iconredsocial">
           <img class="redsocial" src="../imgs/facebook.png" width="30px">
           <img class="redsocial" src="../imgs/twiter.png" width="30px">
           <img class="redsocial" src="../imgs/insta.jpg" width="30px">
       </div>
       <div >&copy;</div>
       <a href="politicapriva.jsp">Politica de privacidad - </a>
      <a href="contacto.jsp">Contacto - </a>
       <a href="localizacion.jsp">Localizacion</a>
   
   </div>
</footer>

</html>