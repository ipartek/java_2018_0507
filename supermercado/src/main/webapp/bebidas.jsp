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
    
    
    
    
    
    
    <c:forEach items="${productos}" var="producto">
		<article>
			<dl>
				<dt>Nombre</dt>
				<dd>
					${producto.nombre} <a href="carrito?accion=add&id=${producto.id}">Añadir al
						carrito</a>
				</dd>
				<dt>Precio</dt>
				<dd><fmt:formatNumber value="${producto.precio}" type="currency"/></dd>
			</dl>
		</article>
	</c:forEach>
    
    
    
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
				        
				        <button id="1" name="1" value="1" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/kas.jpg" alt="Cola" width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				        <button id="2" name="2"  value="2" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				      
				  </div>
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/kas.jpg" alt="Ron" width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				        <button  id="3" name="3" value="3" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/mosto.jpg" alt="Cola"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        
				        <button  id="4" name="4" value="4" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				       
				  </div>
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/ron.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				        <button  id="5" name="5" value="5" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				       
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/tequila.jpg" alt="Cola"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				     
				        <button  id="6" name="6" value="6" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				      
				  </div>
				  
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				        
				        <button  id="7" name="7" value="7" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				      
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Cola"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				        <button  id="8" name="8" value="8" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				        
				  </div>
				  
			  </div>
			  <div class="col-sm-2">
				  <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Ron"  width="50px" height="50px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				       
				        <button  id="9" name="9" value="9" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				      
				  </div>
				   <div class="bebida">
				 	<img class="bebidafoto" src="imgs/bebidas/cola.jpg" alt="Cola"  width="200px" height="200px"/> 
				  </div>
				  <div class="bebida">
				 		<div class="preciotachado">30&euro;</div>
				        <div class="preciooferta">20&euro; </div>
				      
				        <button  id="10" name="10" value="10" type="submit" class="btn btn-success addcarrito"><i class="fas fa-shopping-cart"></i></button>  
				     
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