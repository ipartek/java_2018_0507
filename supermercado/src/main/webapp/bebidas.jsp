<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel=stylesheet href="css/bootstrap.min.css">
    <link rel=stylesheet href="css/estilos.css">
    <link rel="stylesheet" href="css/fonts.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="shortcut icon" href="imgs/favicon.ico" />
    <title>Supermercado Ana</title>
</head>

<body>
  
    <div class="jumbotron">
      <h1>Supermercado Ana</h1> 
    </div>
  
    <jsp:include page="menuprincipal.jsp" />
   
	  <div id="contenedor">
     <form id="bebidas" action="AnadiralCarrito">
		  <div class="row">
			<div class="col-sm-2 col-sm-offset-1">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				         <a href="AnadiralCarrito?accion=add&id=1&nombre=bebi1&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/kas.jpg" alt="Cola" width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				         <a href="AnadiralCarrito?accion=add&id=2&nombre=bebi2&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/kas.jpg" alt="Ron" width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        <a href="AnadiralCarrito?accion=add&id=3&nombre=bebi3&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/mosto.jpg" alt="Cola"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        
				         <a href="AnadiralCarrito?accion=add&id=4&nombre=bebi4&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/ron.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				         <a href="AnadiralCarrito?accion=add&id=5&nombre=bebi5&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/tequila.jpg" alt="Cola"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				     
				         <a href="AnadiralCarrito?accion=add&id=6&nombre=bebi6&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				  
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        
				         <a href="AnadiralCarrito?accion=add&id=7&nombre=bebi7&precio=7" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Cola"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				         <a href="AnadiralCarrito?accion=add&id=8&nombre=bebi8&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				  
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				         <a href="AnadiralCarrito?accion=add&id=9&nombre=bebi9&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Cola"  width="200px" height="200px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				      
				        <a href="AnadiralCarrito?accion=add&id=10&nombre=bebi10&precio=22" class="btn-success"><i class="fas fa-shopping-cart"></i></a>
				       
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
           <img class="redsocial" src="imgs/facebook.png" width="30px">
           <img class="redsocial" src="imgs/twiter.png" width="30px">
           <img class="redsocial" src="imgs/insta.jpg" width="30px">
       </div>
       <div >&copy;</div>
       <a href="politicapriva.jsp">Politica de privacidad - </a>
      <a href="contacto.jsp">Contacto - </a>
       <a href="localizacion.jsp">Localizacion</a>
   
   </div>
</footer>

</html>